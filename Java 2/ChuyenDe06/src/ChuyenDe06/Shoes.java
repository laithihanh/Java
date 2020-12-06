/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChuyenDe06;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Shoes implements Serializable{
    private int id;
    private String name;
    private float price;
    private int year;
    private String description;

    public Shoes() {
    }

    public Shoes(String name, float price, int year, String description) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.description = description;
    }

    public Shoes(int id, String name, float price, int year, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tTên sản phẩm: ");
        this.name = sc.nextLine();
        while(true){
            if(name.length()<32){
                 break;
            }else{
                System.err.printf("\tTên sản phẩm giới hạn 32 ký tự\n");
                System.out.printf("\tNhập lại:");
                name = sc.nextLine(); 
            }
        }
        
        while(true){
            try {
               System.out.printf("\tGiá thành: ");
               this.price = sc.nextFloat();
                while(year < 0){
                    System.err.println("\tGiá phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
               break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số");
                sc.nextLine();
            }
        }
        
        while(true){
            try {
              System.out.printf("\tNăm sản xuất: ");
                this.year = sc.nextInt();
                while(year < 0){
                    System.err.println("\tNăm phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
               break;
            } catch (Exception e) {
                System.err.println("\tPhải nhập số");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.printf("\tMô tả: ");
        this.description = sc.nextLine();
        while(true){
            if(description.length()<64){
                 break;
            }else{
                System.err.printf("\tMô tả giới hạn 64 ký tự\n");
                System.out.printf("\tNhập lại:");
                description = sc.nextLine(); 
            }
        }
        System.out.println("\t>>> Cảm ơn! <<<");
    }
    public void output() {
        System.out.printf("%-14d %-14s %-16s %-16s %-20s\n",
        this.id, this.name, this.price, this.year, this.description);
    }
}
