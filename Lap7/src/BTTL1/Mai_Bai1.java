/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Mai_Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\t.: MENU :.");
            System.out.println("1. Nhập hàng");
            System.out.println("2. Xuất hàng");
            System.out.println("3. Kho");
            System.out.println("4. Cập nhật");
            System.out.println("5. Thoát");
            System.out.println("Mời chọn từ 1 -> 5");
            int choice = sc.nextInt();
            sc.nextLine();
             Mai_Bai1 pm = new Mai_Bai1();
            switch(choice){
                case 1:
                    Bai1 p = new Bai1();
                    p.input();
                    pm.insert(p);
                    break;
                case 2:
                    pm.export();
                    break;
                case 3:
                    pm.readAll();
                    break;
                case 4:
                    pm.update();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
        
    }
    private Connection conn;
        ArrayList<Bai1> lstProd = new ArrayList<>();
        public Mai_Bai1() {
            conn = Connect.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công với csdl");
            } else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
        }
        public void insert(Bai1 prod) {
            try {
                String sql = "INSERT INTO tblProduct(tenhh, nhasx, soluong, giagoc, vat) VALUES(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, prod.getTenhh());
                    ps.setString(2, prod.getNhasx());
                    ps.setInt(3, prod.getSoluong());
                    ps.setFloat(4, prod.getGiagoc());
                    ps.setInt(5, prod.getVat());
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
        public void export() {
            try {
                System.out.println("Nhập mã hàng hóa xuất: ");
                Scanner s = new Scanner(System.in);
                int code = s.nextInt();
                System.out.println("Số lượng xuất: ");
                int number = s.nextInt();
                String sql = "UPDATE tblProduct\n"
                            + "SET soluong -= ? \n"
                            + "WHERE mahh = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, number);
                ps.setInt(2, code);
                int row = ps.executeUpdate(); // Trả về số dòng dữ liệu được thêm
                if (row > 0) {
                    System.out.println("Xuất hàng thành công!");
                } else {
                    System.err.println("Hàng không đủ, vui lòng kiểm tra kho");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void readAll() {
            try {
            String sql = "SELECT * FROM tblProduct";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.printf("%2s %-15s %-15s %3s %8s %2s\n",
            "Ma", "TenHH", "NhaSX", "SL", "Gia", "VT");
            while (rs.next()) {
            Bai1 p = new Bai1(rs.getInt("mahh"),
                                    rs.getString("tenhh"), 
                                    rs.getString("nhasx"), 
                                    rs.getInt("soluong"),
                                    rs.getFloat("giagoc"),
                                    rs.getInt("vat"));
                p.output();
            }
            System.out.println("------------------------------------------------------------------------------");
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void update() {
            try {
                System.out.println("Nhập mã hàng hóa cập nhật: ");
                Scanner s = new Scanner(System.in);
                int code = s.nextInt();
                System.out.println("Số lượng trong kho: ");
                int number = s.nextInt();
                s.nextLine(); // clear
                System.out.println("Tên hàng hóa: ");
                String name = s.nextLine();
                System.out.println("Nhà sản xuất: ");
                String sx = s.nextLine();
                System.out.println("Giá gốc: ");
                float gia = s.nextFloat();
                System.out.println("Thuế: ");
                int thue = s.nextInt();
                String sql = "UPDATE tblProduct\n"
                + "SET soluong = ?, \n"
                + "tenhh = ?, \n"
                + "nhasx = ?, \n"
                + "giagoc = ?, \n"
                + "vat = ? \n"
                + "WHERE mahh = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, number);
                ps.setString(2, name);
                ps.setString(3, sx);
                ps.setFloat(4, gia);
                ps.setInt(5, thue);
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
}
