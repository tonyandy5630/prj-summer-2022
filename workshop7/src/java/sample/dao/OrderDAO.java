/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import sample.dto.Order;
import sample.dto.OrderDetail;
import sample.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class OrderDAO {

    public static ArrayList<Order> getOrders(String email) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [OrderID],CONVERT(varchar, OrdDate, 103) as 'OrdDate',CONVERT(varchar, shipdate, 103) as'shipdate',ord.[status],ord.[AccID]\n"
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
            String sql = "select  ord.AccID,CONVERT(varchar, OrdDate, 103) as 'OrdDate',ord.OrderID, ord.shipdate, ord.status \n"
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
            String sql = "select  ord.AccID,CONVERT(varchar, OrdDate, 103) as 'OrdDate',ord.OrderID, ord.shipdate, ord.status \n"
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0; // failed
    }

    public static ArrayList<OrderDetail> getOrderDetail(int orderID) {
        try {
            Connection cn = DBUtils.makeConnection();
            ArrayList<OrderDetail> orderList = new ArrayList<>();
            String sql = "select [DetailId],orDt.[OrderID],PID,PName,price,imgPath,[quantity]\n"
                    + "from OrderDetails orDt, Plants\n"
                    + "where orDt.OrderID = ?\n"
                    + "and orDt.FID = Plants.PID";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet table = ps.executeQuery();

            if (table != null) {
                while (table.next()) {
                    int dtID = table.getInt("DetailID");
                    int PlantID = table.getInt("PID");
                    String PlantName = table.getString("PName");
                    int price = table.getInt("price");
                    String imgPath = table.getString("imgPath");
                    int quantity = table.getInt("quantity");

                    OrderDetail orderDetail = new OrderDetail(dtID, orderID, PlantID, PlantName, price, imgPath, quantity);
                    orderList.add(orderDetail);
                }
            }
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean insertOrder(String email, HashMap<String, Integer> cart) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                int accid = 0;
                int orderid = 0;
                cn.setAutoCommit(false);
                String sql = "select accID\n"
                        + "from Accounts\n"
                        + "where Accounts.email=?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    accid = rs.getInt("accID");
                }
                Date d = new Date(System.currentTimeMillis());
                sql = "insert Orders(CONVERT(varchar, OrdDate, 103) as 'OrdDate',status,AccID)\n"
                        + "value(?,?,?)";
                ps = cn.prepareStatement(sql);
                ps.setDate(1, d);
                ps.setInt(2, 1);
                ps.setInt(3, accid);
                ps.executeUpdate();
                sql = "select top 1 OrderID\n"
                        + "from dbo.Orders\n"
                        + "order by OrderID desc";
                ps = cn.prepareStatement(sql);
                ResultSet table = ps.executeQuery();
                if (table != null) {
                    orderid = table.getInt("OrderID");
                }
                Set<String> pids = cart.keySet();
                for (String pid : pids) {
                    sql = "insert OrderDetails\n"
                            + "values(?,?,?)";
                    ps = cn.prepareStatement(sql);
                    ps.setInt(1, orderid); // order detail id
                    ps.setInt(2, Integer.parseInt(pid.trim())); // plant id
                    ps.setInt(3, cart.get(pid)); // quantity 
                    cn.setAutoCommit(true);
                }
                cn.close();
                return true;
            }
        } catch (Exception e) {
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static ArrayList<Order> filterDate(String from, String to, int id) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            ArrayList<Order> list = new ArrayList<>();
            String sql = "select [OrderID],CONVERT(varchar, OrdDate, 103) as 'OrdDate',CONVERT(varchar, shipdate, 103) as'shipdate',ord.[status],ord.[AccID]\n"
                    + "from Orders ord\n"
                    + "where ord.AccID = ?\n"
                    + "and OrdDate > ?\n"
                    + "and OrdDate < ?\n";

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, Date.valueOf(from));
            ps.setDate(3, Date.valueOf(to));
//            if (!from.isEmpty()) // only from date is passed in
//            {
//                sql = sql + "and OrdDate > ?\n";
//                ps.setDate(2, Date.valueOf(from));
//            }
//            
//            if (!to.isEmpty()) // only to date is passed in
//            {
//                sql = sql +  "and OrdDate < ?\n";
//                System.out.println("ORDERDATE");
//                ps.setDate(3, Date.valueOf(to));
//            }

            ResultSet table = ps.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String ordDate;
                    String shipDate;
                    int orderID;

                    orderID = table.getInt("OrderID");
                    ordDate = table.getString("OrdDate");
                    shipDate = table.getString("shipdate");
                    int status = table.getInt("status");
                    int accID = table.getInt("AccID");

                    Order ord = new Order(orderID, ordDate, shipDate, status, accID);
                    list.add(ord);
                }
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ArrayList<Order> getOrdersByDate(String from, String to, String searchBy) {
        Connection cn = null;
        if (from.isEmpty() && to.isEmpty()) {
            return getOrders(); // handle zero input
        }
        try {
            cn = DBUtils.makeConnection();
            ArrayList<Order> list = new ArrayList<>();
            String sql = "select [OrderID],CONVERT(varchar, OrdDate, 103) as 'OrdDate',CONVERT(varchar, shipdate, 103) as'shipdate',ord.[status],ord.[AccID]\n"
                    + "from Orders ord\n";
            
            if (!from.isEmpty()) {
                sql += "where " + searchBy + " >= ?\n";
                if (!to.isEmpty()) {
                    sql += "and " + searchBy + " <= ?\n";
                }
            } else if (from.isEmpty() && !to.isEmpty()) {
                sql += "where " + searchBy + " <= ?\n";
            }

            PreparedStatement ps = cn.prepareStatement(sql);

            if (!from.isEmpty()) {
                ps.setDate(1, Date.valueOf(from)); // set from date for first agrument
                if (!to.isEmpty()) {
                    ps.setDate(2, Date.valueOf(to)); // set to date for the second
                }
            } else if (from.isEmpty() && !to.isEmpty()) {
                ps.setDate(1, Date.valueOf(to)); // only to date is entered -> set to date to first argument
            }

            ResultSet table = ps.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String ordDate;
                    String shipDate;
                    int orderID;

                    orderID = table.getInt("OrderID");
                    ordDate = table.getString("OrdDate");
//                    ordDate =  myFormat.format(fromServer.parse(table.getString("OrdDate")));
                    shipDate = table.getString("shipdate");
                    int status = table.getInt("status");
                    int accID = table.getInt("AccID");

                    Order ord = new Order(orderID, ordDate, shipDate, status, accID);
                    list.add(ord);
                }
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ArrayList<Order> getOrders() {
        Connection cn = null;
        String ordDate;
        String shipDate;
        int orderID;
        int status;
        int accID;

        try {
            cn = DBUtils.makeConnection();
            ArrayList<Order> list = new ArrayList<>();
            String sql = "select [OrderID],CONVERT(varchar, OrdDate, 103) as 'OrdDate',CONVERT(varchar, shipdate, 103) as'shipdate',ord.[status],ord.[AccID]\n"
                    + "from Orders ord";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet table = ps.executeQuery();
            if (table != null) {
                while (table.next()) {
                    orderID = table.getInt("OrderID");
                    ordDate = table.getString("OrdDate");
                    shipDate = table.getString("shipdate");
                    status = table.getInt("status");
                    accID = table.getInt("AccID");

                    Order ord = new Order(orderID, ordDate, shipDate, status, accID);
                    list.add(ord);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
