/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.user;

/**
 *
 * @author Admin
 */
public class userDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public user checkUser(String userName) {
        String query = """
                       SELECT * FROM user 
                       WHERE username = ?;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void signup(String userName, String password, String fullname, String address, String email, String phone) {
        String query = """
                       INSERT INTO user (username, password, fullname, address, email, phone, isAdmin) 
                       VALUES (?, ?, ?, ?, ?, ?, 0);""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public user login(String userName, String password) {
        String query = """
                       SELECT * FROM user 
                       WHERE username = ? 
                       AND password = ?;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert(String userName, String password, String fullname, String address, String email, String phone, int isAdmin) {
        String query = """
                       INSERT INTO user (username, password, fullname, address, email, phone, isAdmin) 
                       VALUES (?, ?, ?, ?, ?, ?, ?);""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setInt(7, isAdmin);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(String uid) {
        String query = """
                       DELETE FROM user 
                       WHERE id = ?""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(int id, String userName, String password, String fullname, String address, String email, String phone, int isAdmin) {
        String query = """
                       UPDATE user
                       SET username = ?, password = ?, fullname = ?, address = ?, email = ?, phone = ?, isAdmin = ?
                       WHERE id = ?;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setInt(7, isAdmin);
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
        public void updateProfile(int id, String userName, String password, String fullname, String address, String email, String phone) {
        String query = """
                       UPDATE user
                       SET username = ?, password = ?, fullname = ?, address = ?, email = ?, phone = ?, isAdmin = 0
                       WHERE id = ?;""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<user> selectAll() {
        List<user> list = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public user getUserById(int id) {
        String query = """
                       SELECT * FROM user 
                       WHERE id = ?""";
        try {
            Connection conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new user(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
