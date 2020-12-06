/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Bai1 {
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=qlsv";
	private final String USERNAME = "sa";
	private final String PASSWORD = "1234$";
	
	static Bai1 _instance;
	Connection connection;
	
	private Bai1() throws SQLException{
            try {
                Class.forName(DRIVER);
                this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                System.err.println("Lỗi kết nối:"+e.getMessage());
            }
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static Bai1 getInstance() throws SQLException{
		
		if(_instance == null) {
			_instance = new Bai1();
		}else if(_instance.getConnection().isClosed()) {
			_instance = new Bai1();
		}
		
		return _instance;
		
	}
        public static void main(String[] args) {
            try {
                Bai1 dbConnection = Bai1.getInstance();
            } catch (Exception e) {
            }
	}
}
