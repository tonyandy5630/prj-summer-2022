/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mydao.PlantDao;

/**
 *
 * @author thanh
 */
public class TestInsertPlant {

    public static void main(String[] args) {
        try {
            int result = PlantDao.insertPlant("test", 10, "imgpath", "description", 1, 1);
            if (result > 0) {
                System.out.println("ok");
            } else {
                System.out.println("no ok");
            }
        } catch (Exception e) {

        }
    }
}
