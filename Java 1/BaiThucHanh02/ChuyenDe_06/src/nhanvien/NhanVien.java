/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;

/**
 *
 * @author ADMIN
 */
public class NhanVien implements INhanvien{
    protected String ten; // Tên nhân viên
    protected String diaChi; // Địa chỉ
    protected float luongCoBan; // Lương cơ bản hàng tháng (VD: 970.000)
    protected int soNgayLam;
    
    public NhanVien() {
    }
    
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }
    
    public NhanVien(String ten, String diaChi, float luongCoBan, int soNgayLam) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.luongCoBan = luongCoBan;
        this.soNgayLam = soNgayLam;
    }
    
    public void intro() {
        System.out.println("Xin chào: " + this.ten);
        System.out.println("(" + this.diaChi + ")");
        System.out.println("Lương cơ bản: " + this.luongCoBan);
        System.out.println("Lương thực lĩnh: " + tinhLuong());
        System.out.println("Xếp loại: " + xepLoai());
    }   

    @Override
    public float tinhLuong() {
        return soNgayLam * (luongCoBan/24);
    }

    @Override
    public String xepLoai() {
        if(soNgayLam <= 10){
            return "Kém";
        }else if( soNgayLam >10 && soNgayLam <= 20){
            return "Trung bình";
        }else if(soNgayLam > 20 && soNgayLam <= 24){
            return "Khá";
        }else if (soNgayLam > 24 && soNgayLam <=26){
            return "Giỏi";
        }else if(soNgayLam >26){
            return "Xuất sắc";
        }else{
            return "Không xác định";
        }
    }
}
