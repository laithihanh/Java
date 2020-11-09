/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BTH3_DemoJp2Saveobject {
    public void saveNhanVien() {
        List<BTH3> lstNhanVien = new ArrayList<>();
        
        BTH3 nv1 = new BTH3("Nguyen Van A", 18, "HN");
        BTH3 nv2 = new BTH3("Elly Truong", 18, "HCM");
        BTH3 nv3 = new BTH3("Ngoc Trinh", 18, "DN");
        
        lstNhanVien.add(nv1);
        lstNhanVien.add(nv2);
        lstNhanVien.add(nv3);
        
        try {
            // Ghi xuong file
            FileOutputStream file = new FileOutputStream("data.db");
            ObjectOutputStream objOut = new ObjectOutputStream(file);
            objOut.writeObject(lstNhanVien);
            objOut.flush();
            objOut.close();
        } catch (Exception ex) {
            Logger.getLogger(BTH3_DemoJp2Saveobject.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    //viết hàm đọc dữ liệu NhanVien
    public void readNhanVien() {
        List<BTH3> lstNhanVien = new ArrayList<>();
        try {
        FileInputStream file = new FileInputStream("data.db");
        ObjectInputStream objIn = new ObjectInputStream(file);
        lstNhanVien = (List<BTH3>) objIn.readObject();
        objIn.close();
        } catch (Exception ex) {
        ex.printStackTrace();
        }
        for (int i = 0; i < lstNhanVien.size(); i++) {
        System.out.println(lstNhanVien.get(i).toString());
        }
    }
    public static void main(String[] args) {
        BTH3_DemoJp2Saveobject demo = new BTH3_DemoJp2Saveobject();
        demo.saveNhanVien();
        demo.readNhanVien();
    }
}
