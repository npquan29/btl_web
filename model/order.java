/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Admin
 */
import java.util.Date;
public class order {
    
    private int id;
    private int userId;
    private float totalMoney;
    private int status;
    private Date orderDate;

    public order() {
    }
    public order(int id, int userId, float totalMoney, int status, Date orderDate) {
        this.id = id;
        this.userId = userId;
        this.totalMoney = totalMoney;
        this.status = status;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setAmount(int status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setStatus(Date orderDate) {
        this.orderDate = orderDate;
    }

}
