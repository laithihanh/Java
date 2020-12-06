/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Connect {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String BD_URL = "jdbc:sqlserver://localhost:1433;databaseName=qlsv";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1234$";
    public static Connection getConnection(){
        Connection con = null;
        if(con ==null){
            try {
                Class.forName(DRIVER);
                con =DriverManager.getConnection(BD_URL,USERNAME,PASSWORD);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return con;
    }
}
