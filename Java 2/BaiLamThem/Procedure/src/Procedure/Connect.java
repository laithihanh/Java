/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Connect {
    private static final String HOST = "jdbc:sqlserver://localhost:1433;databaseName=ProductManagement";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1234$";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi kết nối CSDL" + e.getMessage());
        }
        return conn;
    }
}
