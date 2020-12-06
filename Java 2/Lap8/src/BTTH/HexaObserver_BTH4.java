/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

/**
 *
 * @author USER
 */
public class HexaObserver_BTH4 extends Observer{
    public HexaObserver_BTH4(Subject_BTH4 subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " +Integer.toHexString(subject.getState()).toUpperCase());
    }
    
}
