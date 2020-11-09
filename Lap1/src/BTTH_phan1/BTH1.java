/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan1;

/**
 *
 * @author ADMIN
 */
public class BTH1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BTH1 Bth1 = new BTH1();
        Bth1.dienTichHinhTron(2);

        System.out.println("random: " + Math.random());
        System.out.println("ceil: " + Math.ceil(Math.PI));
        System.out.println("floor: " + Math.floor(Math.PI));
        System.out.println("cbrt: " + Math.cbrt(-27));
        System.out.println("sqrt: " + Math.sqrt(4));
        System.out.printf("sin: %f", Math.sin(Math.PI));
        System.out.printf("\ncos: %f", Math.cos(Math.PI));
        System.out.printf("\ntan: %f\n", Math.tan(Math.PI));
        System.out.println("incrementExact: " + Math.incrementExact(6));
        System.out.println("incrementExact (long): " + Math.incrementExact(9l));
        System.out.println("negateExact: " + Math.negateExact(69));
        System.out.println("nextDown: " + Math.nextDown(69));
        System.out.println("toRadians: " + Math.toRadians(90) + " Because 1 PI = 180: => " + Math.PI / 2);
        System.out.println("toDegrees: " + Math.toDegrees(Math.toRadians(90)));
    }
    private void dienTichHinhTron(float banKinh) {
        double dienTich = Math.pow(banKinh, 2) * Math.PI;
        System.out.println("Diện tích hình tròn là: " + dienTich);
    }
    
}
