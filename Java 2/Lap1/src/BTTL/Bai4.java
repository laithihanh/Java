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
public class Bai4 {
    public static void main(String[] args) {
        Bai4 bai4 = new Bai4();
        bai4.input();
    }
    String cellphone= "[0-9]{9,11}";
    public void input(){
        do{
            System.out.printf("\tNhập số điện thoại:");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(cellphone);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if(matcher.matches()){
                System.out.println("\tSố điện thoại đúng định dạng ");
                break;
            }else{
                System.err.println("\tSố điện thoại không hợp lệ");
            }
        }while(true);
     }
}
