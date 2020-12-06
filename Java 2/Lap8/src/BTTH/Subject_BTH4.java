/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Subject_BTH4 {
    private List<Observer>observers = new ArrayList<Observer>();
    private int state;
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    public static void main(String[] args) {
        Subject_BTH4 subject = new Subject_BTH4();

        new HexaObserver_BTH4(subject);
        new OctalObserver_BTH4(subject);
        new BinaryObserver_BTH4(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
abstract class Observer {

    protected Subject_BTH4 subject;

    public abstract void update();
}
