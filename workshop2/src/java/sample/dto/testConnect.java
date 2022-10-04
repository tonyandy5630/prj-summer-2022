/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.util.ArrayList;
import sample.dao.PlantDao;

/**
 *
 * @author ACER
 */
public class testConnect {
    public static void main(String[] args)
    {
        
        ArrayList<Plant> list = PlantDao.getPlants("tulips", "byname");
        for(Plant plant : list)
        {
            System.out.println(plant.toString());
        }
    }
}
