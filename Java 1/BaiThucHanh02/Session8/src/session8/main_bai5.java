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
public class main_bai5 {
    ArrayList<Bai5> lstNuoc = new ArrayList<>();
    
    public void nhapDuLieu() {
        System.out.println("Số quốc gia bạn muốn nhập?");
        Scanner input = new Scanner(System.in);
        int cnt = input.nextInt();
        for (int i = 0; i < cnt; i++) {
        System.out.println("Nhập quốc gia thứ " + (i + 1));
        Bai5 nuoc = new Bai5();
        nuoc.nhapDuLieu();
        lstNuoc.add(nuoc);
        }
        System.out.println("Xin cảm ơn!");
    }
    
    public void hienThiDanhSach() {
        System.out.println("Danh sách các quốc gia bạn vừa nhập là: ");
        for (int i = 0; i < lstNuoc.size(); i++) {
        Bai5 get = lstNuoc.get(i);
        System.out.println(get.toString()+"");
        }
        System.out.println("--------------------------");
    }
    public int showMenu() {
        System.out.println("Menu");
        System.out.println("\t1. Nhập dữ liệu");
        System.out.println("\t2. Hiển thị danh sách");
        System.out.println("\t4. Thoát");
        Scanner input = new Scanner(System.in);
        System.out.printf("Mời bạn chọn:");
        return input.nextInt();
    }
    public static void main(String[] args) {
    int choose;
    main_bai5 main = new main_bai5();
    do {
        choose = main.showMenu();
        switch (choose) {
            case 1:
            main.nhapDuLieu();
            break;
            case 2:
            main.hienThiDanhSach();
           break;
            case 4:
            System.exit(0);
            break;
            }
    } while (true);
    }
}
