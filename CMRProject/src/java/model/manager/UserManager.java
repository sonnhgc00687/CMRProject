/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.User;

/**
 *
 * @author Son
 */
public class UserManager {

    List<User> userList = new ArrayList<>();
    List<User> userSearch = new ArrayList<>();

    public User checkUser(String username, String pass) {
        boolean status = false;
        User user = null;
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select * from tblEmployee where username = ? and [password] = ?");
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            if (status) {
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        boolean status = false;
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select * from tblEmployee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                userList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void createUser(String username, String password, String fullname, String email, int role) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            EncryptPassword encrypt = new EncryptPassword();
            String encryptedPassword = encrypt.encryptData(password);
            PreparedStatement ps = conn.prepareStatement("insert into tblEmployee values(?,?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, encryptedPassword);
            ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setInt(5, role);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(String username, String password, String fullname, String email, int role) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            EncryptPassword encrypt = new EncryptPassword();
            String encryptedPassword = encrypt.encryptData(password);
            PreparedStatement ps = conn.prepareStatement("update tblEmployee set [password]=?, fullname = ?, email=?, role=?\n"
                    + "where username=?");
            ps.setString(1, encryptedPassword);
            ps.setString(2, fullname);
            ps.setString(3, email);
            ps.setInt(4, role);
            ps.setString(5, username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<User> searchUserByNameOrID(String username, String fullname){
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select * from tblEmployee where username = ? or fullname=?");
            ps.setString(1, username);
            ps.setString(2, fullname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                userSearch.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userSearch;
    }
    
    public void deleteUserByUsername(String username){
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("delete tblEmployee where username = ?");
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
