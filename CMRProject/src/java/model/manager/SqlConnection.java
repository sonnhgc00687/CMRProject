/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Son
 */
public class SqlConnection {
    public Connection connectSql() {
        Connection conn;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUser = "sa";
            String dbPassword = "123456";
<<<<<<< HEAD
            String url = "jdbc:sqlserver://SONNGUYEN\\SQLEXPRESS:1433;databaseName=Project_CMR";
            //String url = "jdbc:sqlserver://PHUC-PC:1433;databaseName=Project_CMR";
//            String url = "jdbc:sqlserver://DELL-PC:1433;databaseName=Project_CMR";
=======

//            String url = "jdbc:sqlserver://SONNGUYEN\\SQLEXPRESS:1433;databaseName=Project_CMR";
            //String url = "jdbc:sqlserver://PHUC-PC:1433;databaseName=Project_CMR";
            String url = "jdbc:sqlserver://DELL-PC:1433;databaseName=Project_CMR";

>>>>>>> 7576a9bfbf5e79ad406c1d333d3a201ec441f16d
//            String url = "jdbc:sqlserver://DELL:1433;databaseName=Project_CMR";
            conn = DriverManager.getConnection(url, dbUser, dbPassword);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
