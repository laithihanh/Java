/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH2;

import BTTH1.MainClass;
import BTTH1.SinhVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author USER
 */
public class DemoCachedRowset {
    final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=qlsv";
    final static String USERNAME = "sa";
    final static String PASSWORD = "1234$";
    
    final static String ID = "id";
    final static String ROLLNUMBER = "rollnumber";
    final static String NAME = "name";
    final static String ADDRESS = "address";
    final static String PHONE = "phone";
    final static String GENDER = "gender";
    
    private void getAllRowset(CachedRowSet rowset) throws SQLException {
        rowset.beforeFirst(); // Di chuyển con trỏ tới dòng đầu tiên;
        // In kết quả truy vấn ra màn hình
        System.out.println("===================================================");
        while (rowset.next()) {
            int rowNum = rowset.getRow();
            // String id = rowset.getString("id");
            String rollnumber = rowset.getString("rollnumber");
            String name = rowset.getString("name");
            String address = rowset.getString("address");
            String phone = rowset.getString("phone");
            String gender = rowset.getBoolean("gender") ?"Nam":"Nữ";
            System.out.println(rowNum + "#\t " + " " + rollnumber + "| " + name + " - " + address + " - " + phone + " - " + gender);
        }
        System.out.println("===================================================");
    }
    
    private void insert(CachedRowSet rowset) throws SQLException {
        // Khởi tạo đối tượng Sinh Viên và nhập dữ liệu
        SinhVien sinhVien = new SinhVien();
        System.out.println("Nhập thông tin sinh viên");
        Scanner nhap = new Scanner(System.in);
        System.out.printf("\tMã sinh viên: ");
        sinhVien.setRollNumber(nhap.nextLine());
        System.out.printf("\tHọ và Tên: ");
        sinhVien.setName(nhap.nextLine());
        System.out.printf("\tĐịa chỉ: ");
        sinhVien.setAddress(nhap.nextLine());
        System.out.printf("\tSĐT: ");
        sinhVien.setPhoneNumber(nhap.nextLine());
        System.out.printf("\tGiới tính(Nam = 1 | Nữ = 0): ");
        sinhVien.setGender(nhap.nextInt());
        rowset.moveToInsertRow(); // Di chuyển con trỏ tới vị trị THÊM
        rowset.updateNull(ID); // Trong CatchedRowset buộc phải có nếu ko sẽ ko thực  hiện dc
        rowset.updateString(ROLLNUMBER, sinhVien.getRollNumber());
        rowset.updateString(NAME, sinhVien.getName());
        rowset.updateString(ADDRESS, sinhVien.getAddress());
        rowset.updateString(PHONE, sinhVien.getPhoneNumber());
        rowset.updateInt(GENDER, sinhVien.getGender());
        rowset.insertRow(); // Lệnh thực thi thêm dữ liệu vào dữ liệu tạm của CachedRowset
        rowset.moveToCurrentRow(); // Di chuyển con trỏ tới dòng hiện tại trước khi thêm
        
        /*
        Khác với JDBCRowset, mọi thay đổi được thực thi ngay lập tức thì đối với
        CachedRowset ta cần phải gọi hàm acceptChanges() để việc thực thi mới
        thực sự thay đổi trên CSDL
        */
        rowset.acceptChanges();
    }
    private void update(CachedRowSet rowset) throws SQLException {
        // Di chuyển con trỏ Rowset xuống cuối cùng
        rowset.last();
        // Hiển thị số lượng bản ghi lấy được từ CSDL
        System.out.println("Tìm thấy: " + rowset.getRow() + " bản ghi");
        // 1. Nhập thứ tự sinh viên muốn sửa
        System.out.println("Nhập thứ tự sinh viên muốn sửa: ");
        Scanner nhap = new Scanner(System.in);
        int rowNum = nhap.nextInt();
        // 2. Di chuyển tới vị trí muốn sửa
        rowset.absolute(rowNum);
        // 3. Nhập thông tin Sinh Viên
        SinhVien sinhVien = new SinhVien();
        System.out.println("Nhập thông tin sửa");
        nhap.nextLine(); // Xóa bộ nhớ đệm tạm - phòng bị trôi dòng
        System.out.printf("\tHọ và Tên: ");
        sinhVien.setName(nhap.nextLine());
        System.out.printf("\tĐịa chỉ: ");
        sinhVien.setAddress(nhap.nextLine());
        System.out.printf("\tSĐT: ");
        sinhVien.setPhoneNumber(nhap.nextLine());
        System.out.printf("\tGiới tính(Nam = 1 | Nữ = 0): ");
        sinhVien.setGender(nhap.nextInt());
        // 4. Thực hiện chỉnh sửa dữ liệu trên Rowset
        rowset.updateString(NAME, sinhVien.getName());
        rowset.updateString(ADDRESS, sinhVien.getAddress());
        rowset.updateString(PHONE, sinhVien.getPhoneNumber());
        rowset.updateInt(GENDER, sinhVien.getGender());
        // 5. Gọi lệnh thi hành sự thay đổi tạm thời trên CachedRowset
        rowset.updateRow();
        rowset.acceptChanges(); // Thực thi thay đổi trên CSDL
        System.out.println("Cập nhật thành công");
    }
    
    private void delete(CachedRowSet rowset) throws SQLException {
        // 1. Nhập thứ tự sinh viên muốn sửa
        System.out.println("Cập nhật thông tin sinh viên");
        System.out.println("Nhập thứ tự sinh viên muốn sửa ");
        Scanner nhap = new Scanner(System.in);
        int rowNum = nhap.nextInt();
        // 2. Di chuyển tới vị trí muốn sửa
        rowset.absolute(rowNum);
        // 3. Gọi lệnh thực thi xóa trên CSDL
        System.out.println("Xóa Sinh Viên tên là " + rowset.getString(NAME) + " tại địa chỉ " + rowset.getString(ADDRESS));
        rowset.deleteRow();
        rowset.acceptChanges(); // Thực thi thay đổi trên CSDL
    }
    private int showMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Sửa sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Thoát");
        System.out.println("Vui lòng chọn từ 1 -> 5");
        Scanner nhap = new Scanner(System.in);
        return nhap.nextInt();
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
            try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn =
            DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=qlsv","sa", "1234$");
            conn.setAutoCommit(false); // Mặc định là true.
            System.out.println("Kết nối tới CSDL thành công");
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowset = factory.createCachedRowSet();
            String sql = "SELECT * FROM tblsinhvien";
            cachedRowset.setCommand(sql);
            cachedRowset.execute(conn);
            DemoCachedRowset demo = new DemoCachedRowset();
            int choose;
            do {
                choose = demo.showMenu();
                switch (choose) {
                    case 1:
                    demo.getAllRowset(cachedRowset);
                    break;
                case 2:
                    demo.insert(cachedRowset);
                    break;
                case 3:
                    demo.update(cachedRowset);
                    break;
                case 4:
                    demo.delete(cachedRowset);
                    break;
                }
            } while (choose > 0 && choose < 5);
                cachedRowset.close(); // Đóng kết nối tới CSDL
    }
}
