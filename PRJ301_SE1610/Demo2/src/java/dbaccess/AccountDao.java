/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class AccountDao {
    //ham nay de lay tat ca account trong bang Accounts
    public static ArrayList<Account> getAllAccounts() throws Exception{
        ArrayList<Account> list=new ArrayList<>();
        //step1: make connection
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            //step 2: viet sql va execute no
            String sql = "select accID,email,password,fullname,phone,status,role\n"
                    + "from dbo.Accounts";
            Statement st=cn.createStatement();
            ResultSet table=st.executeQuery(sql);
            //step 3: xu li ket qua step 2
            if(table!=null){
                while(table.next()){
                    int accid=table.getInt("accID");
                    String email=table.getString("email");
                    String password=table.getString("password");
                    String fullname=table.getString("fullname");
                    String phone=table.getString("phone");
                    int status=table.getInt("status");
                    int role=table.getInt("role");
                    Account acc=new Account(accid, email, password, fullname, phone, status, role);
                    list.add(acc);
                }//het while
            }//het if
            cn.close();
        }
        return list;
    }

    //ham nay de lay 1 account dua vao email, password
   // input: email,password
   //out:tra ve 1 account obj
    public static Account getAccount(String email, String password) throws Exception{
      Account acc=null;
      Connection cn=DBUtils.makeConnection();
      if(cn!=null){
          String sql = "select accID,email,password,fullname,phone,status,role\n"
                  + "from dbo.Accounts\n"
                  + "where status=1 and email=? and password=? COLLATE Latin1_General_CS_AS"; 
          PreparedStatement pst=cn.prepareStatement(sql);
          //gan input params vao cac dau ?
          pst.setString(1, email);
          pst.setString(2, password);
          ResultSet table=pst.executeQuery();
          if(table!=null && table.next()){
              int accid=table.getInt("accID");
              String fullname=table.getString("fullname");
              String phone=table.getString("phone");
              int status=table.getInt("status");
              int role=table.getInt("role");
              acc=new Account(accid, email, password, fullname, phone, status, role);
          }
          cn.close();
      }      
      return acc;      
    }
    
    //ham nay de insert a new account vao bang Accounts
    //input:cac cot giong db
    //out: 1/0
    public static int insertAccount(String email,String password,String fullname, String phone,int status, int role) throws Exception{
        int result=0;
        Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            String sql = "insert dbo.Accounts(email,password,fullname,phone,status,role)\n"
                    + "values( ?,?,?,?,?,?)";   
            PreparedStatement pst=cn.prepareStatement(sql);
            //gan input params vao dau ?
            pst.setString(1,email);
            pst.setString(2,password);
            pst.setString(3,fullname);
            pst.setString(4,phone);
            pst.setInt(5,status);
            pst.setInt(6,role);
            result=pst.executeUpdate();
        }        
        return result;
    }
    public static Account getAccount(String email) throws Exception{
      Account acc=null;
      Connection cn=DBUtils.makeConnection();
      if(cn!=null){
          String sql = "select accID,email,password,fullname,phone,status,role\n"
                  + "from dbo.Accounts\n"
                  + "where   email=? "; 
          PreparedStatement pst=cn.prepareStatement(sql);
          //gan input params vao cac dau ?
          pst.setString(1, email);
          ResultSet table=pst.executeQuery();
          if(table!=null && table.next()){
              int accid=table.getInt("accID");
              String password=table.getString("password");
              String fullname=table.getString("fullname");
              String phone=table.getString("phone");
              int status=table.getInt("status");
              int role=table.getInt("role");
              acc=new Account(accid, email, password, fullname, phone, status, role);
          }
          cn.close();
      }      
      return acc;      
    } 
    
    //ham nay de lay all accounts co ten chua searchname
    public static ArrayList<Account> getAccounts(String searchname) throws Exception{
        ArrayList<Account> list=new ArrayList<>();
         Connection cn=DBUtils.makeConnection();
        if(cn!=null){
            //step 2: viet sql va execute no
            String sql = "select accID,email,password,fullname,phone,status,role\n"
                    + "from dbo.Accounts\n"
                    + "where fullname like ?";
             PreparedStatement pst=cn.prepareStatement(sql);
             pst.setString(1, "%"+ searchname+"%");
             ResultSet table=pst.executeQuery();
            //step 3: xu li ket qua step 2
            if(table!=null){
                while(table.next()){
                    int accid=table.getInt("accID");
                    String email=table.getString("email");
                    String password=table.getString("password");
                    String fullname=table.getString("fullname");
                    String phone=table.getString("phone");
                    int status=table.getInt("status");
                    int role=table.getInt("role");
                    Account acc=new Account(accid, email, password, fullname, phone, status, role);
                    list.add(acc);
                }//het while
            }//het if
            cn.close();
        }
        return list;
    }
}
