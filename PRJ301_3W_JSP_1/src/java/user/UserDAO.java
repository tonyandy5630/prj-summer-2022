
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author phant
 */
public class UserDAO {
    
    private static final String LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=? AND status='True'";
    private static final String SEARCH = "SELECT userID, fullName, roleID, status FROM tblUsers WHERE fullName like ?";
    private static final String DELETE = "UPDATE tblUsers SET status=0 WHERE userID=?";
    private static final String UPDATE = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
    private static final String CHECK_ID = "SELECT userID FROM tblUsers WHERE userID=?";
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, roleID, password, status) VALUES (?,?,?,?,?)";
    
    public UserDTO checkLogin(String userID, String password) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                pst = conn.prepareStatement(LOGIN);
                pst.setString(1, userID);
                pst.setString(2, password);
                rs=pst.executeQuery();
                if (rs.next()){
                    String fullName=rs.getString("fullName");
                    String roleID=rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "*che*", true);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (rs!=null){
                rs.close();
            }
            if (pst!=null){
                pst.close();
            }
            if (conn!=null){
                conn.close();
            }                      
        }
        return user;
    }
    
    public List<UserDTO> getListUser (String search) throws SQLException{
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                pst = conn.prepareStatement(SEARCH);
                pst.setString(1, "%"+search+"%");
                rs = pst.executeQuery();
                while (rs.next()){
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    boolean status = rs.getBoolean("status");
                    listUser.add(new UserDTO(userID, fullName, roleID, password, status));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
        if(rs!=null) rs.close();
        if(pst!=null) pst.close();
        if(conn!=null) conn.close();
    }
        return listUser;
    }
    
    public boolean delete (String userID) throws SQLException{
        boolean result = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                psm = conn.prepareStatement(DELETE);
                psm.setString(1, userID);
                result = psm.executeUpdate()>0?true:false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (psm!=null){
                psm.close();
            }
            if (conn!=null){
                conn.close();
            }                      
        }
        return result;
    }
    
    public boolean update (UserDTO user) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                psm = conn.prepareStatement(UPDATE);
                psm.setString(1, user.getFullName());
                psm.setString(2, user.getRoleID());
                psm.setString(3, user.getUserID());
                check = psm.executeUpdate()>0?true:false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (psm!=null){
                psm.close();
            }
            if (conn!=null){
                conn.close();
            }                      
        }
        return check;
    }

    public boolean checkID(String userID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                pst = conn.prepareStatement(CHECK_ID);
                pst.setString(1, userID);
                rs=pst.executeQuery();
                if (rs.next()){
                    check = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (rs!=null){
                rs.close();
            }
            if (pst!=null){
                pst.close();
            }
            if (conn!=null){
                conn.close();
            }                      
        }
        return check;
    }
    
    public boolean insert (UserDTO user) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                psm = conn.prepareStatement(INSERT);
                psm.setString(1, user.getUserID());
                psm.setString(2, user.getFullName());
                psm.setString(3, user.getRoleID());
                psm.setString(4, user.getPassword());
                psm.setBoolean(5, true);
                check = psm.executeUpdate()>0?true:false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (psm!=null){
                psm.close();
            }
            if (conn!=null){
                conn.close();
            }                      
        }
        return check;
    }
    
    public boolean insertV2 (UserDTO user) throws SQLException, ClassNotFoundException, NamingException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                psm = conn.prepareStatement(INSERT);
                psm.setString(1, user.getUserID());
                psm.setString(2, user.getFullName());
                psm.setString(3, user.getRoleID());
                psm.setString(4, user.getPassword());
                psm.setBoolean(5, true);
                check = psm.executeUpdate()>0?true:false;
            }
                  
        }finally{
            if (psm!=null){
                psm.close();
            }
            if (conn!=null){
                conn.close();
            }                      
        }
        return check;
    }
}
