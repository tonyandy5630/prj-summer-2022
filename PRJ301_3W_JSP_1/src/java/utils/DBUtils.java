package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phant
 */
public class DBUtils {
    private static String url;
    public static Connection getConnection() 
            throws ClassNotFoundException, SQLException{
        Connection cn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        String sql = "jdbc:sqlserver://localhost:1433;databaseName=UserManagement;instanceName=458c20362e46";
        
        cn = DriverManager.getConnection(sql, "sa", "Password.1");
        
        return cn;

    }
}