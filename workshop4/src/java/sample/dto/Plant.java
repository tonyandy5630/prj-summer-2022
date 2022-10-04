/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author ACER
 */
public class Plant {
    private int PID;
    private String PName;
    private int price;
    private String imgPath;
    private String description;
    private int status;
    private int cateId;
    private String cateName;
    public Plant() {
    }

    public Plant(int PID, String PName, int price, String imgPath, String description, int status, int cateId, String cateName) {
        this.PID = PID;
        this.PName = PName;
        this.price = price;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.cateId = cateId;
        this.cateName = cateName;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }


    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    @Override
    public String toString() {
        return "Plant{" + "PID=" + PID + ", PName=" + PName + ", price=" + price + ", imgPath=" + imgPath + ", description=" + description + ", status=" + status + '}';
    }
    
    
}
