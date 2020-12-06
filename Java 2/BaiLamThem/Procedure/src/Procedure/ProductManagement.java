/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ProductManagement {
    private Connection conn;
        public ProductManagement() {
            conn = Connect.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công với csdl");
            } else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
        }
    public static void main(String[] args) {
         Scanner nhap = new Scanner(System.in);
        while(true){
            System.out.println("===== MENU =====");
            System.out.println("1. Hiển thị danh sách sản phẩm.");
            System.out.println("2. Thêm mới sản phẩm.");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm sản phẩm theo id.");
            System.out.println("6. Tìm sản phẩm theo tên.");
            System.out.println("7. Thoát");
            System.out.printf("Vui lòng chọn từ 1 -> 7:");
            
            int chon = nhap.nextInt();
            nhap.nextLine();
            ProductManagement productManagement = new ProductManagement();
            Product p = new Product();
            switch(chon){
                case 1:
                    System.out.println("Danh sách sản phẩm");
                    productManagement.getAll().forEach(o -> o.display());
                   
                    break;
                case 2:
                     p.input();
                    productManagement.Created(p);
                    break;
                case 3:
                    p.input();
                    productManagement.Update(p);
                    break;
                case 4:
                    productManagement.Delete(chon);
                    break;
                case 5:
                    productManagement.getById(chon);
                    break;
                case 6:
                    productManagement.searchByName();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
    Scanner sc = new Scanner(System.in);
    public List<Product> getAll(){
        List<Product> lst = new ArrayList<>();
        
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_GetAll}");
            ResultSet rs = cs.executeQuery();
            System.out.printf("%5s %10s %15s %10s %15s %15s \n",
            "ProductId", "ProductName", "Price", "Producer", "DateCreated", "Status");
            while(rs.next()){
                lst.add(new Product(rs.getInt("ProductId"), rs.getNString("ProductName"), rs.getFloat("Price"), rs.getNString("Producer"), rs.getDate("DateCreated").toLocalDate(), rs.getBoolean("Status")));
            }
            
        } catch (Exception e) {
        }
         
        return lst;
    }
    public void Created(Product p){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Insert(?,?,?,?,?,?)}");
            // Dang ky tham so dau vao
            cs.setNString(1, p.getProductName());
            cs.setFloat(2, p.getPrice());
            cs.setNString(3, p.getProducer());
            cs.setDate(4, Date.valueOf(p.getDateCreated()));
            cs.setBoolean(5, p.isStatus());
            // Dang ky tham so dau ra
            cs.registerOutParameter("Msg", java.sql.Types.NVARCHAR);
            cs.executeUpdate();
            String msg = cs.getNString("Msg");
            if(msg.isEmpty()){
                System.out.println("Thêm mới thành công");
            }else{
                System.out.println(msg);
            }
            
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
    }
    public void Update(Product p){
        
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Update(?,?,?,?,?,?)}");
            // Dang ky tham so dau vao
            System.out.printf("\tMã sản phẩm cần sửa: ");
            int code = sc.nextInt();
            cs.setInt(1, code);
            cs.setNString(2, p.getProductName());
            cs.setFloat(3, p.getPrice());
            cs.setNString(4, p.getProducer());
            cs.setDate(5, Date.valueOf(p.getDateCreated()));
            cs.setBoolean(6, p.isStatus());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.out.println("Sửa thành công");
            }
            
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
    }
     public void Delete(int ProductId){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Delete(?)}");
            // Dang ky tham so dau vao
           
            System.out.printf("Nhập mã sản phẩm cần xóa:");
            cs.setInt(1, sc.nextInt());
            
            int result = cs.executeUpdate();
           
            if(result > 0){
                System.out.println("Xóa thành công");
            }
            
        } catch (Exception e) {
            System.out.println("Loi  " + e.getMessage());
        }
    }
    public Product getById(int ProductId){
        Product p = null;
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_GetById(?)}");
            System.out.printf("Nhập id sản phẩm cần tìm kiếm:");
            cs.setInt(1, sc.nextInt());
            ResultSet rs = cs.executeQuery();
            System.out.printf("%5s %10s %15s %10s %15s %15s \n",
            "ProductId", "ProductName", "Price", "Producer", "DateCreated", "Status");
            if(rs.next()){
                p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getNString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setProducer(rs.getNString("Producer"));
                p.setDateCreated(rs.getDate("DateCreated").toLocalDate());
                p.setStatus(rs.getBoolean("Status"));
            }
            p.display();
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
        
        return p;
    }
    
    public List<Product> searchByName(){
        List<Product> lst = new ArrayList<>();
         try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_SearchByName(?)}");
            System.out.printf("Nhập tên sản phẩm cần tìm kiếm:");
            cs.setNString(1, sc.nextLine());
            ResultSet rs = cs.executeQuery();
            System.out.printf("%5s %10s %15s %10s %15s %15s \n",
            "ProductId", "ProductName", "Price", "Producer", "DateCreated", "Status");
            while(rs.next()){
               Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getNString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setProducer(rs.getNString("Producer"));
                p.setDateCreated(rs.getDate("DateCreated").toLocalDate());
                p.setStatus(rs.getBoolean("Status"));
                p.display();
//                lst.add(new Product(rs.getInt("ProductId"), rs.getNString("ProductName"), rs.getFloat("Price"), rs.getNString("Producer"), rs.getDate("DateCreated").toLocalDate(), rs.getBoolean("Status")));
            }
            
            
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
         
        return lst;
    }
}
