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
public class Bai13 {
    public static void main(String[] args) {
    float toan,ly,hoa,tong;
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập vào điểm toán : ");
    toan = input.nextFloat();
    System.out.printf("Nhập vào điểm lý : ");
    ly = input.nextFloat();
    System.out.printf("Nhập vào điểm hóa : ");
    hoa = input.nextFloat();
    
    tong=toan+ly+hoa;
        if((tong>=5) && (toan>=4) && (ly>=4) && (hoa>=4)){
            System.out.println("Đậu");
            if((toan>=5) && (ly>=5) && (hoa>=5)){
                System.out.printf("Học đều các môn");
            }else{
                System.out.printf("Học chưa đều các môn");
            }
        }else{
            System.out.printf("Thi hỏng");
        }
    }
}
