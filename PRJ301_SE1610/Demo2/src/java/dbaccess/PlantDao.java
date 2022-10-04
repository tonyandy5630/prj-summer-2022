/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Plant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author ACER
 */
public class PlantDao {

    public static ArrayList<Plant> getPlants(String keyword) {
        ArrayList<Plant> plantList = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null ) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'cateid',CateName\n"
                        + "from dbo.Categories,dbo.Plants\n"
                        + "where Categories.CateID=Plants.CateID and PName like ? ";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String desc = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("cateid");
                        String catename = rs.getString("CateName");

                        Plant plant = new Plant(id, name, price, imgpath, desc, status, cateid, catename);
                        plantList.add(plant);
                    }
                }
                return plantList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plantList;
    }
    
    public static Plant getPlant(int id) {
        Plant plant = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null ) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'cateid',CateName\n"
                        + "from dbo.Categories,dbo.Plants\n"
                        + "where PID = ? ";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String desc = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("cateid");
                        String catename = rs.getString("CateName");

                        plant = new Plant(id, name, price, imgpath, desc, status, cateid, catename);
                        return plant;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
