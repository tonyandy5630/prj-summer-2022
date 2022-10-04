/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sample.dto.Plant;
import sample.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class PlantDao {

    public static ArrayList<Plant> getPlants() {
        ArrayList<Plant> plantList = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'cateid',CateName\n"
                        + "from dbo.Categories,dbo.Plants\n"
                        + "where Categories.CateID=Plants.CateID";
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String desc = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");

                        Plant plant = new Plant(id, name, price, imgpath, desc, status, cateid, catename);
                        plantList.add(plant);
                    }
                    return plantList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Plant> getPlants(String keyword, String searchBy) {
        ArrayList<Plant> plantList = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null && searchBy != null) {
                String sql = "select PID, PName, price, imgPath, description, status, Plants.CateID as 'CateID', CateName \n"
                        + "from Plants join Categories on Plants.CateID = Categories.CateID\n";
                if (searchBy.equalsIgnoreCase("byname")) {
                    sql = sql + "where Plants.PName like ?";
                } else {
                    sql = sql + "where CateName like ?";
                }
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
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");

                        Plant plant = new Plant(id, name, price, imgpath, desc, status, cateid, catename);
                        plantList.add(plant);
                    }
                }
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
            if (cn != null) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'cateid',CateName\n"
                        + "from dbo.Categories,dbo.Plants\n"
                        + "where PID = ? and Plants.CateID = Categories.CateID";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, id);
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

    public static boolean addPlant(String name, Double price, String imgPath, String desc, int cateid) {
        Connection cn = null;
        String cateName = "";
        try {
            cn = DBUtils.makeConnection();
            String getCateSQL = "select  cate.CateName\n"
                    + "from Categories cate\n"
                    + "where cate.CateID = ?";
            PreparedStatement ps = cn.prepareStatement(getCateSQL);
            ps.setInt(1, cateid);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                cateName = rs.getString("CateName");
            }

            String addPlantSQL = "insert into Plants([PName],[price],[imgPath],[description],[status],[CateID])\n"
                    + "values (?,?,?,?,?,?)";
            ps = cn.prepareStatement(addPlantSQL);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, imgPath);
            ps.setString(4, desc);
            ps.setInt(5, 1);
            ps.setInt(6, cateid);

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean deletePlant(int id) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "delete from Plants\n"
                    + "where PID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updatePlant(int id, String newName, int newPrice, String newDesc, int newStatus, int newCateID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            String sql = "Update Plants\n"
                        + "set\n"
                        + "[PName] = ? ,[price] = ? ,[imgPath]='test',[description] = ?, [status] = ? ,[CateID] = ? \n"
                        + "where PID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setInt(2,newPrice);
            ps.setString(3, newDesc);
            ps.setInt(4, newStatus);
            ps.setInt(5, newCateID);
            ps.setInt(6, id);
            
            int rs = ps.executeUpdate();
            if(rs == 1)
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
