/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class MainClass {
    Connection conn = null;
    SinhVien sv;
    public void connect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=qlsv","sa", "1234$");
            System.out.println("Kết nối tới CSDL thành công");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int showMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Nhập thông tin sinh viên");
        System.out.println("2. Danh sách sinh viên");
        System.out.println("3. Sửa sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Thêm nhóm sinh viên");
        System.out.println("6. Tìm sinh viên");
        System.out.println("7. Thoát");
        System.out.println("Vui lòng chọn từ 1 -> 7");
        Scanner nhap = new Scanner(System.in);
            return nhap.nextInt();
    }
    
    public void nhapThongTin() throws SQLException {
        conn.setAutoCommit(false); // KHÓA tự động commit dữ liệu lên server
        boolean isStop = false;
        String sql = "INSERT INTO tblsinhvien("
        + "rollnumber, name, address, phone, gender) "
        + "VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        do {
            SinhVien objS = new SinhVien();
            objS.nhapThongTin();
            ps.setString(1, objS.getRollNumber());
            ps.setString(2, objS.getName());
            ps.setString(3, objS.getAddress());
            ps.setString(4, objS.getPhoneNumber());
            ps.setInt(5, objS.getGender());
            ps.addBatch();
            System.out.println("Bạn muốn nhập tiếp không (1: Có | 2: Không)");
            Scanner nhap = new Scanner(System.in);
            if (nhap.nextInt() != 1) {
                isStop = true;
            }
        } while (!isStop);
        // Không nhập nữa mới commit thay đổi
        int updateCount[] = ps.executeBatch();
        conn.commit(); // MỞ KHÓA tự động commit
    }
    
    private void suaThongTin() {
        System.out.println("Nhập thông tin sửa:");
        Scanner nhap = new Scanner(System.in);
        sv = new SinhVien();
        System.out.printf("Nhập Rollnumber sinh viên cần sửa: ");
        sv.setRollNumber(nhap.nextLine());
        System.out.printf("Họ và Tên: ");
        sv.setName(nhap.nextLine());
        System.out.printf("Địa chỉ: ");
        sv.setAddress(nhap.nextLine());
        System.out.printf("SĐT: ");
        sv.setPhoneNumber(nhap.nextLine());
        System.out.printf("Giới tính(Nam = 1 | Nữ = 0): ");
        sv.setGender(nhap.nextInt());
    }
    public void load() throws SQLException {
        String sql = "SELECT * FROM tblsinhvien";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
        String id = result.getString("id");
        String rollnumber = result.getString("rollnumber");
        String name = result.getString("name");
        String address = result.getString("address");
        String phone = result.getString("phone");
        String gender = "Nam";
        if (result.getInt("gender") == 0) {
        gender = "Nữ";
        }
        System.out.println(id + "| " + rollnumber + "| " + name + " - " + address +
        " - " + phone + " - " + gender);
        }
        System.out.println("-------------------------------------------------");
    }
    public void update() throws SQLException {
        System.out.println("Cập nhật thông tin sinh viên");
        suaThongTin();
        String sql = "update tblsinhvien set name=?, address=?, phone=?, gender=? where rollnumber=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sv.getName());
        pstmt.setString(2, sv.getAddress());
        pstmt.setString(3, sv.getPhoneNumber());
        pstmt.setBoolean(4, (sv.getGender() == 1));
        pstmt.setString(5, sv.getRollNumber());
        int i = pstmt.executeUpdate();
        if (i > 0) {
        System.out.println("Sửa thành công");
        } else {
        System.out.println("Thất bại, vui lòng kiểm tra lại dữ liệu");
        }
    }
    public void delete() throws SQLException {
        System.out.printf("Nhập mã sinh viên muốn xóa: ");
        Scanner nhap = new Scanner(System.in);
        String rollNumber = nhap.nextLine();
        String sql = "DELETE FROM tblsinhvien WHERE "
        + "rollnumber = '" + rollNumber + "'";
        Statement st = conn.createStatement();
        int row = st.executeUpdate(sql);
        if (row > 0) {
        System.out.println("Xóa thành công");
        } else {
        System.out.println("Thất bại, vui lòng kiểm tra lại dữ liệu");
        }
    }
    public void getStudentByID() throws SQLException {
        try {
            System.out.println("Nhập Rollnumber sinh viên muốn tìm kiếm: ");
            Scanner nhap = new Scanner(System.in);
            String roll = nhap.nextLine();
            String sql = "{CALL sp_getstudent()}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, roll);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println("Tìm thấy sinh viên có roll:"+roll);
                System.out.println("Rollnumber:"+rs.getString(2));
                System.out.println("Name:"+rs.getString(3));
                System.out.println("Address:"+rs.getString(4));
                System.out.println("Phone:"+rs.getString(5));
                System.out.println("Gender:"+(rs.getBoolean(6) ? "Nam":"Nữ"));
            }else{
                System.out.println("Không tìm thấy sinh viên nào có roll:"+roll);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi:" +ex.getMessage());
        }
        
    }
    public static void main(String[] args){
        MainClass main = new MainClass();
        main.connect();
        int choose = 0;
        
        do {
            choose = main.showMenu();
            switch (choose) {
                case 1: {
                    try {
                        main.nhapThongTin();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                break;
                case 2: {
                    try {
                        main.load();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                break;
                case 3: {
                    try {
                        main.update();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                break;
                case 4: {
                    try {
                        main.delete();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                break;
                case 5: {
                    try {
                        main.nhapThongTin();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                break;
                case 6: {
                    try {
                        main.getStudentByID();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
                break;
                case 7:
                    System.exit(0);
            }
        } while (choose > 0 && choose < 7);
        try {
        // Đóng kết nối
            main.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}