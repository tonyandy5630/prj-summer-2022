/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import basicobject.Account;
import java.sql.SQLException;
import mylib.DBUtils;

/**
 *
 * @author thanhtra
 */
public class AccountDao {

    public static ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT accID, email, password, fullname,phone,status, role " + "FROM dbo.Accounts";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    int accid = table.getInt("accid");
                    String email = table.getString("email");
                    String password = table.getString("password");
                    String fullname = table.getString("fullname");
                    String phone = table.getString("phone");
                    int status = table.getInt("status");
                    int role = table.getInt("role");
                    Account acc = new Account(accid, email, password, fullname, phone, status, role);
                    list.add(acc);
                }
            }
            cn.close();
        }
        return list;
    }

    public static Account getAccount(String email, String password) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accid,email, password, fullname, phone, status, role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and email = ? and password = ? COLLATE Latin1_General_CS_AS ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accid");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Phone, Status, Role);
                }
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
        return acc;
    }

    public static Account getAccount(String token) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accid,email, password, fullname, phone, status, role, token\n"
                        + "from dbo.Accounts\n"
                        + "where token = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accid");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Phone, Status, Role);
                }
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
        return acc;
    }

    public static int updateAccountStatus(String email, int status) {
        int result = -1;
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Accounts]\n"
                        + "set [status] = ?\n"
                        + "where [email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setString(2, email);
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

    public static int updateToken(String email, String token) {
        int result = -1;
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Accounts]\n"
                        + "set [token] = ?\n"
                        + "where [email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                pst.setString(2, email);
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

    public static int updateAccount(String email, String newFullname, String newPhone) {
        int result = -1;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Accounts]\n"
                        + "set [fullname]= ?,[phone]=  ?\n"
                        + "where [email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newFullname);
                pst.setString(2, newPhone);
                pst.setString(3, email);
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

    public static boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone,
            int newStatus, int newRole) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into \n"
                        + "Accounts([email],[password],[fullname],[phone],[status],[role])\n"
                        + "values(?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newEmail);
                pst.setString(2, newPassword);
                pst.setString(3, newFullname);
                pst.setString(4, newPhone);
                pst.setInt(5, newStatus);
                pst.setInt(6, newRole);
                int result = pst.executeUpdate();
                if (result > 0) {
                    return true;
                }
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
        return false;
    }

    public static int insertAccount(String name, String phone) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {

            String sql = "insert Accounts(email,password,fullname,phone,status,role)\n"
                    + "values(null,null,?,?,1,0)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, phone);
            rs = pst.executeUpdate();
            cn.close();
        }

        return rs;
    }

    public static int getID() throws Exception {
        int accid = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select top 1 accID\n"
                    + "from dbo.Accounts\n"
                    + "order by accID desc";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                accid = rs.getInt("accID");
                cn.close();
            }

        }

        return accid;
    }
}
