/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL2;

import BTTL1.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Sach_Bai2 {
    private Connection conn;
    public Sach_Bai2() throws SQLException {
        conn = Connect.getConnection();
        if (conn != null) {
        System.out.println("Kết nối thành công");
        } else {
        System.err.println(">>> Kiểm tra kết nối !!!");
        }
    }
    public static void main(String[] args) throws SQLException {
        Scanner nhap = new Scanner(System.in);
        while(true){
            System.out.println("===== MENU =====");
            System.out.println("1. Danh sách nhà xuất bản");
            System.out.println("2. Danh sách thể loại");
            System.out.println("3. Nhập thông tin sách");
            System.out.println("4. Hiển thị");
            System.out.println("5. Sửa thông tin sách");
            System.out.println("6. Xóa thông tin sách");
            System.out.println("7. Thoát");
            System.out.println("Vui lòng chọn từ 1 -> 7");
            
            int chon = nhap.nextInt();
            Sach_Bai2 b2 = new Sach_Bai2();
            switch(chon){
                case 1:
                    b2.displayXuatBan();
                    break;
                case 2:
                    b2.displayTheLoai();
                    break;
                case 3:
                    Book b = new Book();
                    b.input();
                    b2.insert(b);
                    break;
                case 4:
                    b2.displaySach();
                    break;
                case 5:
                    b2.update();
                    break;
                case 6:
                    b2.delete();
                    break;
                
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
    public void displayXuatBan(){
        try {
            String sql = "SELECT * FROM tblNhaXuatBan";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.printf("%2s %15s %18s %15s \n",
            "id", "TenXuatBan", "DiaChi", "Sdt");
            while (rs.next()) {
                System.out.printf("%2s %15s %18s %15s \n",
                        rs.getInt("id"),
                        rs.getString("TenXuatBan"),
                        rs.getString("DiaChi"),
                        rs.getInt("Sdt")
                );
            }
            System.out.println("------------------------------------------------");
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void displayTheLoai(){
        try {
            String sql = "SELECT * FROM tblTheLoai";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.printf("%2s %25s %25s \n",
            "id", "TenTheLoai", "MoTa");
            while (rs.next()) {
                System.out.printf("%s %27s %32s \n",
                        rs.getInt("id"),
                        rs.getString("TenTheLoai"),
                        rs.getString("MoTa")
                );
            }
            System.out.println("------------------------------------------------");
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void insert(Book book) {
        try {
            String sql = "INSERT INTO tblSach(TenSach, TheLoai, NXB, SoTrang, GiaTien) VALUES\n" + "(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTenSach());
            ps.setInt(2, book.getTheLoai());
            ps.setInt(3, book.getNXB());
            ps.setInt(4, book.getSoTrang());
            ps.setFloat(5, book.getGiaTien());
            int row = ps.executeUpdate(); // Trả về số dòng dữ liệu được thêm
            if (row > 0) {
            System.out.println("Thêm dữ liệu thành công!");
            } else {
            System.err.println("Lỗi, thêm thất bại");
            }
            } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void displaySach(){
        try {
            String sql = "SELECT * FROM tblSach";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
             System.out.printf("%2s %10s %10s %10s %10s %10s \n",
            "MaSach", "TenSach", "TheLoai", "NXB", "SoTrang", "GiaTien");
            while (rs.next()) {
                Book p = new Book(rs.getInt("MaSach"),
                        rs.getString("TenSach"),
                        rs.getInt("TheLoai"),
                        rs.getInt("NXB"),
                        rs.getInt("SoTrang"),
                        rs.getFloat("GiaTien"));
                p.output();
            }
            System.out.println("--------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    }
    public void update() {
        try {
            System.out.printf("\tNhập mã sách: ");
            Scanner s = new Scanner(System.in);
            int code = s.nextInt();
            s.nextLine(); // clear
            System.out.printf("\tTên sách: ");
            String name = s.nextLine();
            System.out.printf("\tThể loại sách: ");
            int tl = s.nextInt();
            System.out.printf("\tNhà xuất bản: ");
            int sx = s.nextInt();
            System.out.printf("\tSố trang: ");
            int trang = s.nextInt();
            System.out.printf("\tGiá tiền: ");
            Float gia = s.nextFloat();
            String sql = "UPDATE tblSach\n"
            + "SET TenSach = ?, \n"
            + "TheLoai = ?, \n"
            + "NXB = ?, \n"
            + "SoTrang = ?, \n"
            + "GiaTien = ? \n"
            + "WHERE MaSach = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, tl);
            ps.setInt(3, sx);
            ps.setInt(4, trang);
            ps.setFloat(5, gia);
            ps.setInt(6, code);
            int row = ps.executeUpdate(); // Trả về số dòng dữ liệu được thêm
            if (row > 0) {
                System.out.println("Cập nhật hàng thành công!");
            } else {
                System.err.println("Lỗi, cập nhật không thành công");
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi: " + ex.getMessage());
        }
    } 
    public void delete() {
        try {
            conn = Connect.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "DELETE FROM tblSach WHERE MaSach = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã sách:");
            pst.setInt(1, sc.nextInt());

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
