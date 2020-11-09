/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL3;

import BTTL1.Connect;
import BTTL2.Book;
import BTTL2.Sach_Bai2;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main_Bai3 {
    private Connection conn;
    public Main_Bai3() throws SQLException {
        conn = Connect.getConnection();
        if (conn != null) {
        System.out.println("Đã kết nối tới máy chủ");
        } else {
        System.err.println(">>> Không thể kết nối - vui lòng kiểm tra lại !!!");
        }
    }
    public static void main(String[] args) throws SQLException {
        Scanner nhap = new Scanner(System.in);
        while(true){
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập dữ liệu sinh viên.");
            System.out.println("2. Hiển thị danh sách sinh viên.");
            System.out.println("3. Tìm kiếm sinh viên theo email");
            System.out.println("4. Tìm kiếm sinh viên theo tên");
            System.out.println("5. Sửa thông tin sinh viên theo mã Roll No.");
            System.out.println("6. Xóa thông tin sinh viên theo mã Roll No.");
            System.out.println("7. Thoát");
            System.out.println("Vui lòng chọn từ 1 -> 7");
            
            int chon = nhap.nextInt();
            Main_Bai3 b3 = new Main_Bai3();
            switch(chon){
                case 1:
                    b3.insert();
                    break;
                case 2:
                    b3.display();
                    break;
                case 3:
                    b3.searchEmail();
                    break;
                case 4:
                    b3.searchName();
                    break;
                case 5:
                    b3.update();
                    break;
                case 6:
                    b3.delete();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
    public void insert() {
        try {
            String sql = "INSERT INTO tblSinhVien_Lap7(rollNo, sv_name, sv_address, sv_phone, sv_email) VALUES(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);

            System.out.printf("\tMã sinh viên:");
            pst.setString(1, sc.nextLine());
            System.out.printf("\tTên sinh viên:");
            pst.setNString(2, sc.nextLine());
            System.out.printf("\tĐịa chỉ: ");
            pst.setNString(3, sc.nextLine());
            System.out.printf("\tSố điện thoại: ");
            pst.setString(4, sc.nextLine());
            System.out.printf("\tEmail: ");
            pst.setString(5, sc.nextLine());
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Thêm mới dữ liệu thành công");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void display() {
        System.out.println("Danh sách sinh viên:");
        try {
        String sql = "SELECT * FROM tblSinhVien_Lap7";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
            System.out.printf("%s %10s %15s %15s %15s %15s \n",
                    "id", "rollNo", "sv_name", "sv_address", "sv_phone", "sv_email");
        while (rs.next()) {
            System.out.printf("%s %10s %17s %13s %18s %20s \n",
                    rs.getInt("id"),
                    rs.getString("rollNo"),
                    rs.getString("sv_name"),
                    rs.getString("sv_address"),
                    rs.getString("sv_phone"),
                    rs.getString("sv_email")
                    );
        }
        System.out.println("------------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void searchEmail() {
        try {
            String sql = "SELECT * FROM tblSinhVien_Lap7 WHERE sv_email LIKE ?";

        PreparedStatement pst = conn.prepareStatement(sql);
        Scanner sc  = new Scanner(System.in);
        System.out.printf("Email cần tìm: ");
        String sv_email = sc.nextLine();

        pst.setNString(1, "'%"+ sv_email+ "%'");
        System.out.printf("%s %10s %15s %15s %15s %15s \n",
        "id", "rollNo", "sv_name", "sv_address", "sv_phone", "sv_email");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        System.out.printf("%s %10s %17s %13s %18s %20s \n",
                    rs.getInt("id"),
                    rs.getString("rollNo"),
                    rs.getString("sv_name"),
                    rs.getString("sv_address"),
                    rs.getString("sv_phone"),
                    rs.getString("sv_email")
                    );
        } 
         System.out.println("------------------------------------------------------------------------------");      
        }catch (SQLException ex) {
             System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void searchName() {
        try {
            String sql = "SELECT * FROM tblSinhVien_Lap7 WHERE sv_name LIKE ? ";

        PreparedStatement pst = conn.prepareStatement(sql);
        Scanner sc  = new Scanner(System.in);
        System.out.printf("Tên cần tìm: ");
        String sv_name = sc.nextLine();

        pst.setNString(1, "'%"+ sv_name+ "%'");
        System.out.printf("%s %10s %15s %15s %15s %15s \n",
        "id", "rollNo", "sv_name", "sv_address", "sv_phone", "sv_email");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        System.out.printf("%s %10s %17s %13s %18s %20s \n",
                    rs.getInt("id"),
                    rs.getString("rollNo"),
                    rs.getString("sv_name"),
                    rs.getString("sv_address"),
                    rs.getString("sv_phone"),
                    rs.getString("sv_email")
                    );
        } 
         System.out.println("------------------------------------------------------------------------------");      
        }catch (SQLException ex) {
             System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void update() {
        try {
            System.out.printf("\tNhập mã sinh viên: ");
            Scanner s = new Scanner(System.in);
            String code = s.nextLine();
            System.out.printf("\tTên sinh viên:");
            String name = s.nextLine();
            System.out.printf("\tĐịa chỉ:");
            String dc = s.nextLine();
            System.out.printf("\tSố điện thoại: ");
            String dt = s.nextLine();
            System.out.printf("\tEmail: ");
            String email = s.nextLine();

            String sql = "UPDATE tblSinhVien_Lap7 SET sv_name=?, sv_address=?, sv_phone=?, sv_email=? WHERE rollNo=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, dc);
            pst.setString(3, dt);
            pst.setString(4, email);
            pst.setString(5, code);


            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Sửa dữ liệu thành công");
            }else {
                System.err.println("Lỗi, cập nhật không thành công");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void delete() {
        try {
            conn = BTTL2.Connect.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "DELETE FROM tblSinhVien_Lap7 WHERE rollNo = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhập mã sinh viên cần xóa:");
            pst.setString(1, sc.nextLine());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Xóa dữ liệu thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi kết nối CSDL");
                }
            }
        }
    }
}
