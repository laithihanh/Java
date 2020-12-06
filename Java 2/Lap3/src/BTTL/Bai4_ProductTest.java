/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import BTTH_Phan1.BTH3;
import BTTH_Phan1.BTH3_DemoJp2Saveobject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Bai4_ProductTest {
    List<Bai4> lstProduct = new ArrayList<>();
    public void saveNhanVien() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập n sản phẩm:");
        int n = sc.nextInt();
        for(int i = 0 ; i< n; i++){
            System.out.println("Nhập quyển " + (i + 1));
            Bai4 b4 = new Bai4();
            b4.input();
            System.out.println("");
            lstProduct.add(b4); 
        }
        try {
            // Ghi xuong file
            FileOutputStream file = new FileOutputStream("product.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(file);
            objOut.writeObject(lstProduct);
            objOut.flush();
            objOut.close();
        } catch (Exception ex) {
            Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void readNhanVien() {
        try {
        FileInputStream file = new FileInputStream("product.dat");
        ObjectInputStream objIn = new ObjectInputStream(file);
        lstProduct = (List<Bai4>) objIn.readObject();
        objIn.close();
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        for (int i = 0; i < lstProduct.size(); i++) {
        System.out.println(lstProduct.get(i).toString());
        }
    }
    public void search(){
        Scanner sc = new Scanner(System.in);
        Bai4 searchSer;
        Bai4 setSer = new Bai4();
        int i;
         
        System.out.print("Nhập tên cần tìm: ");
         String search = sc.nextLine();
         setSer.setProName(search);
        System.out.println("Danh sách tìm thấy: ");
        for(i=0; i<lstProduct.size();i++){
            searchSer = (Bai4) lstProduct.get(i);
            if(searchSer.getProName().contains(search)){
                 System.out.println("");
                searchSer.toString();
            }
        }
    }
    public static void main(String[] args) {
        Bai4_ProductTest demo = new Bai4_ProductTest();
        demo.saveNhanVien();
        demo.readNhanVien();
        demo.search();
    }
    
}
