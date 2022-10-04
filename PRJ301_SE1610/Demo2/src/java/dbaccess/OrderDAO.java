/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import mylib.DBUtils;

/**
 *
 * @author ACER
 */
public class OrderDAO {

    public static int insertOrder(int accid, HashMap<String, Integer> cart) {
        try {
            Connection cn = DBUtils.makeConnection();
            cn.setAutoCommit(false);
            String sql = "insert dbo.Orders(OrdDate,shipdate,status,AccID)\n"
                    + "values(?,null,1,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, new Date(System.currentTimeMillis()));
            ps.setInt(2, accid);
            int rs = ps.executeUpdate();
            sql = "select top 1 OrderID\n"
                    + "from dbo.Orders\n"
                    + "order by OrderID desc";
            ps = cn.prepareStatement(sql);
            ResultSet table = ps.executeQuery();
            if (table != null) {
                int orderid = table.getInt("OrderID");
                for (String id : cart.keySet()) {
                    int quantity = cart.get(id);
                    sql = "insert dbo.OrderDetails(OrderID,FID,quantity)\n"
                            + "values(?,?,?)";
                    ps = cn.prepareStatement(sql);
                    ps.setInt(1, orderid);
                    ps.setInt(2, Integer.parseInt(id.trim()));
                    ps.setInt(3, quantity);
                    rs = ps.executeUpdate();
                }
            }
            cn.commit();
            cn.setAutoCommit(true);
            cn.close();
        } catch (Exception e) {
        }
        return 0;
    }

    public static ArrayList<Order> getOrders(String email) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [OrderID],[OrdDate],[shipdate],ord.[status],ord.[AccID]\n"
                        + "from Orders ord, Accounts acc\n"
                        + "where acc.email = ?\n"
                        + "and ord.AccID = acc.accID ";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet table = ps.executeQuery();
                ArrayList<Order> orderList = new ArrayList<>();
                if (table != null) {
                    int orderID;
                    String ordDate;
                    String shipDate;
                    int status;
                    int accID;

                    Order ord;
                    while (table.next()) {
                        orderID = table.getInt("OrderID");
                        ordDate = table.getString("OrdDate");
                        shipDate = table.getString("shipdate");
                        status = table.getInt("status");
                        accID = table.getInt("AccID");

                        ord = new Order(orderID, ordDate, shipDate, status, accID);
                        orderList.add(ord);
                    }
                    return orderList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Order> getOrderByStatus(int accID, int status) {
        try {
            Connection cn = DBUtils.makeConnection();
            ArrayList<Order> list = new ArrayList<>();
            String sql = "select  ord.AccID,ord.OrdDate,ord.OrderID, ord.shipdate, ord.status \n"
                    + "from Orders ord\n"
                    + "left join Accounts acc\n"
                    + "on acc.accID = ?\n"
                    + "where ord.AccID = acc.accID\n"
                    + "and ord.status = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, accID);
            ps.setInt(2, status);
            ResultSet table = ps.executeQuery();

            if (table != null) {
                while (table.next()) {
                    String ordDate;
                    String shipDate;
                    int orderID;
                    orderID = table.getInt("OrderID");
                    ordDate = table.getString("OrdDate");
                    shipDate = table.getString("shipdate");
                    status = table.getInt("status");

                    Order ord = new Order(orderID, ordDate, shipDate, status, accID);
                    list.add(ord);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Order getOrderByID(int orderID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "select  ord.AccID,ord.OrdDate,ord.OrderID, ord.shipdate, ord.status \n"
                    + "from Orders ord\n"
                    + "where ord.OrderID= ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet table = ps.executeQuery();
            Order ord = null;
            if (table != null) {
                while (table.next()) {
                    String ordDate;
                    String shipDate;
                    int status;

                    ordDate = table.getString("OrdDate");
                    shipDate = table.getString("shipdate");
                    status = table.getInt("status");
                    int accID = table.getInt("AccID");
                    ord = new Order(orderID, ordDate, shipDate, status, accID);
                }
                return ord;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int reOrder(int orderID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "update Orders \n"
                    + "set\n"
                    + "status = 1\n"
                    + "where OrderID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, orderID);
            int table = ps.executeUpdate();
            if (table == 1) {
                return 1; // succeed
            }
        } catch (Exception e) {
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0; // failed
    }

//    public static ArrayList<OrderDetail> getOrderDetail(int orderID) {
//        try {
//            Connection cn = DBUtils.makeConnection();
//            ArrayList<OrderDetail> orderList = new ArrayList<>();
//            String sql = "select [DetailId],orDt.[OrderID],PID,PName,price,imgPath,[quantity]\n"
//                    + "from OrderDetails orDt, Plants\n"
//                    + "where orDt.OrderID = ?\n"
//                    + "and orDt.FID = Plants.PID";
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ps.setInt(1, orderID);
//            ResultSet table = ps.executeQuery();
//
//            if (table != null) {
//                while (table.next()) {
//                    int dtID = table.getInt("DetailID");
//                    int PlantID = table.getInt("PID");
//                    String PlantName = table.getString("PName");
//                    int price = table.getInt("price");
//                    String imgPath = table.getString("imgPath");
//                    int quantity = table.getInt("quantity");
//
//                    OrderDetail orderDetail = new OrderDetail(dtID, orderID, PlantID, PlantName, price, imgPath, quantity);
//                    orderList.add(orderDetail);
//                }
//            }
//            return orderList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
