/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiKtraJava2;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class SinhVien implements Serializable{
    private int id;
    private String ten;
    private boolean gioiTinh;
    private int tuoi;
    private float toan;
    private float ly;
    private float hoa;
    private float TrungBinh;

    public SinhVien() {
    }
    public SinhVien(String ten, boolean gioiTinh, int tuoi, float toan, float ly, float hoa, float TrungBinh) {
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.TrungBinh = TrungBinh;
    }
    
    public SinhVien(int id, String ten, boolean gioiTinh, int tuoi, float toan, float ly, float hoa, float TrungBinh) {
        this.id = id;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.TrungBinh = TrungBinh;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getGioiTinh(){
        return gioiTinh == true ? "Nữ":"Nam";
    }
    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getTrungBinh() {
        TrungBinh= (toan+ly+hoa)/3;
        return TrungBinh;
    }

    public void setTrungBinh(float TrungBinh) {
        this.TrungBinh = TrungBinh;
    }
    
    public void input(){
        Scanner sc= new Scanner(System.in);
        
        System.out.printf("\tNhập tên:");
        ten = sc.nextLine();
        while(true){
            if(ten.length()>0){
                break;
            }else{
                System.out.printf("\tTen không được để trống");
                System.out.println("\tNhap lại");
                ten= sc.nextLine();
            }  
        }
        
        
        while(true){
            try {
               System.out.printf("\tNhập giới tính:");
                gioiTinh= sc.nextBoolean();
                break;
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng:");
                sc.nextLine();
            }
        }
        sc.nextLine();
        while(true){
            try {
               System.out.printf("\tNhập tuổi:");
                tuoi= sc.nextInt();
                break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số");
                sc.nextLine();
            }
        }
        
        while(true){
            try {
              System.out.printf("\tNhập điểm toán: ");
                this.toan = sc.nextInt();
                while(toan < 0 || toan > 20){
                    System.err.println("\tĐiểm phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                    this.toan = sc.nextInt();
                }
               break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số");
                sc.nextLine();
            }
        }
        
        while(true){
            try {
              System.out.printf("\tNhập điểm lý: ");
                this.ly = sc.nextInt();
                while(ly < 0 || ly > 20){
                    System.err.println("\tĐiểm phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                    this.ly = sc.nextInt();
                }
               break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số");
                sc.nextLine();
            }
        }
        
        while(true){
            try {
              System.out.printf("\tNhập điểm hóa: ");
                this.hoa = sc.nextInt();
                while(hoa < 0 || hoa > 20){
                    System.err.println("\tĐiểm phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                    this.hoa = sc.nextInt();
                }
               break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số");
                sc.nextLine();
            }
        }
    }

    public void output() {
        System.out.printf("%-9d %-10s %-15s %-14s %-15s %-15s %-15s %-15s\n",
        this.id, this.ten, getGioiTinh(), this.tuoi, this.toan, this.ly, this.hoa, this.TrungBinh);
    }
    
    
}
