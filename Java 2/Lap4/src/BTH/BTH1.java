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
public class BTH1 implements Runnable{
    private Thread t;
    private String threadName;
    
    BTH1(String name){
        threadName= name;
        System.out.println("Creating" +threadName);
    }
    @Override
    public void run() {
        System.out.println("Running" +threadName);
        try {
            for(int i=4;i>0;i--){
                System.out.println("Thread:" +threadName+ ","+i);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread" +threadName+ "interrupted");
        }
        System.out.println("Thread" +threadName+ "exiting");
    }
    public void start(){
        System.out.println("Starting" +threadName);
        if(t==null){
            t= new Thread(this,threadName);
            t.start();
            
        }
    }
    
}
