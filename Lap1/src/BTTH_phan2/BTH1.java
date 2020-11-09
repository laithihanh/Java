/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BTH1 {
    public static void main(String[] args) {
        BTH1 bai1 = new BTH1();
        bai1.nhapDuLieu();
    }
    //Viết hàm nhập dữ liệu, các chuỗi nhập sẽ lưu trữ vào biến StringBuilder.
    public void nhapDuLieu() {
        StringBuilder dsSinhVien = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            System.out.println("Mời nhập sinh viên thứ " + (i + 1));
            Scanner nhap = new Scanner(System.in);
            String str = nhap.nextLine();
            dsSinhVien.append(str + "#");
        }
    //Bước 2: chuyển đổi biến StringBuilder về kiểu String và phân tách thông qua ký tự "#"
    System.out.println("Danh sach sinh vien");
    String temp = dsSinhVien.toString();
    String arrSV[] = temp.split("#");
        for (int i = 0; i < arrSV.length; i++) {
            System.out.println((i + 1) + " " + arrSV[i]);
        }
    }
}
