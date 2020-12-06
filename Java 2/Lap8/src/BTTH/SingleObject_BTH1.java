    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

/**
 *
 * @author ADMIN
 */
public class SingleObject_BTH1 {
    
    private static SingleObject_BTH1 instance = new SingleObject_BTH1();

    
    private SingleObject_BTH1() {
    }
    
    public static SingleObject_BTH1 getInstance (){
        return instance;
    }
    
    public void ShowMessage(){
        System.out.println("Hello World!");
    }
    public static void main(String[] args) {
        SingleObject_BTH1 object = SingleObject_BTH1.getInstance();
        object.ShowMessage();
    }
}
