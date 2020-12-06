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
public class Test_BTH1 {
    public static void main(String[] args) {
        BTH1 demo1 = new BTH1("Thread-1");
        demo1.start();
        
        BTH1 demo2 = new BTH1("Thread-2");
        demo2.start();
    }
}
