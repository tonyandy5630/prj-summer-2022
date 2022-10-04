/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.util.ArrayList;
import sample.dao.AccountDao;

/**
 *
 * @author ACER
 */
public class testConnectoin {

    public static void main(String[] args) {
        ArrayList<Account> accList;
        try
        {    
            accList = AccountDao.getAccounts();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Account acc = AccountDao.getAccont("abc@gmail", "2011");

        if (acc != null) {
            if (acc.getRole() == 1) {
                System.out.println("i am an admin");
                System.out.println(acc.toString());
            } else {
                System.out.println("user");
                System.out.println(acc.toString());
            }
            
            /// test challenge 2
            System.out.println("");
            if (AccountDao.updateAccountStatus(acc.getEmail(), 1)) {
                System.out.println("updating...");
                System.out.println("account after update status:");
                System.out.println(acc.toString());
            }
            else
            {
                System.out.println("Update status fail");
            }
            
            System.out.println("");
            
            // test challenge 3
            String newPass = "2011";
            String newFullname = "bui thanh tu";
            String newPhone = "0123";
            
            boolean success = AccountDao.updateAccount(acc.getEmail(), newPass, newFullname, newPhone);
            if(success)
            {
                System.out.println("update successfully");
                System.out.println(acc.toString());
            }
            else
            {
                System.out.println("update failed");
            }
            System.out.println("");
            
            String email = "tonyandy789@gmail.com";
            String password = "123";
            String fullname = "bui thanh tu";
            String phone = "0123";
            int status = 1;
            int role = 1;
            
            boolean isInserted = AccountDao.insertAccount(email, password, fullname, phone, status, role);
            if(isInserted)
            {
                System.out.println("inserted successfully");
                System.out.println(AccountDao.getAccont(email, password).toString()); // print new one to sreen
            }
        } 
        else {
            System.out.println("fail");
        }
        
    }
}
