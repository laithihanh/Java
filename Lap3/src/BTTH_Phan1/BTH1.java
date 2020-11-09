/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class BTH1 {
    public void createFolder(String path){
        File folder = new File(path);
        if(folder.exists()){
            System.out.println("Tồn tại đường dẫn này");
            if(folder.isDirectory()){
                System.err.println("Tồn tại thư mục này");
            }
        }else{
            folder.mkdirs();
            System.out.println("Tạo thư mục thành công!!!");
        }
    }
    public void createFile(String path){
        File file = new File(path);
        if(file.exists()){
            System.out.println("Đã tồn tại file này");
        }else{
            try {
                //k tồn tại thì tạo ms
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Lỗi tạo file" +e.toString());
            }
            System.out.println("Tạo mới file thành công!!!");
        }
    }
    public static void main(String[] args) {
        BTH1 bai1 = new BTH1();
        bai1.createFolder("bkap");
        bai1.createFile("bkap/sinhvien.db");
    }
}
