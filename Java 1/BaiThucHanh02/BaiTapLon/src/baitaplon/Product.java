/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon;

import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Product implements IProduct{
    private String productId;//Mã sản phẩm bao gồm 4 ký tự, bắt đầu là ký tự “C” và là duy nhất
    private String productName ;// Tên sản phẩm bao gồm từ 6-50 ký tự và là duy nhất
    private String title ;// – Tiêu đề sản phẩm bao gồm từ 6-30 ký tự
    private float importPrice ;//  – giá nhập sản phẩm là số thực lớn hơn 0
    private float exportPrice ;//– giá bán sản phẩm là số thực và có giá trị lớn hơn giá bán ít nhất là MIN_INTEREST_RATE lần
    
    //– lợi nhuận sản phẩm tính theo công thức profit = exportPrice - importPrice
    private float profit;// 
    private String descriptions;//– mô tả sản phẩm – khi nhập không được để trống
    private boolean productStatus ;// – trạng thái sản phẩm – khi nhập chỉ nhận true hoặc false
    private ArrayList<Category>listCate=new ArrayList<Category>();//Danh mục sản phẩm của sản phẩm

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public ArrayList<Category> getListCate() {
        return listCate;
    }

    public void setListCate(ArrayList<Category> listCate) {
        this.listCate = listCate;
    }

    
    public Product(String productId, String productName, String title, float importPrice, float exportPrice, float profit, String descriptions, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
    }
    
    
    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã sản phẩm:");
        productId = sc.nextLine();
        while (productId.length() == 4) {
            System.err.printf("\tMã danh mục phải = 4 và bắt đầu bằng ký tự C \n");
            System.out.printf("\tNhập mã sản phẩm:");
            productId = sc.nextLine(); 
        }
        System.out.printf("\tNhập tên sản phẩm:");
        productName = sc.nextLine();
        while (productName.length() == 4) {
            System.err.printf("\tTên sản phẩm phải >6 và <50 ký tự\n");
            System.out.printf("\tNhập tên sản phẩm:");
            productName = sc.nextLine(); 
        }
        System.out.printf("\tNhập tiêu đề:");
        productName = sc.nextLine();
        while (productName.length() == 4) {
            System.err.printf("\tTiêu đề phải >6 và <30 ký tự\n");
            System.out.printf("\tNhập tiêu đề:");
            productName = sc.nextLine(); 
        }
        System.out.printf("\tNhập nhập bán sản phẩm:");
        importPrice = sc.nextFloat();
        while (importPrice >0) {
            System.err.printf("\tGiá nhập sản phẩm phải là số thực và lớn hơn 0\n");
            System.out.printf("\tNhập giá nhập sản phẩm:");
            importPrice = sc.nextFloat(); 
            try {
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số thực :");
                  sc.nextLine();
            }
        }
        System.out.printf("\tNhập giá bán sản phẩm:");
        exportPrice = sc.nextFloat();
        while (exportPrice >0 && (exportPrice>MIN_INTEREST_RATE)) {
            System.err.printf("\tGiá bán sản phẩm phải lớn hơn 0\n");
            System.out.printf("\tNhập giá bán sản phẩm:");
            exportPrice = sc.nextFloat(); 
            try {
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số thực :");
                  sc.nextLine();
            }
        }
        System.out.printf("\tNhập mô tả sản phẩm:");
        descriptions = sc.nextLine();
        while (descriptions.length() >0) {
            System.err.printf("\tMô tả sản phẩm\n");
            System.out.printf("\tNhập mô tả sản phẩm:");
            descriptions = sc.nextLine();   
        }
        System.out.printf("\tNhập trạng thái sản phẩm:");
        while(true){
            try {
                this.productStatus = sc.nextBoolean();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng(true/false)");
                System.out.printf("\tNhập trạng thái sản phẩm: ");
                sc.nextLine();
            }
        }
    }
    @Override
    public void calProfit() {
        float loinhuan= (exportPrice-importPrice);
        System.out.println("Lợi nhuận là:"+loinhuan);   
    }
    @Override
    public void displayData() {
         StringBuilder builder = new StringBuilder();
        builder.append(this.productId);
        builder.append("\t|");
        builder.append(this.productName);
        builder.append("\t|");
        builder.append( this.title);
        builder.append("\t|");
        builder.append( this.importPrice);
        builder.append("\t|");
         builder.append( this.exportPrice);
        builder.append("\t|");
        builder.append( this.profit);
        builder.append("\t|");
        builder.append( this.descriptions);
        builder.append("\t|");
        builder.append( this.productStatus);
        builder.append("\t|");
        System.out.print(builder.toString());
    }
}
