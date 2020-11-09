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

public class BTH1<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
    public static void main(String[] args) {
        BTH1<String> stringGenerics = new BTH1<String>();
        BTH1<Integer> integerGenerics = new BTH1<Integer>();
        
        //Chèn dữ liệu tương ứng và in ra màn hình
        stringGenerics.setT(new String("Tôi yêu Việt Nam"));
        integerGenerics.setT(new Integer(2015));
        
        System.out.println("Giá trị tại stringGenerics = " + stringGenerics.getT());
        System.out.println("Giá trị tại integerGenerics = " + integerGenerics.getT());
    }
}


