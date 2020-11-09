/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ADMIN
 */
public class Test_BTH4 {
    public static void main(String[] args) {
       ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
        BTH4 mt = new BTH4("Thread-" + (i + 1));
        service.submit(mt);
        }
    }
}
