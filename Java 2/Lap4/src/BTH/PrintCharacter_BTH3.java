/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTH;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class PrintCharacter_BTH3 implements Runnable{
    @Override
    public void run() {
        for (int i = 'A'; i <'Z'; i++) {
            System.out.println("\t" + (char) i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintCharacter_BTH3.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }
}
