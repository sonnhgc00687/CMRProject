/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Son
 */
public class UserManager {
    
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
}
