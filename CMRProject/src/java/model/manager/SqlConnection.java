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
//            String url = "jdbc:sqlserver://SONNGUYEN\\SQLEXPRESS:1433;databaseName=Project_CMR";
            //String url = "jdbc:sqlserver://PHUC-PC:1433;databaseName=Project_CMR";

            String url = "jdbc:sqlserver://DELL-PC:1433;databaseName=Project_CMR";
            String hosturl = "jdbc:sqlserver://group1cmr.database.windows.net:1433;database=Project_CMR;user=mainghia@group1cmr;password=Asdf1234;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

//            String url = "jdbc:sqlserver://DELL:1433;databaseName=Project_CMR";
//            conn = DriverManager.getConnection(url,dbUser,dbPassword);
            conn = DriverManager.getConnection(hosturl);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
