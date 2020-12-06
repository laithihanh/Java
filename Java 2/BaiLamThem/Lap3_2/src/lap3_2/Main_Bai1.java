/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap3_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main_Bai1 {
    List <Bai1> lsCity = new ArrayList<>();
    public Main_Bai1(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập thông tin cho n sinh viên");
            System.out.println("\t2. Hiển thị thông tin vừa nhập"); 
            System.out.println("\t3. Tính tổng diện tích của tất cả các tính trong dslk."); 
            System.out.println("\t4. Tìm địa chỉ của node chứa tỉnh có diện tích lớn nhất trong danh sách.");
            System.out.println("\t5. Tìm một tỉnh có dân số lớn nhất trong dslk đơn.");
            System.out.println("\t6. Sắp xếp danh sách tăng dần theo diện tích.");
            System.out.println("\t7. Ghi đọc và thoát");
            System.out.print("Chọn chức năng 1->7: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                   TongDienTich();
                    break;
                case 4:
                   DienTichMax();
                    break;
                case 5:
                   
                    break;
                case 6:
                   sortASC();
                    break;
                case 7:
                    writeFile();
                    readFile();
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(){
            Scanner sc = new Scanner(System.in);
            
            System.out.printf("Nhập số tỉnh:");
            int n = sc.nextInt();
            for(int i = 0 ; i< n; i++){
            Bai1 tinh = new Bai1();
            System.out.println("Tỉnh " +(i + 1));
            tinh.input();
            lsCity.add(tinh);
            }
    }
    public void display(){
        System.out.println("Danh sách tỉnh vừa nhập là:");
        System.out.println("Tên tỉnh \t Diện tích \t Dân số ");
        for(Bai1 f : lsCity){
            System.out.println("");
            f.toString();
            System.out.println("================================================");
        } 
    }
    
    public void TongDienTich(){
        float sum = 0;
       for (int i = 0; i < lsCity.size(); i++) {
            Bai1 gc = ((Bai1) lsCity.get(i));
               sum += gc.getDienTich();
        }
        System.out.println("Tổng diện tích các tỉnh là:"+sum);
    }
    public void DienTichMax(){
        Bai1 max = lsCity.get(0);    
         
        for (int i = 1; i < lsCity.size(); i++) {
            if (lsCity.get(i).compareTo(max) > 0) {
                max = lsCity.get(i);
            }
        }
        System.out.println("Tỉnh có diện tích lớn nhất là:"+max);
        
    }
    
     public void sortASC(){
        Collections.sort(lsCity, new Comparator<Bai1>(){
            public int compare(Bai1 o1, Bai1 o2){
                return  (int) (o1. getDienTich()- o2. getDienTich());
            }         
        });
        System.out.println("----- Danh sách sau khi sắp xếp -----");
        System.out.println("Tên tỉnh \t Diện tích \t Dân số ");
        int i = 0;
        for (Bai1 p : lsCity) {
            p.toString();
            System.out.println("================================================");
        }  
   }
     public void writeFile(){
        try (
                FileOutputStream fos = new FileOutputStream("City.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                ){
           
            for(Bai1 e: lsCity){
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("Dữ liệu ghi vào file thành công!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     static void readFile(){
        List <Bai1> lsCity = new ArrayList<>();
        try (
            FileInputStream fis = new FileInputStream("Employee.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                ){
            String str;
            while((str = br.readLine()) != null){
                String fields[] = str.split(",");
                Bai1 b3 = new Bai1();
                    b3.setTinh(fields[0].split("=")[1]);
                    b3.setDienTich(Float.parseFloat(fields[1].split("=")[1]));
                    b3.setDanSo(Long.parseLong(fields[2].split("=")[1]));
                    
                lsCity.add(b3);
            }
            System.out.println("Dữ liệu đọc từ file employee.txt:");
            lsCity.forEach(o->System.out.println(o.toString()));
        } catch (Exception e) {
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Main_Bai1 app = new Main_Bai1();
       app.run();
    }
}
