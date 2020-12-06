/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BTH3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("#" + i);
            try {
            Thread.sleep(100);
            } catch (InterruptedException ex) {
            Logger.getLogger(BTH3.class.getName()).log(Level.SEVERE, null,
            ex);
            }
        }
    }
}
