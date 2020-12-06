/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChuyenDe06;

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
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ShoesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\t.: MENU :.");
            System.out.println("\t1. Thêm giầy mới");
            System.out.println("\t2. Hiển thị tất cả");
            System.out.println("\t3. Sủa sản phẩm");
            System.out.println("\t4. Xóa sản phẩm");
            System.out.println("\t5. Tìm giầy");
            System.out.println("\t6. Ghi dữ liệu ra file");
            System.out.println("\t7. Import dữ liệu");
            System.out.println("\t8. Thoát");
            System.out.printf("Mời chọn từ 1 -> 6:");
            
            int chon = sc.nextInt();
            Shoes p = new Shoes();
              ShoesManager sm = new ShoesManager();
            switch(chon){
                case 1:
                    sm.insert();
                    break;
                case 2:
                    System.out.println("\t\t\t\t== Danh sách giầy ==");
                    System.out.printf("%2s %16s %15s %15s %23s\n","id", "Name", "Price","Year","Description");
                    sm.getAllShoes();
                    break;
                case 3:
                    p.input();
                    sm.update(p);
                    break;
                case 4:
                    System.out.printf("Nhap id cần xóa: ");
                    int id = sc.nextInt();
                    sm.delete(id);
                    break;
                case 5:
                    Scanner s = new Scanner(System.in);
                    System.out.println("Nhập tên giày cần tìm: ");
                    String shoesName = s.nextLine();
                    System.out.println("\t\t\t\t== Danh sách giầy <" + shoesName + "> ==");
                    System.out.printf("%2s %16s %15s %15s %23s\n","id", "Name", "Price","Year","Description");
                    sm.getShoesByName(shoesName);
                    break;
                case 6:
                    sm.writeData();
                    break;
                case 7:
                    sm.importData();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
    private Connection conn;
    ArrayList<Shoes> lstShoes = new ArrayList<>();
    public ShoesManager() {
        try {
            conn = Connect.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công");
            }else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void insert() {
        try {
            Shoes s = new Shoes();
            s.input();
            String sql = "{CALL proc_product_addShoes(?,?,?,?,?)}";
            
            CallableStatement cs = conn.prepareCall(sql);
            cs.setNString(1, s.getName());
            cs.setFloat(2, s.getPrice());
            cs.setInt(3, s.getYear());
            cs.setNString(4, s.getDescription());
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.executeUpdate();
            String result = cs.getString(5);
            System.out.println("Thêm dữ liệu: " + result);
        } catch (SQLException ex) {
            System.err.println("Lỗi: "+ex.getMessage());
        }
    }

    public void getAllShoes() {
        // Reset mảng dữ liệu
        lstShoes.removeAll(lstShoes);
        try {
        String sql = "{CALL proc_product_getAllShoes}";
        CallableStatement cs = conn.prepareCall(sql);
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            Shoes s = new Shoes(rs.getInt("id"),
            rs.getString("name"), rs.getFloat("price"),
            rs.getInt("year"), rs.getString("description"));
            lstShoes.add(s);
            s.output(); // In dữ liệu
        }
        if (lstShoes.size() == 0) {
        System.out.println("KHÔNG TÌM THẤY DỮ LIỆU");
        }
        } catch (SQLException ex) {
        Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,
        null, ex);
        }
    }
    public void update(Shoes p){
        try {
            
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Update(?,?,?,?,?)}");
            //Tham số đầu vào
            cs.setNString(2,p.getName());
            cs.setFloat(3,p.getPrice());
            cs.setInt(4,p.getYear());
            cs.setNString(5,p.getDescription());
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhap id sản phẩm cần sửa: " );                     
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
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_delete(?) }");
            cs.setInt(1, id);
            
            int result = cs.executeUpdate();
            if(result>0){
                System.out.println("Xóa thành công");
            }
        } catch (Exception e) {
            System.err.println("Lỗi: "+e.getMessage());
        }
    }
    public void getShoesByName(String name) {
        // Reset mảng dữ liệu
        lstShoes.removeAll(lstShoes);
        try {
            String sql = "{CALL proc_product_getShoesByName(?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Shoes s = new Shoes(rs.getInt("id"),
                rs.getString("name"), rs.getFloat("price"),
                rs.getInt("year"), rs.getString("description"));
                lstShoes.add(s);
                s.output(); // In dữ liệu
            }
            if (lstShoes.size() == 0) {
                System.out.println("KHÔNG TÌM THẤY DỮ LIỆU");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,
            null, ex);
        }
    }
    private void writeData() {
    FileOutputStream fos = null;
        try {
            String filePath = "shoes.db";
            fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ShoesManager sm = new ShoesManager();
            sm.getAllShoes(); // Lấy dữ liệu từ database
            oos.writeObject(sm.lstShoes); // Ghi xuống file
            oos.flush();
            oos.close();
            fos.close();
            System.out.println("Ghi dữ liệu thành công");
        } catch (FileNotFoundException ex) {
           Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
               Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
    }
    public void importShoes(Shoes s) {
        try {
            String sql = "{CALL proc_product_addShoes(?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, s.getName());
            cs.setFloat(2, s.getPrice());
            cs.setInt(3, s.getYear());
            cs.setString(4, s.getDescription());
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.executeUpdate();
            // Lấy kết quả trả về
            String result = cs.getString(5);
            System.out.println("Thêm dữ liệu: " + result);
        } catch (SQLException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,
            null, ex);
        }
    }
    private void importData() {
    FileInputStream fis = null;
        try {
            String filePath = "data.txt";
            fis = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
            String row[] = line.split(",");
            Shoes s = new Shoes(row[0], Float.parseFloat(row[1]),
            Integer.parseInt(row[2]), row[3]);
            ShoesManager sm = new ShoesManager();
            sm.importShoes(s);
        }
            System.out.println("Import dữ liệu thành công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,
        null, ex);
        } catch (IOException ex) {
        Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE,
        null, ex);
        } finally {
        try {
        fis.close();
        } catch (IOException ex) {
        Logger.getLogger(ShoesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
//    static void readFile(){
//        List<Shoes> lstBookFromFile = new ArrayList();
//        try (
//            FileInputStream fis = new FileInputStream("shoes.db");
//            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//                ){
//            String str;
//            while((str = br.readLine()) != null){
//                String fields[] = str.split(",");
//                Shoes b3 = new Shoes();
//                    b3.setName(fields[0].split("=")[1]);
//                    b3.setPrice(Float.parseFloat(fields[1].split("=")[1]));
//                    b3.setYear(Integer.parseInt(fields[2].split("=")[1]));
//                    b3.setDescription(fields[3].split("=")[1]);
//                lstBookFromFile.add(b3);
//            }
//            System.out.println("Dữ liệu đọc từ file shoes.db:");
//            lstBookFromFile.forEach(o->System.out.println(o.toString()));
//        } catch (Exception e) {
//        }
//    }
}
