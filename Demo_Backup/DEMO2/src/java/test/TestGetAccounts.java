/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

import basicobject.Account;
import mydao.AccountDao;

/**
 *
 * @author thanhtra
 */
public class TestGetAccounts {
    public static void main(String[] args) {
        try {
            ArrayList<Account> list = AccountDao.getAccounts();
            for(Account acc: list){
                System.out.println(acc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
