/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import basicobject.Account;
import mydao.AccountDao;

/**
 *
 * @author thanh
 */
public class TestConnection {
    public static void main(String[] args) {
        Account acc = AccountDao.getAccount("thanhtra2001.stt@gmail.com", "123456");
        if (acc != null) {
            if (acc.getRoles() == 1)
                System.out.println("I am a admin");
            else
                System.out.println("I am a user");

        } else
            System.out.println("Login fail");
    }
}