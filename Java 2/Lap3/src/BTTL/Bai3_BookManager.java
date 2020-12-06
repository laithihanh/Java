/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import BTTH_Phan1.BTH2;
import BTTH_Phan1.BTH2_DemoJP2SaveText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Bai3_BookManager {    
    static List<Bai3> lstbook = new ArrayList<Bai3>();
    static void input(){
        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            System.out.printf("Nhập số sách:");
            int n = Integer.parseInt(br.readLine());
            Bai3 b3;
            while(n>0){
                b3 = new Bai3();
                System.out.printf("\tNhập mã sách:");
                b3.setIsbn(br.readLine());
                System.out.printf("\tNhập tên sách:");
                b3.setBookName(br.readLine());
                System.out.printf("\tNhập tác giả:");
                b3.setAuthor(br.readLine());
                System.out.printf("\tNhập người xuất bản:");
                b3.setPublisher(br.readLine());
                System.out.printf("\tNhập giá:");
                b3.setPrice(Float.parseFloat(br.readLine()));
                lstbook.add(b3);
                n--;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    static void writeToText(String path){
        try (
                FileOutputStream fos = new FileOutputStream(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                ){
           
            for(Bai3 b3: lstbook){
                bw.write(b3.toString());
                bw.newLine();
            }
            System.out.println("Dữ liệu ghi vào file thành công:"+path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void readFile(String path){
        List<Bai3> lstBookFromFile = new ArrayList();
        try (
            FileInputStream fis = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                ){
            String str;
            while((str = br.readLine()) != null){
                String fields[] = str.split(",");
                Bai3 b3 = new Bai3();
                    b3.setIsbn(fields[0].split("=")[1]);
                    b3.setBookName(fields[1].split("=")[1]);
                    b3.setAuthor(fields[2].split("=")[1]);
                    b3.setPublisher(fields[3].split("=")[1]);
                    b3.setPrice(Float.parseFloat(fields[4].split("=")[1]));
                lstBookFromFile.add(b3);
            }
            System.out.println("Dữ liệu đọc từ file book.txt:");
            lstBookFromFile.forEach(o->System.out.println(o.toString()));
        } catch (Exception e) {
        }
    }
//    static void search(){
////        try (
////            InputStreamReader reader = new InputStreamReader(System.in);
////            BufferedReader br = new BufferedReader(reader);   
////            ){
////            Bai3 b3 = new Bai3();
////            System.out.print("Nhập tên cần tìm: ");
////            String name = br.nextLine();
////            
////        } catch (Exception e) {
////        }
////        Bai3 searchSer;
////        Bai3 setSer = new Bai3();
////        int i;
////         Scanner sc = new Scanner(System.in);
////        System.out.print("Nhập tên cần tìm: ");
////         String search = sc.nextLine();
////         setSer.setBookName(search);
////        System.out.println("Danh sách tìm thấy: ");
////        for(i=0; i<lstbook.size();i++){
////            searchSer = (Bai3) lstbook.get(i);
////            if(searchSer.getBookName().contains(search)){
////                 System.out.println("");
////                searchSer.toString();
////            }
////        }
//    }
    static void display(){
        System.out.println("Danh sach vua nhap la:");
        lstbook.forEach(o->System.out.println(o.toString()));
    }
    public static void main(String[] args) {
        String path = "book.text";
        input();
        display();
        writeToText(path);
        readFile(path);
//        search();
    }
    
}
