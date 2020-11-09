/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class BTH3 {
    String regExp = "^C[0-9]{4}[GHIKML]$";
    public static void main(String[] args) {
        BTH3 bai3 = new BTH3();
        bai3.validateName();
    }
    
    public void validateName(){
        do{
            System.out.println("Nhập tên của lớp:");
            Scanner nhap = new Scanner(System.in);
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(nhap.nextLine());
            if(matcher.matches()){
                System.out.println("Tên hợp lệ");
                break;
            }else{
                System.out.println("Tên sai, nhập lại!!!");
            }
        }while(true);
    }
}
