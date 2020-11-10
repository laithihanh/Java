/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai10 {
    public static void main(String[] args) {
        String may, nguoi;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Chào mừng bạn đến với trò chơi kéo búa và giấy ");
        System.out.printf("Mời bạn chọn: ");
        nguoi = input.nextLine();
        System.out.printf("Mời máy chọn: ");
        may = input.nextLine();
        switch(nguoi){
            case "keo":
                switch(may){
                    case "keo":
                        System.out.print("Hòa ");
                        break;
                    case "giay":
                        System.out.print("Bạn đã thắng ");
                        break;
                    case "bua":
                        System.out.print("Bạn đã thua ");
                        break;
                    default:
                        System.out.print("Máy nhập sai ");
                }
                break;
            case "bua":
                switch(may){
                    case "bua":
                        System.out.print("Hòa ");
                        break;
                    case "giay":
                        System.out.print("Bạn đã thua ");
                        break;
                    case "keo":
                        System.out.print("Bạn đã thắng ");
                        break;
                    default:
                        System.out.print("Máy nhập sai ");
                }
                break;
            case "giay":
                switch(may){
                    case "giay":
                        System.out.print("Hòa ");
                        break;
                    case "bua":
                        System.out.print("Bạn đã thắng ");
                        break;
                    case "keo":
                        System.out.print("Bạn đã thua ");
                        break;
                    default:
                        System.out.print("Máy nhập sai ");
                }
                break;
            default:
               System.out.print("Bạn nhập sai "); 
        }
        
    }
}
