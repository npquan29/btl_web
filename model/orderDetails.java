/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mr.Thai
 */
public class orderDetails {
    private int orderId;
    private int productId;
    private long quantity;
    private float price;
    
    public orderDetails(){
        
    }
    public orderDetails(int orderId, int productId, long quantity, float price){
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    public int getProductId(){
        return productId;
    }
    public void setProductId(int productId){
        this.productId = productId;
    }
    public long getQuantity(){
        return quantity;
    }
    public void setQuantity(long quantity){
        this.quantity = quantity;
    }
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }
}
