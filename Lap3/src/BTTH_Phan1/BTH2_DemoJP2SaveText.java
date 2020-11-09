/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BTH2_DemoJP2SaveText {

    public BTH2_DemoJP2SaveText() {
    }
   public void writeText2File(List<BTH2> lstData) throws IOException {
        String filePath = "writeText2File.txt";
        boolean isVietTiep = false;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // Ghi ra file
        for (BTH2 nhanVien : lstData) {
            osw.write(nhanVien.toString());
        }
        osw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        osw.close(); // Đóng kết nối tới file
        
    }
    //viết hàm ghi dữ liệu ra file text theo từng dòng
    public void writeTextByLine(List<BTH2> lstData) throws FileNotFoundException, IOException {
        String filePath = "writeTextByLine.txt";
        boolean isVietTiep = true;
        File myFile = new File(filePath);
        FileOutputStream fos = new FileOutputStream(myFile, isVietTiep);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        // Ghi ra file
        for (BTH2 nhanVien : lstData) {
            bw.write(nhanVien.toString());
            bw.newLine(); // thêm dòng mới gọi
        }
        bw.flush(); // Tống dữ liệu từ bộ nhớ tạm xuống file
        bw.close(); // Đóng kết nối tới file
    }
    //viết hàm đọc dữ liệu trong file theo từng dòng
    public void readTextByLine() throws FileNotFoundException, IOException {
        String filePath = "writeTextByLine.txt";
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
        //thêm dữ liệu ảo, gọi tới hàm, build và chạy
        try {
            BTH2_DemoJP2SaveText demoJP2SaveText = new BTH2_DemoJP2SaveText();
        // Du lieu ao
        List<BTH2> lstNhanVien = new ArrayList<>();
        BTH2 nv1 = new BTH2("Nguyen Van A", 18, "HN");
        BTH2 nv2 = new BTH2("Elly Truong", 18, "HCM");
        BTH2 nv3 = new BTH2("Ngoc Trinh", 18, "DN");
        lstNhanVien.add(nv1);
        lstNhanVien.add(nv2);
        lstNhanVien.add(nv3);
        demoJP2SaveText.writeTextByLine(lstNhanVien);
        demoJP2SaveText.readTextByLine();
        demoJP2SaveText.writeText2File(lstNhanVien);
        System.out.println("Ghi du lieu thanh cong");
        } catch (IOException ex) {
        System.out.println("Lỗi: " + ex.toString());
        Logger.getLogger(BTH2_DemoJP2SaveText.class.getName()).log(Level.SEVERE,
        null, ex);
        }
    }
}
