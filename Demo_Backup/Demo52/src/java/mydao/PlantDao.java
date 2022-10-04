/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import basicobject.Plant;
import mylib.DBUtils;

/**
 *
 * @author thanh
 */
public class PlantDao {

    public static int insertPlant(String name, int price, String imgpath, String description, int status, int cateid)
            throws Exception {
        int result = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "insert [dbo].[Plants]([PName],[price],[imgPath],[description],[status],[CateID])\n"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, price);
            pst.setString(3, imgpath);
            pst.setString(4, description);
            pst.setInt(5, status);
            pst.setInt(6, cateid);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

    public static ArrayList<Plant> getPlants(String keyword, String searchby) throws Exception {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null && searchby != null) {
                String sql = "Select [PID],[PName],[price],[imgPath],[description],[status], [dbo].[Plants].[CateID] as 'CateID', [CateName]\n"
                        + "From [dbo].[Plants] join [dbo].[Categories] on [dbo].[Plants].[CateID] = [dbo].[Categories].[CateID]\n";
                if (searchby.equalsIgnoreCase("byname")) {
                    sql = sql + "Where [dbo].[Plants].[PName] like ?";
                } else {
                    sql = sql + "Where [CateName] like ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public static ArrayList<Plant> getPlants(String name) throws Exception {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select PID,PName,price,imgPath,description,status,dbo.Plants.CateID as 'cateid',CateName\n"
                    + "from dbo.Categories,dbo.Plants\n"
                    + "where dbo.Categories.CateID=dbo.Plants.CateID\n"
                    + "      and PName like ?";

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("PID");
                    String pname = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateid = rs.getInt("cateid");
                    String catename = rs.getString("CateName");

                    Plant p = new Plant(id, pname, price, imgpath, description, status, cateid, catename);
                    list.add(p);
                }
            }
            cn.close();
        }
        return list;
    }

    public static Plant getPlant(int id) throws Exception {
        Plant p = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select PID,PName,price,imgPath,description,status,dbo.Plants.CateID as 'cateid',CateName\n"
                    + "from dbo.Categories,dbo.Plants\n"
                    + "where dbo.Categories.CateID=dbo.Plants.CateID\n"
                    + "      and PID = ?";

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    String pname = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateid = rs.getInt("cateid");
                    String catename = rs.getString("CateName");
                    p = new Plant(id, pname, price, imgpath, description, status, cateid, catename);

                }
            }
            cn.close();
        }
        return p;
    }
}
