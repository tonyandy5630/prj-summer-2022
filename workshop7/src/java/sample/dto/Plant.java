/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class Plant implements Serializable{
    private int id;
    private String name;
    private int price;
    private String imgpath;
    private String description;
    private int status;
    private int cateid;
    private String catename;
    
    public Plant() {
    }

    public Plant(int PID, String PName, int price, String imgPath, String description, int status, int cateId, String cateName) {
        this.id = PID;
        this.name = PName;
        this.price = price;
        this.imgpath = imgPath;
        this.description = description;
        this.status = status;
        this.cateid = cateId;
        this.catename = cateName;
    }

    public int getCateId() {
        return cateid;
    }

    public void setCateId(int cateId) {
        this.cateid = cateId;
    }

    public String getCateName() {
        return catename;
    }

    public void setCateName(String cateName) {
        this.catename = cateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int PID) {
        this.id = PID;
    }

    public String getName() {
        return name;
    }

    public void setName(String PName) {
        this.name = PName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    @Override
    public String toString() {
        return "Plant{" + "PID=" + id + ", PName=" + name + ", price=" + price + ", imgPath=" + imgpath + ", description=" + description + ", status=" + status + '}';
    }
    
    
}
