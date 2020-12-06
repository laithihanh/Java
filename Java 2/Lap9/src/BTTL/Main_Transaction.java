/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Main_Transaction {
    
    private Connection conn;
    ArrayList<GiaoDich> lstProd = new ArrayList<>();
    ETransaction eTran;
        public Main_Transaction(ETransaction et) {
            this.eTran = et;
            try {
                conn = Connect.getConnection();
                if (conn != null) {
                   System.out.println("Kết nối thành công với csdl");
                } else {
                   System.err.println(">>> Kiểm tra kết nối !!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main_Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public void insert(GiaoDich p){
        try {
           
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_transaction_Insert(?,?,?,?,?,?)}");
            //Tham số đầu vào
            cs.setNString(1,p.getTenGD());
            cs.setNString(2,p.getLoaiDG());
            cs.setTime(3,Time.valueOf(p.getGioGD()));
            cs.setDate(4,Date.valueOf(p.getNgayGD()));
            cs.setNString(5,p.getMota());
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
    public List<GiaoDich> display(){
        List<GiaoDich> lst = new ArrayList<>();
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_transaction_GetAll}");
            ResultSet rs = cs.executeQuery();
            System.out.printf("%2s %15s %15s %15s %20s %20s\n",
            eTran.getText(ELanguage.ma), 
            eTran.getText(ELanguage.tengd),
            eTran.getText(ELanguage.loaigd),
            eTran.getText(ELanguage.giogd), 
            eTran.getText(ELanguage.ngay),
            eTran.getText(ELanguage.mota));
           
            while (rs.next()) {  
                GiaoDich p = new GiaoDich();
                p.setMaGD(rs.getInt(1));
                p.setTenGD(rs.getNString(2));
                p.setLoaiDG(rs.getNString(3));
                p.setGioGD(rs.getTime(4).toLocalTime());
                p.setNgayGD(rs.getDate(5).toLocalDate());
                p.setMota(rs.getNString(6));
                p.output();
            }
        } catch (Exception e) {
        }
        return lst;
    }
    public GiaoDich search(int TenGD){
        GiaoDich p = null;
        Scanner sc = new Scanner(System.in);
        try {
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_transaction_SearchByName(?)}");
            System.out.printf("Nhập tên sản phẩm cần tìm kiếm:");
            cs.setNString(1, sc.nextLine());
            ResultSet rs = cs.executeQuery();
            System.out.printf("%2s %15s %15s %15s %20s %20s\n",
            "MaGD", "TenGD", "LoaiGD", "GioGD",
            "NgayGD", "Mota");
            if(rs.next()){
                p = new GiaoDich();
                p.setMaGD(rs.getInt("MaGD"));
                p.setTenGD(rs.getNString("TenGD"));
                p.setLoaiDG(rs.getNString("LoaiGD"));
                p.setGioGD(rs.getTime("GioGD").toLocalTime());
                p.setNgayGD(rs.getDate("NgayGD").toLocalDate());
                p.setMota(rs.getNString("Mota"));
            }
            p.output();
        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }
        
        return p;
    }
    public void transactionDay(){
        try {
            Scanner sc = new Scanner(System.in);
            CallableStatement cs = Connect.getConnection().prepareCall("{CALL proc_product_count_date(?)}");
            System.out.printf("Nhap nam ");
            int year =sc.nextInt();
            cs.setInt(1, year);
            ResultSet rs = cs.executeQuery();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Main_Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
