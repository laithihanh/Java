/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import BTTH_Phan1.BTH1;
import BTTH_Phan1.BTH2;
import BTTH_Phan1.BTH2_DemoJP2SaveText;
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
public class Bai1 {
    private String data;

    public Bai1() {
    }
    
    
    public Bai1(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void input(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Nhập dữ liệu:");
        data = sc.nextLine();
    }

    @Override
    public String toString() {
        return data ;
    }
    
    public void writeText2File(List<Bai1> lstData) throws IOException {
        String filePath = "dulieu.txt";
        boolean isVietTiep = false;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // Ghi ra file
        for (Bai1 b1 : lstData) {
            osw.write(b1.toString());
        }
        osw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        osw.close(); // Đóng kết nối tới file
        
    }
    
    public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "dulieu.txt";
        File myFile = new File(filePath);
        try {
            FileInputStream fos = new FileInputStream(myFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fos));
            int numLine = 1;
            String line;
            while ((line = br.readLine()) != null) {
                    System.out.println(numLine + ": "+ line);
                    numLine++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        try {
            Bai1 demo = new Bai1();
            demo.input();
            List<Bai1> lstNhanVien = new ArrayList<>();
            lstNhanVien.add(demo);
     
            demo.readTextByLine();
            demo.writeText2File(lstNhanVien);
            System.out.println("Ghi du lieu thanh cong");
        } catch (IOException ex) {
        System.out.println("Lỗi: " + ex.toString());
        Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE,
        null, ex);
        }
    }
}
