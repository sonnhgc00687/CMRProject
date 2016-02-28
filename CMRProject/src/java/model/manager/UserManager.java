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
    
    public boolean checkUser(String user, String pass) {
        boolean status = false;
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select * from tblEmployee where username = ? and [password] = ?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    public List<User> getAllUsers() {
        boolean status = false;
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select * from tblEmployee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                userList.add(user);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
