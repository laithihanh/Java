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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main_Bai2 {
    List <Bai2> lsMovie = new ArrayList<>();
    public Main_Bai2(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập danh sách.");
            System.out.println("\t2. Xuất danh sách."); 
            System.out.println("\t3. Tính tổng giá tiền của tất cả các vé trong danh sách."); 
            System.out.println("\t4. Sắp xếp các phần tử trong mảng tăng dần theo ngày xem và xuất chiếu.");
            System.out.println("\t5. Ghi, đọc file VE.txt và thoát");
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
                   TongVe();
                    break;
                case 4:
//                   DienTichMax();
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
            
            System.out.printf("Nhập số bộ phim:");
            int n = sc.nextInt();
            for(int i = 0 ; i< n; i++){
            Bai2 tinh = new Bai2();
            System.out.println("Bộ " +(i + 1));
            tinh.input();
            lsMovie.add(tinh);
            }
    }
    public void display(){
        System.out.println("Danh sách phim vừa nhập là:");
        for(Bai2 f : lsMovie){
            System.out.println("");
            f.toString();
            System.out.println("================================================");
        } 
    }
    
    public void TongVe(){
        float sum = 0;
       for (int i = 0; i < lsMovie.size(); i++) {
            Bai2 gc = ((Bai2) lsMovie.get(i));
               sum += gc.getGiaTien();
        }
        System.out.println("Tổng giá vé là:"+sum);
    }
    
    
//     public void sortASC(){
//        Collections.sort(lsMovie, new Comparator<Bai2>(){
//            public int compare(Bai2 o1, Bai2 o2){
//                return  (int) (o1. getNgayXem()- o2. getNgayXem());
//            }         
//        });
//        System.out.println("----- Danh sách sau khi sắp xếp -----");
//        System.out.println("Tên tỉnh \t Diện tích \t Dân số ");
//        int i = 0;
//        for (Bai1 p : lsMovie) {
//            p.toString();
//            System.out.println("================================================");
//        }  
//   }
     public void writeFile(){
        try (
                FileOutputStream fos = new FileOutputStream("VE.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                ){
           
            for(Bai2 e: lsMovie){
                bw.write(e.toString());
                bw.newLine();
            }
            System.out.println("Dữ liệu ghi vào file thành công!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     static void readFile(){
        List <Bai2> lsMovie = new ArrayList<>();
        try (
            FileInputStream fis = new FileInputStream("VE.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                ){
            String str;
            while((str = br.readLine()) != null){
                String fields[] = str.split(",");
                Bai2 b3 = new Bai2();
                    b3.setTenPhim(fields[0].split("=")[1]);
                    b3.setGiaTien((fields[1].split("=")[1]));
                    b3.setXuatChieu(LocalTime.parse(fields[2].split("=")[1]));
                    b3.setNgayXem(LocalDate.parse(fields[3].split("=")[1]));
                    
                lsMovie.add(b3);
            }
            System.out.println("Dữ liệu đọc từ file VE.txt:");
            lsMovie.forEach(o->System.out.println(o.toString()));
        } catch (Exception e) {
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Main_Bai2 app = new Main_Bai2();
       app.run();
    }
}