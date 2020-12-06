/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import BTTH_Phan1.BTH2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Bai2 {
    private int Int;
    private double Double;
    private boolean Boolean;
    private char Char;
    private String String;

    public Bai2() {
    }

    public Bai2(int Int, double Double, boolean Boolean, char Char, String String) {
        this.Int = Int;
        this.Double = Double;
        this.Boolean = Boolean;
        this.Char = Char;
        this.String = String;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int Int) {
        this.Int = Int;
    }

    public double getDouble() {
        return Double;
    }

    public void setDouble(double Double) {
        this.Double = Double;
    }

    public boolean isBoolean() {
        return Boolean;
    }

    public void setBoolean(boolean Boolean) {
        this.Boolean = Boolean;
    }

    public char getChar() {
        return Char;
    }

    public void setChar(char Char) {
        this.Char = Char;
    }

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }
    public void input(){
    Scanner sc= new Scanner(System.in);
        System.out.printf("Nhập số nguyên: ");
        Int=sc.nextInt();
        System.out.printf("Nhập số thực:");
        Double = sc.nextDouble();
        System.out.printf("Nhập kiểu boolean:");
        Boolean = sc.nextBoolean();
        System.out.printf("Nhập kiểu char:");
        Char = sc.next().charAt(0);
        sc.nextLine();
        System.out.printf("Nhập kiểu string:");
        String = sc.nextLine();
    
    }
    @Override
    public String toString() {
        return "Bai2{" + "Int=" + Int + ", Double=" + Double + ", Boolean=" + Boolean + ", Char=" + Char + ", String=" + String + '}';
    }
    
     public void writeTextByLine(List<Bai2> lstData) throws FileNotFoundException, IOException {
        String filePath = "data.dat";
        boolean isVietTiep = true;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Ghi ra file
        for (Bai2 b2 : lstData) {
            bw.write(b2.toString());
            bw.newLine(); // thêm dòng mới gọi
        }
        bw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        bw.close(); // Đóng kết nối tới file
    }
     public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "data.dat";
        File myFile = new File(filePath);
        FileInputStream fos = new FileInputStream(myFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fos));
        String temp;
        int cnt = 1;
        while ((temp = br.readLine()) != null) {
        System.out.println(cnt + ". \t" + temp);
        cnt++;
        }
    }
     public static void main(String[] args) {
        try {
            Bai2 demo = new Bai2();
            demo.input();
        List<Bai2> lstNhanVien = new ArrayList<>();
        lstNhanVien.add(demo);
        demo.writeTextByLine(lstNhanVien);
        demo.readTextByLine();
       
        System.out.println("Ghi du lieu thanh cong");
        } catch (IOException ex) {
        System.out.println("Lỗi: " + ex.toString());
        Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE,
        null, ex);
        }
    }
}
