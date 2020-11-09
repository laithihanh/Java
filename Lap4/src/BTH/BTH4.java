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
public class BTH4 implements Runnable{
    String name;
    public BTH4(String name){
        this.name= name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+ "-is running");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Logger.getLogger(BTH3.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }
    
}
