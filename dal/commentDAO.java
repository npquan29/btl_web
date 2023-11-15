/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.comment;
import model.user;

/**
 *
 * @author Admin
 */
public class commentDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<comment> selectAllByProductId(int productId) {
        List<comment> list = new ArrayList<>();
        String query = """
                       SELECT *
                       FROM comment
                       WHERE productId_cmt = ?
                       ORDER BY id DESC;""";

        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                comment c = new comment(rs.getLong("id"),
                        rs.getInt("userId_cmt"),
                        rs.getInt("productId_cmt"),
                        rs.getDate("createAt"),
                        rs.getDate("updateAt"),
                        rs.getString("content"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<user> getUserByProductId(int productId) {
        List<user> list = new ArrayList<>();
        String query = """
                       SELECT u.*
                       FROM user u
                       JOIN comment c ON u.id = c.userId_cmt
                       WHERE c.productId_cmt = ?
                       ORDER BY c.id DESC;""";

        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user u = new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void AddReview(int productId, int userId, Date createAt, Date updateAt, String content){
        String query = "INSERT INTO comment (productId_cmt, userId_cmt, createAt, updateAt, content) VALUES (?, ?, ?, ?, ?);";    
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.setDate(3, createAt);
            ps.setDate(4, updateAt);
            ps.setString(5, content);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
