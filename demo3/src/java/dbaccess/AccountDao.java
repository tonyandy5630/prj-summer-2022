/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basisobject.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author ACER
 */
public class AccountDao {

    // ham de lay tat ca cac account trong bang Accounts
    public static ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> list = new ArrayList<>();

        // make connection
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select accID,email,password,fullname \n" + "from dbo.Accounts";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);

            if (table != null) {
                while (table.next()) {
                    int accID = table.getInt("accID");
                    String email = table.getString("email");
                    String password = table.getString("password");
                    String name = table.getString("fullname");
                    Account acc = new Account(accID, email, password, name);
                    list.add(acc);
                }
            }
        }
        return list;
    }

    public static Account getAccont(String email, String password) {
        Account acc = null;
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select acc.accID, acc.email, acc.fullname, acc.password, acc.phone, acc.role, acc.status \n"
                        + "from Accounts acc\n"
                        + "where email = ? and password = ? COLLATE Latin1_General_CS_AS \n"
                        + "and acc.status = 1";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet table = ps.executeQuery();
                if (table != null && table.next()) {
                    int accID = table.getInt("accID");
                    String fullname = table.getString("fullname");
                    String phone = table.getString("phone");
                    int status = table.getInt("status");
                    int role = table.getInt("role");

                    acc = new Account(accID, email, password, fullname, phone, role, status);
                    return acc;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public static ArrayList<Account> searchAccount(String keyword) {
        Account acc = null;
        ArrayList<Account> list  = new ArrayList<>();
        try {
            Connection cn = DBUtils.makeConnection();
            String sql = "select accID,[email],[password],[fullname],[phone],[status],[role]\n"
                    + "from dbo.Accounts\n"
                    + "where fullname like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,  "%" + keyword + "%");
            ResultSet table = ps.executeQuery();
            if (table != null) {
                while(table.next())
                {
                    int accID = table.getInt("accID");
                    String email = table.getString("email");
                    String password = table.getString("password");
                    String fullname = table.getString("fullname");
                    String phone = table.getString("phone");
                    int status = table.getInt("status");
                    int role = table.getInt("role");

                    acc = new Account(accID, email, password, fullname, phone, role, status);
                    list.add(acc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // insert a new account
    public static boolean insertAccount(String email, String password, String fullname, String phone, int status, int role) {
        try {
            Connection cn = DBUtils.makeConnection();
            String sql = "insert into Accounts(email,password,fullname,phone,status,role)\n"
                    + "values (?,?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, phone);
            ps.setInt(5, status);
            ps.setInt(6, role);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
