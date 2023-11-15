/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class category {
    private int id;
    private String name;

    public category() {
    }

    public category(int cid, String cname) {
        this.id = cid;
        this.name = cname;
    }

    public int getId() {
        return id;
    }

    public void setId(int cid) {
        this.id = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String cname) {
        this.name = cname;
    }
    
}
