/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap5;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 {
   private String prodId;
   private String prodName;
   private String manufacturer;
   private float producerPrice;
   public float sale_price;

    public Bai1() {
    }

    public Bai1(String prodId, String prodName, String manufacturer, float producerPrice) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.manufacturer = manufacturer;
        this.producerPrice = producerPrice;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getProducerPrice() {
        return producerPrice;
    }

    public void setProducerPrice(float producerPrice) {
        this.producerPrice = producerPrice;
    }
    
    public void input(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Mã sản phẩm:");
        prodId = nhap.nextLine();
        System.out.printf("Tên sản phẩm:");
        prodName = nhap.nextLine();
        System.out.printf("Nhà sản xuấ:");
        manufacturer = nhap.nextLine();
        System.out.printf("Giá sản phẩm:");
        producerPrice = nhap.nextFloat();
    }
    
    public void display(){
        System.out.println("\tSản phẩm:");
        System.out.println("\tMã sản phẩm "+prodId);
        System.out.println("\tTên sản phẩm: "+prodName);
        System.out.println("\tNhà sản xuất: "+manufacturer);
        System.out.println("\tGiá sản phẩm: "+producerPrice);
    }
    public void caculateSalePrice(){
        sale_price = (float) (producerPrice + 0.05 * producerPrice);
        
        System.out.println("\tGiá bán: "+sale_price);
    }

   
}
