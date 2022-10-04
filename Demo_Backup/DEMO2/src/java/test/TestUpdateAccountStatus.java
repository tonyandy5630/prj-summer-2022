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
public class TestUpdateAccountStatus {

    public static void main(String[] args) {
        try {
            System.out.println(AccountDao.updateAccountStatus("tes@gmail.com", 1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
