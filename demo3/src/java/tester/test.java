/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import basisobject.Account;
import dbaccess.AccountDao;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class test {
    public static void main(String[] args)
    {
        try
        {   ArrayList<Account> list = AccountDao.getAccounts();
            for(Account acc : list)
            {
                System.out.println(acc.toString());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
            
    }
        
        
}
