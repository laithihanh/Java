/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    char kyTu;
    Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ký tự: ");
        kyTu = sc.next().charAt(0);
            switch(kyTu) {
                case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
            case 'A' :
            case 'E' :
            case 'I' :
            case 'O' :
            case 'U':
                    System.out.print("Chữ +"+kyTu+" là nguyên âm ");
                    break;
                default:
                   System.out.println("Chữ"+kyTu+" không phải là nguyên âm ");
            }
        
    }
    
}
