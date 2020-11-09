/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class TestBai7 {
    public static void main(String[] args) {
        Bai7<Integer, String> GenericMoto = new Bai7< Integer, String>();
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhập số lượng moto:");
        int n = nhap.nextInt();
        nhap.nextLine();
        for(int i = 0 ; i< n; i++){
            System.out.println("Moto "+(i + 1));
            System.out.printf("\tNhập K:");
            Integer K = nhap.nextInt();
            nhap.nextLine();
            System.out.printf("\tNhập V:");
            String V = nhap.nextLine();
            GenericMoto.addNewElement(K,V);
        }
        System.out.printf("Danh sách moto vừa nhập là:");
        for(int i = 0 ; i< n; i++){
        System.out.printf(GenericMoto.getKey() +"-"+ GenericMoto.getValue() +" ");
        }
    }
}
