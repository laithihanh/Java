/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_3;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai14 {
    public static void main(String[] args) {
        int nhap;
        float tong,TBC=0;
        Scanner input = new Scanner(System.in);
    while(true){
    System.out.println("========MENU=======");
    System.out.println("\t1. Nhập họ tên của bạn");
    System.out.println("\t2. Nhập vào điểm toán, điểm lý, điểm văn");
    System.out.println("\t3. Hiển thị điểm trung bình");
    System.out.println("\t4. Hiển thị xếp loại theo điểm trung bình");
    System.out.println("\t5.Thoát");
    
    System.out.printf("Mời bạn nhập:");
    nhap = input.nextInt();

        switch(nhap){
            case 1:
                String ten;
                input.nextLine();
                System.out.printf("Mời bạn nhập tên:");
                ten = input.nextLine();
                break;
            case 2:
                float toan,ly,van;
                System.out.printf("Mời bạn nhập điểm toán:");
                toan = input.nextFloat();
                System.out.printf("Mời bạn nhập điểm lý:");
                ly = input.nextFloat();
                System.out.printf("Mời bạn nhập điểm văn:");
                van = input.nextFloat();
                System.out.println(" ");
                tong= toan+ly+van;
                TBC = tong/3;
                break;
            case 3:
                System.out.printf("Điểm trung bình là:"+TBC);
                System.out.println("");
                break;
            case 4:
                if(TBC<5){
                    System.out.println("Bạn xếp loại yếu");
                }else if(TBC>=5 && TBC<=6){
                    System.out.println("Bạn xếp loại trung bình");
                }else if(TBC>=7 && TBC<=8){
                    System.out.println("Bạn xếp loại khá");
                }else{
                    System.out.println("Bạn xếp loại giỏi");
                }
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Bạn chọn sai mời chọn lại!!!!");
        }
        }
    }
}
