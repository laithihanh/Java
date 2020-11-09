/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BTH1 {
    List<String> listSinhVien = new ArrayList<>();
    
    public void testList(){
        listSinhVien.add("Tuấn");
        listSinhVien.add("Hà");
        listSinhVien.add("Linh");
        System.out.println("Danh sách học sinh");
        System.out.print("\t" +listSinhVien+ "\n");
    }
    
    //Sửa dữ liệu
    public void updateList(){
        listSinhVien.set(1, "Hồng Hà");
        
        System.out.println("danh sách học sinh khi cập nhập");
        System.out.print("\t" +listSinhVien+ "\n");
    }
    
    //Xóa dữ liệu
    public void deleteList(){
        listSinhVien.remove(0);
        
        System.out.println("Danh sách học sinh khi xóa");
         System.out.print("\t" +listSinhVien+ "\n");
    }
    
    public static void main(String[] args) {
        BTH1 bai1 = new BTH1();
        bai1.testList();
        bai1.updateList();
        bai1.deleteList();
    }
}
