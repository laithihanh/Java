/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vietnam;
import java.util.Scanner;
import lap5.Bai1;
/**
 *
 * @author ADMIN
 */
public class VietNamImportPrice extends Bai1{
    private float taxImported;
    public float imported_price;
    public float thueconggop;
    
    public VietNamImportPrice(float taxImported, String prodId, String prodName, String manufacturer, float producerPrice) {
        super(prodId, prodName, manufacturer, producerPrice);
        this.taxImported = taxImported;
    }

     public VietNamImportPrice(float taxImported) {
        this.taxImported = taxImported;
    }

    public float getTaxImported() {
        return taxImported;
    }

    public void setTaxImported(float taxImported) {
        this.taxImported = taxImported;
    }

    public float getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }
    
     public void input(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Thuế nhập khẩu:");
        taxImported = nhap.nextFloat();
        System.out.printf("Giá nhập khẩu:");
        imported_price = nhap.nextFloat();
        System.out.printf("Thuế cộng gộp:");
        thueconggop = nhap.nextFloat();
        
    }
    public void caculateSalePrice(){
        sale_price = (float) (imported_price + taxImported*imported_price + 0.01*(imported_price + taxImported*imported_price)+taxImported+0.05+thueconggop);
        
        System.out.println("\tGiá bán cho sản phẩm ở Việt Nam: "+sale_price);
    }
    
}