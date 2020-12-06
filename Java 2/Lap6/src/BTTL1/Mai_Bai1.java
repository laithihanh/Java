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
            System.out.println("================MENU=======================");
            System.out.println("\t1. Nhập dữ liệu nhân viên.");
            System.out.println("\t2. Hiển thị danh sách nhân viên.");
            System.out.println("\t3. Tìm kiếm nhân viên theo email"); 
            System.out.println("\t4. Tìm kiếm nhân viên theo tên");
            System.out.println("\t5. Sửa thông tin nhân viên theo mã nhân viên.");
            System.out.println("\t6. Xóa thông tin nhân viên theo mã nhân viên.");
            System.out.println("\t7. Thoát");
            System.out.print("Chọn chức năng 1->7: ");
            int choice = sc.nextInt();
            sc.nextLine();
             Mai_Bai1 pm = new Mai_Bai1();
             NhanVien p = new NhanVien();
            switch(choice){
                case 1:
                    
                    p.input();
                    pm.insert(p);
                    break;
                case 2:
                    pm.readAll();
                    break;
                case 3:
                    pm.searchEmail();
                    break;
                case 4:
                    pm.searchName();
                    break;
                case 5:
                    p.input();
                    pm.update(p);
                    break;
                case 6:
                    pm.delete();
                    break;
                   
                case 7:
                    System.exit(0);
                    break;
            }
        }
        
    }
    private Connection conn;
        ArrayList<NhanVien> lstProd = new ArrayList<>();
        public Mai_Bai1() {
            conn = Connect.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công với csdl");
            } else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
        }
        public void insert(NhanVien nv) {
            try {
                String sql = "INSERT INTO tblNhanVien(HoTen, NamSinh, PhongBan, Email) VALUES(?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nv.getHoTen());
                ps.setInt(2, nv.getNamSinh());
                ps.setString(3, nv.getPhongBan());
                ps.setString(4, nv.getEmail());
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
        public void readAll() {
            try {
            String sql = "SELECT * FROM tblNhanVien";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            System.out.printf("%s %10s %15s %15s %13s \n",
            "MaNV", "HoTen", "NamSinh", "PhongBan", "Email");
            while (rs.next()) {
            NhanVien p = new NhanVien(rs.getInt("MaNV"),
                                    rs.getString("HoTen"), 
                                    rs.getInt("NamSinh"), 
                                    rs.getString("PhongBan"),
                                    rs.getString("Email"));
                p.output();
            }
            System.out.println("------------------------------------------------------------------------------");
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void searchEmail() {
            try {
                String sql = "SELECT * FROM tblNhanVien WHERE Email LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc  = new Scanner(System.in);
            System.out.printf("Email cần tìm: ");
            String Email = sc.nextLine();
            
            pst.setNString(1, "%"+ Email+ "%");
            System.out.printf("%s %10s %15s %15s %13s \n",
            "MaNV", "HoTen", "NamSinh", "PhongBan", "Email");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            NhanVien p = new NhanVien(rs.getInt("MaNV"),
                                    rs.getString("HoTen"), 
                                    rs.getInt("NamSinh"), 
                                    rs.getString("PhongBan"),
                                    rs.getString("Email"));
                p.output();
            } 
             System.out.println("------------------------------------------------------------------------------");      
            }catch (SQLException ex) {
                 System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void searchName() {
            try {
                String sql = "SELECT * FROM tblNhanVien WHERE HoTen LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc  = new Scanner(System.in);
            System.out.printf("HoTen cần tìm: ");
            String HoTen = sc.nextLine();
            
            pst.setNString(1, "%"+ HoTen+ "%");
            System.out.printf("%s %10s %15s %15s %13s \n",
            "MaNV", "HoTen", "NamSinh", "PhongBan", "Email");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            NhanVien p = new NhanVien(rs.getInt("MaNV"),
                                    rs.getString("HoTen"), 
                                    rs.getInt("NamSinh"), 
                                    rs.getString("PhongBan"),
                                    rs.getString("Email"));
                p.output();
            } 
             System.out.println("------------------------------------------------------------------------------");      
            }catch (SQLException ex) {
                 System.err.println("Lỗi: " + ex.getMessage());
            }
        }
        public void update(NhanVien nv) {
            try {
                Scanner sc = new Scanner(System.in);
            conn = Connect.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "UPDATE tblNhanVien SET HoTen=?,NamSinh=?,PhongBan=?, Email=? WHERE MaNV=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setNString(1, nv.getHoTen());
            pst.setInt(2, nv.getNamSinh());
            pst.setNString(3, nv.getPhongBan());
            pst.setNString(4, nv.getEmail());
            System.out.printf("\tMã giao dịch cần sửa: ");
            pst.setInt(5, sc.nextInt());

            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Sửa dữ liệu thành công");
            }
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
            /*Cách 1
            try {
                
                System.out.println("Nhập mã nhân viên: ");
                Scanner s = new Scanner(System.in);
                int code = s.nextInt();
                s.nextLine();
                System.out.println("Tên nhân viên: ");
                String name = s.nextLine();
                System.out.println("Năm sinh: ");
                int bithday = s.nextInt();
                s.nextLine();
                System.out.println("Phòng ban");
                String pb = s.nextLine();
                System.out.println("Email");
                String email = s.nextLine();
                
                String sql = "UPDATE tblNhanVien SET HoTen=?,NamSinh=?,PhongBan=?, Email=? WHERE MaNV=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, name);
                ps.setInt(2, bithday);
                ps.setString(3, pb);
                ps.setString(4, email);
                ps.setInt(5, code);
           
                int row = ps.executeUpdate(); // Trả về số dòng dữ liệu được thêm
                if (row > 0) {
                    System.out.println("Cập nhật hàng thành công!");
                } else {
                    System.err.println("Lỗi, cập nhật không thành công");
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi: " + ex.getMessage());
            }
            /*/
        }
        public void delete() {
        try {
            conn = Connect.getConnection();
            // Khai báo câu lệnh SQL
            String sql = "DELETE FROM tblNhanVien WHERE MaNV = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã nhân viên:");
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
