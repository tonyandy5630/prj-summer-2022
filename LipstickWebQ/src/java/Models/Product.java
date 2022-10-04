/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Acer
 */
public class Product {
    private String productid;
    private String productListID;
    private String name;
    private float price;
    private float discount;
    private String detail;
    private String images;

    public Product() {
    }

    public Product(String Productid, String ProductListID, String name, float price, float discount, String detail, String images) {
        this.productid = Productid;
        this.productListID = ProductListID;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.detail = detail;
        this.images = images;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String Productid) {
        this.productid = Productid;
    }

    public String getProductListID() {
        return productListID;
    }

    public void setProductListID(String ProductListID) {
        this.productListID = ProductListID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
}
