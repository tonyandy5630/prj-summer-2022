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
public class TestInsertAccount {

    public static void main(String[] args) {
        try {
            System.out.println(AccountDao.insertAccount("newEmail", "newPassword", "newFullname", "newPhone", 1, 0));
        } catch (Exception e) {
        }
    }
}
