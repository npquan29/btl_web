/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.order;
import model.product;

/**
 *
 * @author Admin
 */
public class orderDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
//    private int id;
//    private int userId;
//    private float totalMoney;
//    private int status;
//    private Date orderDate;
    public List<order> selectAll(int userId) {
        List<order> list = new ArrayList<>();
        String query = "SELECT * FROM order where userId = ?;";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                order o = new order(rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getFloat("totalMoney"),
                        rs.getInt("status"),
                        rs.getDate("orderDate"));
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<order> selectByStatus(int userId, int page) {
        List<order> list = new ArrayList<>();
        String query = "SELECT * FROM order where userId = ? and status = ?;";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, page);
            rs = ps.executeQuery();
            while (rs.next()) {
                order o = new order(rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getFloat("totalMoney"),
                        rs.getInt("status"),
                        rs.getDate("orderDate"));
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<product> getAllProductByOrder(int userId) {
        List<product> list = new ArrayList<>();
        String query = """
                       SELECT product.* FROM order
                       JOIN product ON order.productId = product.id
                       WHERE order.userId = ? ;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
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
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public List<product> getProductByOrder(int userId, String status) {
        List<product> list = new ArrayList<>();
        String query = """
                       SELECT product.*
                       FROM order
                       JOIN product ON order.productId = product.id
                       WHERE order.userId = ? AND order.status = ?
                       GROUP BY product.id, order.status;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, status);
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
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    public void updateStatus(int orderId) {        
        String query = "UPDATE order SET status = '4' WHERE id = ?;";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
   
}
