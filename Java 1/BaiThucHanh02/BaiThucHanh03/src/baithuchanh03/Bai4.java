/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh03;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author USER
 */
public class Bai4 {
    public static void main(String[] args) {
        String str;
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập vào một chuỗi:");
        str = input.nextLine();
        
        
        do{
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Chuyển chuỗi thành chữ hoa");
            System.out.println("\t2.Chuyển chuỗi thành chữ thường");
            System.out.println("\t3.In ra số từ trong chuỗi");
            System.out.println("\t4.Chuyển tất cả khoảng trắng thành ký tự '-'");
            System.out.println("\t5.Viết hoa ký tự đầu tiên trong mỗi từ");
            System.out.println("\t6.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            
            int choice = Integer.parseInt(input.nextLine());
            
            switch(choice){
                case 1:
                    String strHoa = str.toUpperCase();
                    System.out.println("Chuỗi vừa nhập là: " + str);
                    System.out.println("Chuỗi chuyển sang chữ hoa là: "+ strHoa);
                    break;
                case 2:
                    String strThuong = str.toLowerCase();
                    System.out.println("Chuỗi vừa nhập là: " + str);
                    System.out.println("Chuỗi chuyển sang chữ hoa là: "+ strThuong);
                    break;
                case 3:
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    int soTuTrongChuoi = stringTokenizer.countTokens();
                    System.out.println("Số từ có trong chuỗi \"" + str + "\" = " + soTuTrongChuoi);
                    break;
                case 4:
                    str = str.replace(" ","-");
                    System.out.println("Chuyển khoảng trắng thành ký tự '-' = " + str);
                    break;
                case 5:
                    char[] chars = str.toLowerCase().toCharArray();
                    boolean found = false;
                    for (int i = 0; i < chars.length; i++) {
                      if (!found && Character.isLetter(chars[i])) {
                        chars[i] = Character.toUpperCase(chars[i]);
                        found = true;
                      } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') {
                        found = false;
                      }
                    }
                    System.out.println("Biến các chữ đầu thành hoa:".valueOf(chars));
  
                    break;
                case 6:
                    System.exit(0);
            }
    }while(true);
    } 
    
   
}
