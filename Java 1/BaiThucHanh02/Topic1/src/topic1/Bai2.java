/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic1;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 {
    public static void main(String[] args) {
        String ten;
        char hanhkiem;
        float toan,ly,hoa,avg;
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Nhập tên sinh viên: ");
        ten = sc.nextLine();
        System.out.printf("Nhập điểm toán: ");
        toan = sc.nextFloat();
        System.out.printf("Nhập điểm lý: ");
        ly = sc.nextFloat();
        System.out.printf("Nhập điểm hóa: ");
        hoa = sc.nextFloat();
        System.out.printf("Nhập hạnh kiểm: ");
        hanhkiem = sc.next().charAt(0);
        
        avg=(toan+toan+ly+hoa)/4;
        
        
        
        System.out.println("\tTên sv: "+ten);
        System.out.println("\tĐiểm toán: "+toan);
        System.out.println("\tĐiểm lý: "+ly);
        System.out.println("\tĐiểm hóa: "+hoa);
        System.out.println("\tĐiểm trung bình : "+avg);
        System.out.printf("\tHạnh kiểm : \n");
        
        if(hanhkiem == 'Y' ){
            System.out.printf("Yếu ");
        }else if(hanhkiem == 'B' ){
            System.out.printf("Trung bình ");
        }else if(hanhkiem == 'T'){
            System.out.printf("Tốt");
        }
        
    }
}
