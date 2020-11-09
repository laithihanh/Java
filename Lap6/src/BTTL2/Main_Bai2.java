/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL2;

import BTTL1.Mai_Bai1;
import BTTL1.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main_Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("================MENU=======================");
            System.out.println("\t1. Danh sách danh mục.");
            System.out.println("\t2. Nhập giao dịch.");
            System.out.println("\t3. Sửa giao dịch"); 
            System.out.println("\t4. Xóa giao dịch");
            System.out.println("\t5. Thống kê chi tiêu theo danh mục .");
            System.out.println("\t6. Thoát");
            System.out.print("Chọn chức năng 1->6: ");
            int choice = sc.nextInt();
            sc.nextLine();
             Main_Bai2 pm = new Main_Bai2();
            switch(choice){
                case 1:
                    pm.display();
                    break;
                case 2:
                    pm.insert();
                    break;
                case 3:
                    pm.update();
                    break;
                case 4:
                    pm.delete();
                    break;
                case 5:
//                    pm.update();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
        
    }
    private Connection conn;
        public Main_Bai2() {
            conn = BTTL1.Connect.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công với csdl");
            } else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
        }
        public void display() {
            System.out.println("Danh sách danh mục:");
            try {
            String sql = "SELECT * FROM tblDanhMuc";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("\tMã: " + rs.getInt("MaDM"));
                System.out.println("\tTên danh mục: " + rs.getNString("TenDM"));
            }
            System.out.println("-------------------------------------");
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void insert() {
            try {
                String sql = "INSERT INTO tblGiaoDich(TenGD, NgayGD, MaDM, SoTien) VALUES(?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                
                Scanner sc = new Scanner(System.in);
                
                System.out.printf("\tTên giao dịch:");
                pst.setNString(1, sc.nextLine());
                System.out.printf("\tNgày giao dịch:");
                LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                pst.setDate(2, Date.valueOf(ld));
                System.out.printf("\tNhập mã danh mục:");
                pst.setInt(3, sc.nextInt());
                pst.setNString(2, sc.nextLine());
                System.out.printf("\tNhập số tiền: ");
                pst.setFloat(4, sc.nextFloat());

                int result = pst.executeUpdate();
                if (result > 0) {
                    System.out.println("Thêm mới dữ liệu thành công");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void update() {
            try {
                Scanner sc = new Scanner(System.in);
            conn = Connect.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "UPDATE tblGiaoDich SET TenGD=?, NgayGD=?, MaDM=?, SoTien=? WHERE MaGD=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            
            System.out.printf("\tTên giao dịch:");
            pst.setNString(1, sc.nextLine());
            System.out.printf("\tNgày giao dịch:");
            LocalDate ld = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            pst.setDate(2, Date.valueOf(ld));
            System.out.printf("\tMã danh mục:");
            pst.setInt(3, sc.nextInt());
            System.out.printf("\tSố tiền: ");
            pst.setFloat(4, sc.nextFloat());
            System.out.printf("\tMã giao dịch cần sửa: ");
            pst.setInt(5, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Sửa dữ liệu thành công");
            }
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
        }
    public void delete() {
        try {
            conn = BTTL2.Connect.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "DELETE FROM tblGiaoDich WHERE MaGD = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã giao dịch:");
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
