/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import basicobject.Account;
import dbaccess.AccountDao;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Tester {
    public static void main(String[] args) {
        try {
            ArrayList<Account> list=AccountDao.getAllAccounts();
            for (Account account : list) {
                System.out.println(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
