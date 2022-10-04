/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mydao.AccountDao;

/**
 *
 * @author thanh
 */
public class TestUpdateAccount {
    public static void main(String[] args) {
        System.out.println(AccountDao.updateAccount("test@gmail.com", "12345", "newTestname", "09129012"));
    }
}
