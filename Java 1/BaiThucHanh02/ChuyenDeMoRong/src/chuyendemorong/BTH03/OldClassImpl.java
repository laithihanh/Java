/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuyendemorong.BTH03;

/**
 *
 * @author ADMIN
 */
public class OldClassImpl implements IOldInterface{

    @Override
    public void oldMethod() {
        System.out.println("This is old method"); 
    }

    @Override
    public void newMethod1() {
        IOldInterface.super.newMethod1();
        System.out.println("and...this is inside child");
    }

    @Override
    public void newMethod2() {
        IOldInterface.super.newMethod2(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
