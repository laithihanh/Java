/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan2;

import java.io.IOException;
import java.util.zip.DataFormatException;

/**
 *
 * @author USER
 */
public class BTH2_DeflaterClassDemo {
    public static void main(String[] args) throws IOException, DataFormatException {
        BTH2_DeflaterClassDemo demo = new BTH2_DeflaterClassDemo();
        byte[] dataCompress = BTH2.compress(demo.input.getBytes());
        BTH2.decompress(dataCompress);
    }
    String input = "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam "
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam"
                    + "Cộng Hòa Xã Hội Chủ Nghĩa Việt Nam";
}
