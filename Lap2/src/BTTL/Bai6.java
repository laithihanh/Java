/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai6 {
    private String comId;
    private String comName;
    private String producer;
    private float price;

    public Bai6() {
    }

    public Bai6(String comId, String comName, String producer, float price) {
        this.comId = comId;
        this.comName = comName;
        this.producer = producer;
        this.price = price;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public class GenericComputer<T>{
        List<T> lstComputer = new ArrayList<T>();
        private T t;
        public void addComputer(T t){
            this.t = t;
        }
        public T displayComputer(){
            return t;
        }
    
    }
    
    
    
}
