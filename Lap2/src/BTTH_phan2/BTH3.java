/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan2;

/**
 *
 * @author ADMIN
 */
public class BTH3 <T extends Comparable<T>>{
    public void maximum(T a, T b, T c) {
        T max = a;
        if (b.compareTo(a) > 0) {
            max = b;
        }
        if (c.compareTo(b) > 0) {
            max = c;
        }
        System.out.println("Maximum is : " + max);
    }
    
    public static void main(String[] args) {
        BTH3<Integer> compInt = new BTH3<>();
        BTH3<Float> compFloat = new BTH3<>();
        BTH3<String> compString = new BTH3<>();
        
        compInt.maximum(9, 3, 6);
        compFloat.maximum(8.5f, 9.3f, 2.6f);
        compString.maximum("Việt Nam", "Trung Quốc", "Hoa Kỳ");
    }
}
