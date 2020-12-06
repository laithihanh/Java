/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class main_bai6 {
     ArrayList<Bai6> lstThanhPho = new ArrayList<>();
    
    public void nhapDuLieu() {
        System.out.println("Bạn có muốn nhập tiếp hay không?_Chọn 1 để tiếp tục");
        Scanner input = new Scanner(System.in);
        int cnt = input.nextInt();
        for (int i = 0; i < cnt; i++) {
            if(cnt==1){
                System.out.println("Nhập thành phố thứ " + (i + 1));
                Bai6 thanhpho = new Bai6();
                thanhpho.nhapDuLieu();
                lstThanhPho.add(thanhpho);
            }else{
                break;
            }
        }
        System.out.println("Xin cảm ơn!");
    }
    
    public void hienThiDanhSach() {
        System.out.println("Danh sách các thành phố bạn vừa nhập là: ");
        for (int i = 0; i < lstThanhPho.size(); i++) {
        Bai6 get = lstThanhPho.get(i);
        System.out.println(get.toString()+"");
        }
        System.out.println("--------------------------");
    }
    public int showMenu() {
        System.out.println("Menu");
        System.out.println("\t1. Nhập dữ liệu");
        System.out.println("\t2. Hiển thị danh sách");
        System.out.println("\t3. Thoát");
        Scanner input = new Scanner(System.in);
        System.out.printf("Mời bạn chọn:");
        return input.nextInt();
    }
    public static void main(String[] args) {
    int choose;
    main_bai6 main = new main_bai6();
    do {
        choose = main.showMenu();
        switch (choose) {
            case 1:
            main.nhapDuLieu();
            break;
            case 2:
            main.hienThiDanhSach();
           break;
            case 3:
            System.exit(0);
            break;
            }
    } while (true);
    }
}
