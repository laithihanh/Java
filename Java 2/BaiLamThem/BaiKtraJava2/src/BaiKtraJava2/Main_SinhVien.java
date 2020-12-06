/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiKtraJava2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Main_SinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\t.: MENU :.");
            System.out.println("\t1. Nhập vào danh sách N sinh viên");
            System.out.println("\t2. Xuất danh sách N sinh viên sắp xếp theo họ tên");
            System.out.println("\t3. Xuất danh sách N sinh viên ra file sinhvien.txt");
            System.out.println("\t4. Sửa");
            System.out.println("\t5. Xóa");
            System.out.println("\t6. Tìm kiếm sinh viên");
            System.out.println("\t7. Thoát");
            System.out.printf("Mời chọn từ 1 -> 7:");
            
            int chon = sc.nextInt();
            SinhVien p = new SinhVien();
              Main_SinhVien sm = new Main_SinhVien();
            switch(chon){
                case 1:
                    sm.insert();
                    break;
                case 2:
                    System.out.println("\t\t\t\t== Danh sách sinh viên ==");
                    System.out.printf("%2s %10s %15s %10s %15s %15s %15s %15s\n","id", "Tên", "Giới tính","Tuổi","Toán","Lý","Hóa","Trung Bình");
                    sm.getAllSinhVien();
                    break;
                case 3:
                   sm.writeData();
                    break;
                case 4:
                    p.input();
                    sm.update(p);
                    break;
                case 5:
                    System.out.printf("Nhập id cần xóa: ");
                    int id = sc.nextInt();
                    sm.delete(id);
                    break;
                case 6:
                    Scanner s = new Scanner(System.in);
                    System.out.println("Nhập tên sinh viên cần tìm: ");
                    String NameSv = s.nextLine();
                    System.out.println("\t\t\t\t== Danh sách sinh viên <" + NameSv + "> ==");
                    System.out.printf("%2s %10s %15s %10s %15s %15s %15s %15s\n","id", "Tên", "Giới tính","Tuổi","Toán","Lý","Hóa","Trung Bình");
                    sm.search(NameSv);
                    break;    
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
    private Connection conn;
    ArrayList<SinhVien> lstSinhVien = new ArrayList<>();
    public Main_SinhVien() {
        try {
            conn = Connect.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công");
            }else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void insert() {
        try {
            SinhVien s = new SinhVien();
            s.input();
            String sql = "{CALL proc_sv_addSV(?,?,?,?,?,?,?)}";
            
            CallableStatement cs = conn.prepareCall(sql);
            cs.setNString(1, s.getTen());
            cs.setBoolean(2, s.isGioiTinh());
            cs.setInt(3, s.getTuoi());
            cs.setFloat(4, s.getToan());
            cs.setFloat(5, s.getLy());
            cs.setFloat(6, s.getHoa());
            cs.setFloat(7, s.getTrungBinh());
            
            int result = cs.executeUpdate();
            if (result > 0) {
                    System.out.println("Thêm mới dữ liệu thành công");
                }else{
                    System.err.println("Lỗi, thêm thất bại");
                }
        } catch (SQLException ex) {
            System.err.println("Lỗi: "+ex.getMessage());
        }
    }

    public void getAllSinhVien() {
        // Reset mảng dữ liệu
        lstSinhVien.removeAll(lstSinhVien);
        try {
        String sql = "{CALL proc_sv_getAllSV}";
        CallableStatement cs = conn.prepareCall(sql);
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            SinhVien s = new SinhVien(rs.getInt("id"),
            rs.getString("ten"), rs.getBoolean("gioiTinh"),
            rs.getInt("tuoi"), rs.getFloat("toan"), rs.getFloat("ly"), rs.getFloat("hoa"), rs.getFloat("TrungBinh"));
            lstSinhVien.add(s);
            s.output(); // In dữ liệu
        }
        if (lstSinhVien.size() == 0) {
        System.out.println("KHÔNG TÌM THẤY DỮ LIỆU");
        }
        } catch (SQLException ex) {
        Logger.getLogger(Main_SinhVien.class.getName()).log(Level.SEVERE,
        null, ex);
        }
    }
    private void writeData() {
    FileOutputStream fos = null;
        try {
            String filePath = "Sinh vien.db";
            fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Main_SinhVien sm = new Main_SinhVien();
            sm.getAllSinhVien();// Lấy dữ liệu từ database
            oos.writeObject(sm.lstSinhVien); // Ghi xuống file
            oos.flush();
            oos.close();
            fos.close();
            System.out.println("Ghi dữ liệu thành công");
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Main_SinhVien.class.getName()).log(Level.SEVERE,null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main_SinhVien.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
               Logger.getLogger(Main_SinhVien.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
    }
    public void update(SinhVien p){
        try {
            
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_sv_Update(?,?,?,?,?,?,?,?)}");
            //Tham số đầu vào
            cs.setNString(2,p.getTen());
            cs.setBoolean(3,p.isGioiTinh());
            cs.setInt(4,p.getTuoi());
            cs.setFloat(5,p.getToan());
            cs.setFloat(6, p.getLy());
            cs.setFloat(7, p.getHoa());
            cs.setFloat(8, p.getTrungBinh());
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhap id sinh viên cần sửa: " );                     
            int id = sc.nextInt();
              cs.setInt(1,id);
            int result = cs.executeUpdate();
            if(result>0){
                System.out.println("Sửa thành công");
            }
        } catch (Exception e) {
            System.err.println("Lỗi: "+e.getMessage());
        }
    }
     public void delete(int id){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_sv_delete(?) }");
            cs.setInt(1, id);
            
            int result = cs.executeUpdate();
            if(result>0){
                System.out.println("Xóa thành công");
            }
        } catch (Exception e) {
            System.err.println("Lỗi: "+e.getMessage());
        }
    }
     public void search(String ten) {
        // Reset mảng dữ liệu
        lstSinhVien.removeAll(lstSinhVien);
        try {
        String sql = "{CALL proc_sv_getNameSv(?)}";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, ten);
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
           SinhVien s = new SinhVien(rs.getInt("id"),
            rs.getString("ten"), rs.getBoolean("gioiTinh"),
            rs.getInt("tuoi"), rs.getFloat("toan"), rs.getFloat("ly"), rs.getFloat("hoa"), rs.getFloat("TrungBinh"));
            lstSinhVien.add(s);
            s.output(); // In dữ liệu
        }
        if (lstSinhVien.size() == 0) {
        System.out.println("KHÔNG TÌM THẤY DỮ LIỆU");
        }
        } catch (SQLException ex) {
        Logger.getLogger(Main_SinhVien.class.getName()).log(Level.SEVERE,
        null, ex);
        }
    }
}
