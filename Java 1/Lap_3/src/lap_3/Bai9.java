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
public class Bai9 {
    public static void main(String[] args) {
    int chon;
    Scanner input = new Scanner(System.in);
    while(true){
    System.out.println("Cuối tuần bạn muốn làm gì?");
    System.out.println("\t1. Đi học Java");
    System.out.println("\t2. Đi chơi Công viên ngắm gấu.");
    System.out.println("\t3. Đi (về) nhà nghỉ");
    System.out.println("\t4. Ra sông Hồng tắm tiên");
    System.out.println("\t5. Ngủ cả ngày.");
    System.out.println("\t6.Thoát");
    
    System.out.printf("Mời bạn chọn:");
    chon = input.nextInt();

        switch(chon){
            case 1:
                System.out.println("Bạn sẽ đi học java");
                break;
            case 2:
                System.out.println("Bạn sẽ đi chơi Công viên ngắm gấu.");
                break;
            case 3:
                System.out.println("Bạn sẽ đi chơi Công viên ngắm gấu.");
                break;
            case 4:
                System.out.println("Bạn sẽ về nhà");
                break;
            case 5:
                System.out.println("Bạn sẽ ngủ cả ngày");
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Bạn chọn sai mời chọn lại!!!!");
                 break;
        }
    }
    }
}
