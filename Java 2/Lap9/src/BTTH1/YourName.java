/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH1;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ADMIN
 */
public class YourName {
    public static void main(String[] args) {
        YourName yName = new YourName();
        yName.getYourName(new Locale("vi","VN"));
        yName.getYourName(new Locale("ko", "KR"));
        yName.getYourName(new Locale("lo", "LA"));
        yName.getYourName(new Locale("th", "TH"));
        
    }
    private void getYourName(Locale locale){
        ResourceBundle bundle = ResourceBundle.getBundle("BTTH1/Whatyourname",locale);
        System.out.println("Tên của bạn tiếng " + locale.getDisplayName() + " " + bundle.getString("yourname"));
    }
}
