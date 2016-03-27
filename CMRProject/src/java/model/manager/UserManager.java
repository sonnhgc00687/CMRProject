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
    
    public void createUser(String username, String password, String fullname, int role){
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            EncryptPassword encrypt = new EncryptPassword();
            String encryptedPassword = encrypt.encryptData(password);
            PreparedStatement ps = conn.prepareStatement("insert into tblEmployee values(?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, encryptedPassword);
            ps.setString(3, fullname);
            ps.setInt(4, role);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
