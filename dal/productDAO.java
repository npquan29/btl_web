/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.product;

/**
 *
 * @author Admin
 */
public class productDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public static productDAO getInstance() {
        return new productDAO();
    }
//int, string, int, string, int, float, string
    public void insert(String name, int categoryId, String image, int quantity, float price, String description) {
        String query = """
                       INSERT INTO product (name, categoryId, image, quantity, price, description) 
                       VALUES (?, ?, ?, ?, ?, ?);""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, categoryId);
            ps.setString(3, image);
            ps.setInt(4, quantity);
            ps.setFloat(5, price);
            ps.setString(6, description);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int pid) {
        String query = """
                       DELETE FROM product
                       WHERE id = ?;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(product p) {
        String query = """
                       UPDATE product
                       SET NAME = ?, categoryId = ?, image=?, quantity = ?, price = ?, description= ?
                       WHERE id = ?""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getCid());
            ps.setString(3, p.getImage());
            ps.setInt(4, p.getQty());
            ps.setFloat(5, p.getPrice());
            ps.setString(6, p.getDes());
            ps.setInt(7, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<product> selectAll() {
        List<product> list = new ArrayList<>();
        String query = "SELECT * FROM product";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<product> getByCate(String cid) {

        List<product> list = new ArrayList<>();
        String query = """
                       SELECT * FROM product
                       where categoryId = ?""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> searchByKey(String key) {

        List<product> list = new ArrayList<>();
        String query = """
                       SELECT * FROM product
                       WHERE 1=1""";  
        try {
            Connection conn = DBContext.getConnection();
            if (key != null && !key.equals("")) {
                query += " and name like '%" + key + "%' or description like '%" + key + "%'";
            }
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> filterByKey(Double priceFrom, Double priceTo, String color) {

        List<product> list = new ArrayList<>();
        String query = """
                       SELECT * FROM product
                       WHERE 1=1""";  
        try {
            Connection conn = DBContext.getConnection();
            if (color != null && !color.equals("")) {
                query += " and description like '%" + color + "%'";
            }
            if (priceFrom != null) {
                query += " and price >= " + priceFrom;
            }
            if (priceTo != null) {
                query += " and price <= " + priceTo;
            }

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public product getProductById(int id) {
        String query = """
                       SELECT * FROM product 
                       WHERE id = ?""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
//    public void addOrder(user c, Cart1 cart) {
//        try {
//            String sql = "insert into btlweb3.order(user_id, product_id, amount, status) values(?, ?, ?, '1')";
//            Connection conn = DBContext.getConnection();
//            ps = conn.prepareStatement(sql);
//            for(Item i:cart.getItems()){
//                ps.setInt(1, c.getId());
//                ps.setInt(2, i.getProduct().getId());
//                ps.setInt(3, i.getQuantity());
//                ps.executeUpdate();
//            }
//            sql = "update btlweb3.product set qty=qty-? where id=?";
//            ps = conn.prepareStatement(sql);
//            for(Item i:cart.getItems()){
//                ps.setInt(1, i.getQuantity());
//                ps.setInt(2, i.getProduct().getId());
//                ps.executeUpdate();
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
    
}

