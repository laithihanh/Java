/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập x:");
        double x= nhap.nextDouble();
        double a = 2*sin(2*x) - 3*cos(2*x) + 5*sin(x)*cos(x)- 2;
        System.out.println("a, 2sin2x - 3cos2x + 5sinx.cosx - 2 = " + a);
        
        double b = (cos(x) - 2*(sin(x)*cos(x))) / (2*pow(cos(x),2) + sin(x) - 1);
        System.out.println("b, cosx - 2sinx.cosx / 2cos^2x + sinx - 1 = " + b);
        
        double c = (pow(sin(x),2)) + (sin(2*x)) - 2*pow(cos(0),x);
        System.out.println("c, sin^2x + sin2x - 2cos^x = " + c);
        
        double d = 4*pow(sin(x),3) + 3*pow(sin(0),2)*cos(x) - sin(x) - pow(cos(x),3);
        System.out.println("d, 4sin^3x + 3sin^2.cosx - sinx - 3cos^3x = " + d);

    }
}
