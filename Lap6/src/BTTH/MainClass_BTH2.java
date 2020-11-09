/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MainClass_BTH2 {
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
            Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
        }
        //BƯỚC 2: VIẾT MÃ ĐỂ LẤY THÔNG TIN TỪ BẢNG tblsinhvien
    PreparedStatement pstmt = null;
    ResultSet rs = null;
        try {
            pstmt = con.prepareStatement("select * from tblsinhvien");
            rs = pstmt.executeQuery();
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
            Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
        }
    //BƯỚC 4: VIẾT MÃ ĐỂ CẬP NHẬT DỮ LIỆU TRONG BẢNG
    try {
        pstmt = con.prepareStatement("update tblsinhvien set name=?, address=?,phone=? where id=?");
        pstmt.setString(1, "Lưu Bị");
        pstmt.setString(2, "Thục quốc");
        pstmt.setString(3, "0123989898");
        pstmt.setInt(4, 3);
        int i = pstmt.executeUpdate();
        if (i > 0) {
            System.out.println("Da cap nhat du lieu cho ban ghi co id =3");
        } else {
            System.out.println("Khong cap nhat duoc du lieu");
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
    }
    //BƯỚC 3:VIẾT MÃ ĐỂ THÊM THÔNG TIN SINH VIÊN VÀO BẢNG tblsinhvien
    try {
        pstmt = con.prepareStatement("insert into tblsinhvien values (?,?,?,?,?)");
        pstmt.setString(1, "C1505004");
        pstmt.setString(2, "Tào Tháo");
        pstmt.setString(3, "Ngụy quốc");
        pstmt.setString(4, "19001080");
        pstmt.setBoolean(5, true);
        int i = pstmt.executeUpdate();
        if (i > 0) {
            System.out.println("Đã thêm dữ liệu vào bảng");
        } else {
            System.out.println("Không thêm dược dữ liệu vào bảng");
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
    }
    //BƯỚC 5: VIẾT MÃ ĐỂ XÓA DỮ LIỆU TRONG BẢNG tblsinhvien
    try {
        pstmt = con.prepareStatement("delete from tblsinhvien where id=3");
        int i = pstmt.executeUpdate();
        if (i > 0) {
        System.out.println("Đã xóa  id=3");
        } else {
        System.out.println("Khong xoa duoc du lieu");
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        try {
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainClass_BTH2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
