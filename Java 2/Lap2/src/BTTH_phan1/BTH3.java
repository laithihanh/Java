/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class BTH3 {
    public static void main(String[] args) {
        //tạo đối tượng map và chèn dữ liệu
        Map<String, String> studentBKAP = new HashMap<>();
        studentBKAP.put("K1230", "Tuan");
        studentBKAP.put("K1231", "Nam");
        studentBKAP.put("K1232", "Thao");
        studentBKAP.put("K1233", "Binh");
        studentBKAP.put("K1234", "Hoang");
        
        for(Map.Entry<String, String> entrySet : studentBKAP.entrySet()){
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            System.out.println(key + "-" +value);
        }
        System.out.println("Student rollno = K1231 is " + studentBKAP.get("K1231"));
        
        //Xóa sinh viên mã K1233
        studentBKAP.remove("K1233");
        System.out.println("After remove:" +studentBKAP);
    }
}
