/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai5 {
    public static void main(String[] args) {
        String tensv,masv;
        float mark_LT,mark_TH, avg;
        
        Scanner sv = new Scanner(System.in);
        
        System.out.print("Nhập tên sinh viên: ");
        tensv = sv.nextLine();
        
        System.out.print("Nhập mã sinh viên: ");
        masv = sv.nextLine();
        
        System.out.print("Nhập điểm lý thuyết: ");
        mark_LT = sv.nextFloat();
        
        System.out.print("Nhập điểm thực hành: ");
        mark_TH = sv.nextFloat();
        
        avg = (mark_LT+ mark_TH)/2;
        if(avg <4){
            System.out.println("Sinh viên phải học lại");
        }else if(mark_LT < 4){
            System.out.println("Thi lại lý thuyết");
        }else if(mark_TH < 4){
            System.out.println("Thi lại thực hành");
        }else if(4<=avg && avg<=7 ){
            System.out.println("Sinh viên đạt môn java");
        }else if(avg > 7){
            System.out.println("Sinh viên suất sắc môn java");
        }    
    }
}
