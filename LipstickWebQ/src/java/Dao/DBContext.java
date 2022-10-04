/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Product;
import Models.User;
import Models.brand;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class DBContext {

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Lipstick";
        String user = "sa";
        String pass = "12345";
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    //check user
    public static boolean checkLogin(String account, String password) {

        Connection con = DBContext.getConnection();
        String sql = "select * from  users where account=? and password= ?";
        List<User> list = null;
        User user = new User();
        try {
            list = new ArrayList<>();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, account);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Product
    public static Product getProductByID(String id) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "select * from Products "
                + "where ProductID = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = stm.executeQuery();
        Product pro = null;
        if (rs.next()) {
            pro = new Product();
            pro.setProductid(rs.getString("ProductID"));
            pro.setProductListID(rs.getString("ProductListID"));
            pro.setName(rs.getString("ProductName"));
            pro.setDetail(rs.getString("Detail"));
            pro.setPrice(rs.getFloat("price"));
            pro.setDiscount(rs.getFloat("discount"));
            pro.setImages(rs.getString("image"));
        }
        return pro;
    }

    public static List<Product> searchProduct(String search) {
        Connection con = DBContext.getConnection();
        String sql = "select * from Products "
                + "where ProductName like ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductid(rs.getString("ProductID"));
                pro.setProductListID(rs.getString("ProductListID"));
                pro.setName(rs.getString("ProductName"));
                pro.setDetail(rs.getString("Detail"));
                pro.setPrice(rs.getFloat("price"));
                pro.setDiscount(rs.getFloat("discount"));
                pro.setImages(rs.getString("image"));
                list.add(pro);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Product> getAllProduct() {
        Connection con = DBContext.getConnection();
        String sql = "select * from Products";
        List<Product> list = null;
        try {
            list = new ArrayList<>();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductid(rs.getString("ProductID"));
                pro.setProductListID(rs.getString("ProductListID"));
                pro.setName(rs.getString("ProductName"));
                pro.setDetail(rs.getString("Detail"));
                pro.setPrice(rs.getFloat("price"));
                pro.setDiscount(rs.getFloat("discount"));
                pro.setImages(rs.getString("image"));
                list.add(pro);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Product> getProductByBrand(String brandID) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "select * from Products "
                + "where ProductListID = ?";
        List<Product> list = new ArrayList<>();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, brandID);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Product pro = new Product();
            pro.setProductid(rs.getString("ProductID"));
            pro.setProductListID(rs.getString("ProductListID"));
            pro.setName(rs.getString("ProductName"));
            pro.setDetail(rs.getString("Detail"));
            pro.setPrice(rs.getFloat("price"));
            pro.setDiscount(rs.getFloat("discount"));
            pro.setImages(rs.getString("image"));
            list.add(pro);
        }
        return list;
    }

    //Brand
    public static List<brand> getAllBrand() {
        Connection con = DBContext.getConnection();
        String sql = "select * from Brand";
        List<brand> list = null;
        try {
            list = new ArrayList<>();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                brand br = new brand();
                br.setBranID(rs.getString("BrandID"));
                br.setBrandName(rs.getString("BrandName"));
                list.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void register(String account, String pass) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "insert into Users(account,Password) values(?,?)";
        PreparedStatement stm = con.prepareCall(sql);
        stm.setString(1, account);
        stm.setString(2, pass);
        stm.executeUpdate();
    }
}
