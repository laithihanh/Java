/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float a, b,h,s;
        int chon;
        double nghiem,r;
         DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Scanner sc = new Scanner(System.in);
         while(true){
        System.out.println("\t==========**MENU**==========");
        System.out.println("\t1. Giải phương trình bậc nhất");
        System.out.println("\t2. Tính diện tích hình thang với đáy lớn, đáy nhỏ, chiều cao có kiểu dữ liệu là số thực");
        System.out.println("\t3.Tính chu vi và diện tích hình tròn với bán kính có kiểu double.");
        System.out.println("\t4.Thoát");
    
    
        System.out.printf("Mời bạn chọn:");
        chon = sc.nextInt();

        switch(chon){
            case 1:
                System.out.printf("Nhập vào số a: ");
                a = sc.nextFloat();
                System.out.printf("Nhập vào số b: ");
                b = sc.nextFloat();
                System.out.println("Phương trình bạn vừa nhập vào là: " + a + "x + " + b + " = 0.");
                    if (a == 0) {
                        if (b == 0) {
                            System.out.println("Phương trình này có vô số nghiệm.");
                        } else {
                            System.out.println("Phương trình vô nghiệm.");
                        }
                        } else {
                            nghiem = (double) -b / a;   // ép kiểu để cho ra kết quả chính xác
                            System.out.println("Phương trình có nghiệm x = " + decimalFormat.format(nghiem) + ".");
                        }
                break;
            case 2:
                System.out.printf("Nhập vào đáy nhỏ a: ");
                a = sc.nextFloat();
                System.out.printf("Nhập vào đáy lớn b: ");
                b = sc.nextFloat();
                System.out.printf("Nhập vào chiều cao h: ");
                h = sc.nextFloat();
                
                s=((a+b)/2)*h;
                
                System.out.println("Diện tích hình thang là:"+s);
                break;
            case 3:
                System.out.println("Nhập bán kính hình tròn: ");
                r = sc.nextDouble();
                System.out.println("Diện tích hình tròn là: " + tinhDienTich(r));
                System.out.println("Chu vi hình tròn là: "+ tinhChuVi(r));
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Bạn chọn sai mời chọn lại!!!!");
                 break;
        }
        }
    }
    public static double tinhDienTich(double r) {
        return r * r * 3.14;
    }
    public static double tinhChuVi(double r){
        return r * 2 * 3.14;
    }
        
}

