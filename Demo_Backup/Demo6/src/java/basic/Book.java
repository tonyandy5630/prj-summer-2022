/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.io.Serializable;

/**
 *
 * @author thanhtra
 */
public class Book implements Serializable {
    private int id;
    private String title;
    private int price;

    public Book(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Book() {
        id = 0;
        title = "";
        price = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String changeCase(){
        return title.toUpperCase();
    }
}
