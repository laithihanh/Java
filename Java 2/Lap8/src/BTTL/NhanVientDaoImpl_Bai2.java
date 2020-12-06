/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class NhanVientDaoImpl_Bai2 implements NhanVienDao_Bai2{
    List<NhanVien_Bai2>nhanviens;
    
    public NhanVientDaoImpl_Bai2() {
        nhanviens = new ArrayList<NhanVien_Bai2>();
        NhanVien_Bai2 nv1 = new NhanVien_Bai2(1,"Nguyen Văn A",1990,"Hà Nội","0123458769",15000);
        NhanVien_Bai2 nv2 = new NhanVien_Bai2(2,"Nguyen Văn B",2000,"Hà Nội","0125676989",20000);
        nhanviens.add(nv1);
        nhanviens.add(nv2);
    }
    @Override
    public List<NhanVien_Bai2> getAllStudents() {
        return nhanviens;
    }

    @Override
    public NhanVien_Bai2 getNhanVien(int id) {
        return nhanviens.get(id);
    }

    @Override
    public void updateNhanVien(NhanVien_Bai2 nhanvien) {
         this.nhanviens.get(nhanvien.getId()).setName(nhanvien.getName());
        System.out.println("Student:Roll No " + nhanvien.getId()+ "update in the database");
    }

    @Override
    public void deleteNhanVien(NhanVien_Bai2 nhanvien) {
        nhanviens.remove(nhanvien.getId());
        System.out.println("Student:Roll No " + nhanvien.getId()+ ", delete from database");
    }
    public static void main(String[] args) {
        NhanVienDao_Bai2 nhanvienDao = new NhanVientDaoImpl_Bai2();
        
        for(NhanVien_Bai2 nhanvien: nhanvienDao.getAllStudents()){
            System.out.println("Student: [Id: " +nhanvien.getId()+ " Name:" + nhanvien.getName()+ 
                    " yearOfBirth:" + nhanvien.getYearOfBirth()+ " address:" + nhanvien.getAddress()+ 
                    " phone: " +nhanvien.getPhone()+ " salary:" + nhanvien.getSalary()+"]");
                    
        }
        NhanVien_Bai2 nhanvien = nhanvienDao.getAllStudents().get(0);
        
        nhanvien.setName("Nguyen Văn C");
        nhanvienDao.updateNhanVien(nhanvien);
        
        nhanvien.setId(1);
         nhanvienDao.deleteNhanVien(nhanvien);
        
        
        nhanvienDao.getNhanVien(0);
        System.out.println("Student: [Id: " +nhanvien.getId()+ " Name:" + nhanvien.getName()+ 
                    " yearOfBirth:" + nhanvien.getYearOfBirth()+ " address:" + nhanvien.getAddress()+ 
                    " phone: " +nhanvien.getPhone()+ " salary:" + nhanvien.getSalary()+"]");
    }
}
