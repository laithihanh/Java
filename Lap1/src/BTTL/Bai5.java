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
public class Bai5 {
    public static void main(String[] args) {
        Bai5 bai5 = new Bai5();
        bai5.input();
    }
    String SoDienThoai = "^043[0-9]{6}$";
    
    public void input(){
        do{
            System.out.printf("\tNhập số điện thoại của Hà Nội:");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(SoDienThoai);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if(matcher.matches()){
                System.out.println("\tSố điện thoại là của hà Nội ");
                break;
            }else{
                System.err.println("\tSố điện thoại không phải của Hà Nội");
            }
        }while(true);
     }
        
}
