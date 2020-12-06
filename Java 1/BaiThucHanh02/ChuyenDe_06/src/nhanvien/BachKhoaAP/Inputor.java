/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien.BachKhoaAP;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
class Inputor {

    static String getString() {
        Scanner s = new Scanner(System.in);
            return s.nextLine();
    }

    static float getFloat() {
        Scanner s = new Scanner(System.in);
            boolean isOK = false;
            float value = 0;
            do {
                try {
                    value = s.nextFloat();
                    isOK = true;
                } catch (Exception e) {
                    System.err.println("\tDữ liệu không hợp lệ");
                    s.nextLine();
                    System.out.printf("\tNhập lại:");
                    value = s.nextFloat();
                }
                break;
            } while (!isOK);
            return value;
    }

    static int getInteger() {
        Scanner s = new Scanner(System.in);
            boolean isOK = false;
            int value = 0;
            do {
                try {
                    value = s.nextInt();
                    isOK = true;
                } catch (Exception e) {
                    System.err.println("\tDữ liệu không hợp lệ");
                    s.nextLine();
                    System.out.printf("\tNhập lại:");
                    value = s.nextInt();
                }
                break;
            } while (!isOK);
            return value;
    }
    
}
