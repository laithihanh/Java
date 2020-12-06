/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan1;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BTH2 {
    String tenSinhVien;
    int tuoi;
    float diemJava;
    public static void main(String[] args) {
        BTH2 bai2 = new BTH2();
        //viết mã code in ra màn hình thời gian hiện tại.
        bai2.getTime();
        bai2.copyArray();
        
        //viết mã code in ra thông tin class.
        System.out.println("Tên class là:" +bai2.getClass().getName());
        Field arrField[] = bai2.getClass().getDeclaredFields();
        System.out.println("Bai2 có các biến: ");
        for(int i=0; i<arrField.length; i++){
            Field thuocTinh = arrField[i];
            System.out.println(thuocTinh.getName());
        }
        //Bước 5: viết mã code in ra danh sách hàm trong class.
        Method arrMethod[] = bai2.getClass().getDeclaredMethods();
        System.out.println("Bai2 có các hàm: ");
        for (int i = 0; i < arrMethod.length; i++) {
            Method thuocTinh = arrMethod[i];
            System.out.println(thuocTinh.getName());
        }
        
    }
    //Bước 1: viết mã code in ra màn hình thời gian hiện tại.
    public void getTime(){
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        System.out.println("currentTimeMillis = " +time);
        Format format = new SimpleDateFormat("dd/MM/yyyy hh:hh:ss");
        System.out.printf("Date = " +format.format(date));  
    }
    //Bước 2: viết mã code copy dữ liệu từ mảng a sang mảng b.
    public void copyArray(){
        int arrSoNguyen[] = new int[]{1,6,5,2,8};
        int temp[] = new int[5];
        System.arraycopy(arrSoNguyen, 0, temp, 0, arrSoNguyen.length);
        for(int i=0; i < temp.length; i++){
            System.out.println("#" +temp[i]);
        }
    }
}
