/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class product {

    private int id;
    private String name;
    private int categoryId;
    private String image;
    private int quantity;
    private float price;
    private String description;

    public product() {
    }

    public product(int id, String name, int cid, String image, int qty,float price, String des) {
        this.id = id;
        this.name = name;
        this.categoryId = cid;
        this.image = image;
        this.price = price;
        this.quantity = qty;
        this.description = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCid() {
        return categoryId;
    }

    public void setCid(int cid) {
        this.categoryId = cid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return quantity;
    }

    public void setQty(int qty) {
        this.quantity = qty;
    }

    public String getDes() {
        return description;
    }

    public void setDes(String des) {
        this.description = des;
    }
    
    
}
