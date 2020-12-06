/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap3_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class EmployeeManagement {
     Map <Integer,Employee> lsNhanVien = new HashMap<>();
    public EmployeeManagement(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập thông tin cho n sinh viên");
            System.out.println("\t2. Hiển thị thông tin vừa nhập"); 
            System.out.println("\t3. Sắp xếp danh sách giảm dần theo tổng lương và hiển thị"); 
             System.out.println("\t4. Thống kê mỗi quê có bao nhiêu người cùng quê với nhau"); 
            System.out.println("\t5.Thoát ");
            System.out.print("Chọn chức năng 1->5: ");
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
                    sortASC();
                    break;
                case 4:
                   ThongKe();
                    break;
                case 5:
                    writeFile();
                    readFile();
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(){
            Scanner sc = new Scanner(System.in);
            
            System.out.printf("Nhập số nhân viên:");
            int n = sc.nextInt();
            for(int i = 0 ; i< n; i++){
            Employee nv = new Employee();
            System.out.println("Nhân viên " +(i + 1));
            nv.input();
            lsNhanVien.put(i, nv);
            }
    }
    public void display(){
        System.out.println("Danh sách sản phẩm vừa nhập là:");
        for (Map.Entry<Integer, Employee> entrySet : lsNhanVien.entrySet()) {
            Integer key = entrySet.getKey();
            Employee value = entrySet.getValue();
            System.out.println(key + " - " + value);
        }
        
    }
    public void sortASC(){
        System.out.println("----- Danh sách trước khi sắp xếp -----");
        for (Entry<Integer, Employee> entry : lsNhanVien.entrySet()) {
          System.out.println(entry.getKey() + " ==>> " + entry.getValue());
        }

        List<Employee> emplloyee = new ArrayList<>(lsNhanVien.values());


        Collections.sort(emplloyee, new Comparator<Employee>(){
            public int compare(Employee o1, Employee o2){
                return  (int) (o2. getTongLuong() - o1. getTongLuong());
            }         
        });



        System.out.println("----- Danh sách sau khi sắp xếp -----");
        int i = 0;
        for (Employee p : emplloyee) {
            System.out.println(i+++" ==>>"+p.toString());
        }  
   }
    public void ThongKe(){
         List<Employee> emplloyee = new ArrayList<>(lsNhanVien.values());
          
    
    }
    public void writeFile(){
        List<Employee> emplloyee = new ArrayList<>(lsNhanVien.values());
        try (
                FileOutputStream fos = new FileOutputStream("Employee.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                ){
           
            for(Employee e: emplloyee){
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("Dữ liệu ghi vào file thành công!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void readFile(){
        List<Employee> lstBookFromFile = new ArrayList();
        try (
            FileInputStream fis = new FileInputStream("Employee.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                ){
            String str;
            while((str = br.readLine()) != null){
                String fields[] = str.split(",");
                Employee b3 = new Employee();
                    b3.setMaNv(fields[0].split("=")[1]);
                    b3.setHoTen(fields[1].split("=")[1]);
                    b3.setGioiTinh(Boolean.parseBoolean(fields[2].split("=")[1]));
                    b3.setNgaySinh(LocalDate.parse(fields[3].split("=")[1]));
                    b3.setQueQuan(fields[4].split("=")[1]);
                    b3.setPhongBan(fields[5].split("=")[1]);
                    b3.setViTri(fields[6].split("=")[1]);
                    b3.setTongLuong(Float.parseFloat(fields[7].split("=")[1]));
                lstBookFromFile.add(b3);
            }
            System.out.println("Dữ liệu đọc từ file employee.txt:");
            lstBookFromFile.forEach(o->System.out.println(o.toString()));
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        EmployeeManagement demo = new EmployeeManagement();
        demo.run();
       
    }
}
