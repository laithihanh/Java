/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai7<K,V>{
    private K key;
    private V value;
    Map<K,V> ls = new HashMap<K,V>();

    public Bai7() {
    }
    public void addNewElement(K key, V value){
        this.key = key;
       this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    public void display(){
        StringBuilder builder = new StringBuilder();
  
        
        builder.append((String.format("%5s",this.key)));
        builder.append("\t|");
        builder.append((String.format("%15s",this.value)));
        
        
        System.out.println(builder.toString());
    }
}
