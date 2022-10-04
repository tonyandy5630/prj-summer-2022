/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sample.dto.Category;
import sample.utils.DBUtils;

/**
 *
 * @author ACER
 */
public class CateDao {

    public static ArrayList<Category> getCateName() {
        Connection cn = null;
        ArrayList<Category> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            String sql = "select  cate.CateName, cate.CateID\n"
                    + "from Categories cate";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String cateName = rs.getString("CateName");
                    int CateID = rs.getInt("CateID");
                    Category cat = new Category(CateID,cateName);
                    
                    list.add(cat);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
