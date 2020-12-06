/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Bai5 {
    private String proId;
    private String proName;
    private String producer;
    private int yearMaking;
    private float price;

    public Bai5() {
    }

    public Bai5(String proId, String proName, String producer, int yearMaking, float price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập proId:");
        while(true){
               this.proId = sc.nextLine();
              if(this.proId.length() > 0){
                  break;
              }else{
                  System.err.println("\tKhông được để trống");
                  System.out.printf("\tNhập lại: ");
              }
        }
        System.out.printf("\tNhập tên sản phẩm:");
        while(true){
              this.proName = sc.nextLine();
              if(this.proName.length() > 0){
                  break;
              }else{
                  System.err.println("\tKhông được để trống");
                  System.out.printf("\tNhập lại: ");
              }
        }
        System.out.printf("\tNhập người sản xuất:");
        while(true){
              this.producer = sc.nextLine();
              if(this.producer.length() > 0){
                  break;
              }else{
                  System.err.println("\tKhông được để trống");
                  System.out.printf("\tNhập lại: ");
              }
        }
        boolean isDone = false;
        while(true){
            try {
                System.out.printf("\tNhập năm sản xuất:");
                this.yearMaking = sc.nextInt();
                Year nhap = Year.of(this.yearMaking);
                Year now = Year.now();
                int year = now.compareTo(nhap);
                if(year > 0){
                    isDone = true;
                    break;
                }else{
                    System.err.println("\tKhông vượt quá năm hiện tại");
                }
//                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.printf("\tNhập giá:");
                this.price = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
    }

    public String toString() {
       StringBuilder builder = new StringBuilder();
  
        builder.append((String.format(this.proId)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.proName)));
        builder.append("\t|");
        builder.append((String.format("%15s",this.producer)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.yearMaking)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.price)));
        
        System.out.println(builder.toString());
        return super.toString();
    }
    
}
