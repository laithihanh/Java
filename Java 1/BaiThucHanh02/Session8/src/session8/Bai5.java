/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai5 {
    private String name;
    
    public void nhapDuLieu() {
    Scanner input = new Scanner(System.in);
    System.out.print("Tên nước: ");
    this.name = input.nextLine();
    }
    
    @Override
    public String toString() {
    return "Tên quốc gia là:" + name;
    }
}
