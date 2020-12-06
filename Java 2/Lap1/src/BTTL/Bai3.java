/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class Bai3 {
    public static void main(String[] args) {
        Bai3 bai3 = new Bai3();
         bai3.input();
    }
    private static final String date = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
    public void input(){
        do{
            System.out.printf("\tNhập date:");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(date);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if(matcher.matches()){
                System.out.println("\tNgày tháng năm sinh hợp lệ");
                break;
            }else{
                System.err.println("\tNgày tháng năm sinh không hợp lệ");
            }
        }while(true);
     }
}