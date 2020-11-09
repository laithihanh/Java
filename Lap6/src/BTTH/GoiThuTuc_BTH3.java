/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class GoiThuTuc_BTH3 {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con =
        DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=qlsv","sa", "1234$");
        if (con != null) {
        System.out.println("Kết nối tới CSDL thành công!");
        } else {
        System.out.println("Không kết nối vào CSDL được");
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GoiThuTuc_BTH3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GoiThuTuc_BTH3.class.getName()).log(Level.SEVERE, null, ex);
        }
    //VIẾT LỆNH ĐỂ GỌI THỦ TỤC VÀ XỬ LÝ KẾT QUẢ
    CallableStatement cstmt;
    ResultSet rs;
        try {
            cstmt = con.prepareCall("{call GetAllSinhVien}");
            rs = cstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Sinh vien:");
                System.out.println("\tId:" + rs.getInt(1));
                System.out.println("\tRollnumber:" + rs.getString(2));
                System.out.println("\tName:" + rs.getString(3));
                System.out.println("\tAddress:" + rs.getString(4));
                System.out.println("\tPhone no:" + rs.getString(5));
                System.out.println("\tGender:" + (rs.getBoolean(6) ? "Male" : "Female"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoiThuTuc_BTH3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
