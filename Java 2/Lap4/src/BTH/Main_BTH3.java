/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH;

/**
 *
 * @author ADMIN
 */
public class Main_BTH3 {
    public static void main(String[] args) {
        BTH3 printN = new BTH3();
        Thread printC = new Thread(new PrintCharacter_BTH3());
        printN.start();
        printC.start();
    }
}
