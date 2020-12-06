/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HonDaIMpl implements HonDaFactory_Bai3{
    List<Honda_Bai3>hondas;
    
     public HonDaIMpl() {
        hondas = new ArrayList<Honda_Bai3>();
        Honda_Bai3 xe1 = new Honda_Bai3("SH 150","sh150",123);
        Honda_Bai3 xe2 = new Honda_Bai3("SH Mode","shmod",345);
        Honda_Bai3 xe3 = new Honda_Bai3("Lead 125","lead125",654);
        Honda_Bai3 xe4 = new Honda_Bai3("Vision 125","vision",678);
        hondas.add(xe1);
        hondas.add(xe2);
        hondas.add(xe3);
        hondas.add(xe4);
    }

    @Override
    public List<Honda_Bai3> getAllHonDa() {
        return hondas;
    }

    @Override
    public void ThongSo() {
        
    }

    public static void main(String[] args) {
        HonDaFactory_Bai3 hondaFactory = new HonDaIMpl();
        
        for(Honda_Bai3 xe: hondaFactory.getAllHonDa()){
            System.out.println("Xe: [Tên: " +xe.getName()+ " Mã:" + xe.getMa()+ 
                    " Thông số:" + xe.getThongso()+ "]");
            
        }
        Honda_Bai3 nhanvien = hondaFactory.getAllHonDa().get(0);
        
       
    }
    
}
    