/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan2;

import java.io.Console;

/**
 *
 * @author USER
 */
public class BTH1 {
    public static void main(String[] args) {
        Console console = System.console();
        
        if(console == null){
            System.err.println("Hệ thống của bạn không hỗ trợ console");
        }else{
            try {
                String username = console.readLine("Nhập UserName:");
                char[]password = console.readPassword("Nhập Password:");
                
                System.out.println("UserName:" +username);
                System.out.println("Password:" +new String(password));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
