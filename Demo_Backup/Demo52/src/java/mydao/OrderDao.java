/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import basicobject.Order;
import basicobject.OrderDetail;
import java.sql.SQLException;
import mylib.DBUtils;

/**
 *
 * @author thanh
 */
public class OrderDao {

    public static ArrayList<Order> getOrders(String email) throws Exception {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [OrderID],[OrdDate],[shipdate],[dbo].[Orders].[status] as 'status' ,[dbo].[Orders].[AccID] as 'AccID'\n"
                    + "from [dbo].[Orders],[dbo].[Accounts]\n"
                    + "where [dbo].[Orders].[AccID]=[dbo].[Accounts].[accID]\n"
                    + "and [email] like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                String orderDate = rs.getString("OrdDate");
                String shipDate = rs.getString("shipdate");
                int status = rs.getInt("status");
                int accID = rs.getInt("AccID");
                Order order = new Order(orderId, orderDate, shipDate, status, accID);
                list.add(order);
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<OrderDetail> getOrderDetail(int orderID) throws Exception {
        ArrayList<OrderDetail> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select [DetailId],[OrderID],[FID],[quantity]\n"
                    + "from [dbo].[OrderDetails]\n"
                    + "where [OrderID]=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int detailId = rs.getInt("DetailId");
                int orderId = rs.getInt("OrderID");
                int FID = rs.getInt("FID");
                int quantity = rs.getInt("quantity");
                OrderDetail orderDetail = new OrderDetail(detailId, orderId, FID, quantity);
                list.add(orderDetail);
            }
            cn.close();
        }
        return list;
    }

    public static int updateOrderStatus(int orderID, int status) {
        int result = -1;
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Orders]\n"
                        + "set [status] = ?\n"
                        + "where [OrderID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setInt(2, orderID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return result;
    }

    public static int  insertOrder(int accID, HashMap<String, Integer> cart) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            cn.setAutoCommit(false);
            String sql = "insert dbo.Orders(OrdDate,shipdate,status,AccID)\n"
                    + "values(?,null,1,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setDate(1, new Date(System.currentTimeMillis()));
            pst.setInt(2, accID);
            rs = pst.executeUpdate();
            // insert orderDetail
            sql = "select top 1 OrderID\n"
                    + "from dbo.Orders\n"
                    + "order by OrderID desc";
            pst = cn.prepareStatement(sql);
            ResultSet table = pst.executeQuery();

            if (table != null && table.next()) {
                int orderID = table.getInt("orderID");
                for (String id : cart.keySet()) {
                    int quantity = cart.get(id);
                    sql = "insert dbo.OrderDetails(OrderID,FID,quantity)\n"
                            + "values(?,?,?)";
                    pst.setInt(1, orderID);
                    pst.setInt(2, Integer.parseInt(id));
                    pst.setInt(3, quantity);
                    rs = pst.executeUpdate();
                }
            }
            cn.commit();
            cn.setAutoCommit(true);
            cn.close();
        }
        return rs;
    }
}
