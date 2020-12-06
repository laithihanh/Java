/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH;

/**
 *
 * @author ADMIN
 */
public class Test_BTH2 {
    public static void main(String[] args) {
        BTH2 demo1 = new BTH2("Thread-1");
        demo1.start();
        
        BTH2 demo2 = new BTH2("Thread-2");
        demo2.start();
    }
}
