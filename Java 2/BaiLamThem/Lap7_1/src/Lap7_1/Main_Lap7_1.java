/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap7_1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Main_Lap7_1 {
     public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        while(true){
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm mới sản phẩm.");
            System.out.println("2. Hiển thị danh sách sản phẩm.");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Đếm số lượng theo năm nhập từ bàn phím.");
            System.out.println("6. Tìm sản phẩm theo danh mục.");
            System.out.println("7. Sắp xếp giảm dần dần theo ngày nhập.");
            System.out.println("8. Thoát");
            System.out.printf("Vui lòng chọn từ 1 -> 8:");
            
            int chon = nhap.nextInt();
            nhap.nextLine();
            Main_Lap7_1 main = new Main_Lap7_1();
            Product p = new Product();
            switch(chon){
                case 1:
                    p.input();
                    main.insert(p);
                    break;
                case 2:
                    main.display().forEach(x->x.display());
                    break;
                case 3:
                    p.input();
                    main.update(p);
                    break;
                case 4:
                    System.out.printf("Nhap id product can xoa ");
                    int id = nhap.nextInt();
                    main.delete(id);
                    break;
                case 5:
                    main.CountYear();
                    break;
                case 6:
                    main.search(chon);
                    break;
                case 7:
                    main.SortByCreateDate();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
     private Connection conn;
        public Main_Lap7_1() {
         try {
             conn = Connect.getConnection();
             if (conn != null) {
                System.out.println("Kết nối thành công với csdl");
            } else {
                System.err.println(">>> Kiểm tra kết nối !!!");
            }
         } catch (SQLException ex) {
             Logger.getLogger(Main_Lap7_1.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Product p){
        try {
           
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Insert(?,?,?,?,?,?,?,?,?,?,?)}");
            //Tham số đầu vào
            cs.setInt(1,p.getCatelogId());
            cs.setNString(2,p.getProductName());
            cs.setNString(3,p.getContent());
            cs.setNString(4,p.getContentDetail());
            cs.setFloat(5,p.getPriceInput());
            cs.setFloat(6,p.getPriceOutput());
            cs.setDate(7,Date.valueOf(p.getCreated()));
            cs.setInt(8,p.getViews());
            cs.setInt(9,p.getBuyItem());
            cs.setBoolean(10,p.isStatus());
          
            
            //Tham số đầu ra
            cs.registerOutParameter("Msg",  java.sql.Types.NVARCHAR);
            cs.executeUpdate();
            
            String msg = cs.getNString("Msg");
            
            if(msg.isEmpty()){
                System.out.println("Thêm mới thành công");
            }else{
                System.out.println(msg);
            }
        } catch (Exception e) {
            System.err.println("Lỗi: "+e.getMessage());
        }
    }
    public List<Product> display(){
        List<Product> lst = new ArrayList<>();
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_GetAll}");
            ResultSet rs = cs.executeQuery();
            System.out.printf("%5s %15s %15s %15s %25s %20s %15s %15s %10s %10s %10s \n",
            "ProductId", "CatelogId", "ProductName", "Content",
            "ContentDetail", "PriceInput", "PriceOutput", "Created", "Views", "BuyItem", "Status");
            while (rs.next()) {                
                lst.add(new Product(rs.getInt(1), rs.getInt(2), rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getFloat(6), rs.getFloat(7), rs.getDate(8).toLocalDate(), rs.getInt(9), rs.getInt(10), rs.getBoolean(11)));
            }
        } catch (Exception e) {
        }
        return lst;
    }
    public void update(Product p){
        try {
            
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_Update(?,?,?,?,?,?,?,?,?,?,?)}");
            //Tham số đầu vào
            cs.setInt(2,p.getCatelogId());
            cs.setNString(3,p.getProductName());
            cs.setNString(4,p.getContent());
            cs.setNString(5,p.getContentDetail());
            cs.setFloat(6,p.getPriceInput());
            cs.setFloat(7,p.getPriceOutput());
            cs.setDate(8,Date.valueOf(p.getCreated()));
            cs.setInt(9,p.getViews());
            cs.setInt(10,p.getBuyItem());
            cs.setBoolean(11,p.isStatus());
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap product id can sua la " );                     
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
    public void delete(int ProductId){
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_delete(?) }");
            cs.setInt(1, ProductId);
            
            int result = cs.executeUpdate();
            if(result>0){
                System.out.println("Xóa thành công");
            }
        } catch (Exception e) {
            System.err.println("Lỗi: "+e.getMessage());
        }
    }
    public void CountYear(){
        try {
            Scanner sc = new Scanner(System.in);
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_count_date(?)}");
            System.out.println("Nhap nam ");
            int year =sc.nextInt();
            cs.setInt(1, year);
            ResultSet rs = cs.executeQuery();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Main_Lap7_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Product search(int CatelogId){
        Product p = null;
        Scanner sc = new Scanner(System.in);
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_searchByCateLogID(?)}");
            System.out.printf("Nhập id sản phẩm cần tìm kiếm:");
            cs.setInt(1, sc.nextInt());
            ResultSet rs = cs.executeQuery();
            System.out.printf("%5s %15s %15s %15s %25s %20s %15s %15s %10s %10s %10s \n",
            "ProductId", "CatelogId", "ProductName", "Content",
            "ContentDetail", "PriceInput", "PriceOutput", "Created", "Views", "BuyItem", "Status");
            if(rs.next()){
                p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setCatelogId(rs.getInt("CatelogId"));
                p.setProductName(rs.getNString("ProductName"));
                p.setContent(rs.getNString("Content"));
                p.setContentDetail(rs.getNString("ContentDetail"));
                p.setPriceInput(rs.getFloat("PriceInput")); 
                p.setPriceOutput(rs.getFloat("PriceOutput"));
                p.setCreated(rs.getDate("Created").toLocalDate());
                p.setViews(rs.getInt("Views"));
                p.setBuyItem(rs.getInt("BuyItem"));
                p.setStatus(rs.getBoolean("Status"));
            }
            p.display();
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
        
        return p;
    }
                    
    public List<Product> SortByCreateDate(){
         List<Product> lst = new ArrayList<>();
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_sort_date}");
            ResultSet rs = cs.executeQuery();
            System.out.printf("%5s %15s %15s %15s %25s %20s %15s %15s %10s %10s %10s \n",
            "ProductId", "CatelogId", "ProductName", "Content",
            "ContentDetail", "PriceInput", "PriceOutput", "Created", "Views", "BuyItem", "Status");

            while (rs.next()) {
               System.out.printf("%5s %10s %15s %14s %15s %15s %15s %15s %10s %10s %10s \n",
                    rs.getInt("ProductId"),
                        rs.getInt("CatelogId"),
                        rs.getNString("ProductName"),
                        rs.getNString("Content"),
                        rs.getString("ContentDetail"),
                        rs.getFloat("PriceInput"),
                        rs.getFloat("PriceOutput"),
                        rs.getDate("Created"),
                        rs.getInt("Views"),
                        rs.getInt("BuyItem"),
                        rs.getString("Status")
                    );
            } 
//            while (rs.next()) {                
//                lst.add(new Product(rs.getInt(1), rs.getInt(2), rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getFloat(6), rs.getFloat(7), rs.getDate(8).toLocalDate(), rs.getInt(9), rs.getInt(10), rs.getBoolean(11)));
//            }
        } catch (Exception e) {
        }
        return lst;
    }
}
