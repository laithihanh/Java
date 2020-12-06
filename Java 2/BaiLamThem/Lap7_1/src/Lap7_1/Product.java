/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap7_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Product {
    private int ProductId ; 
    private int CatelogId ; 
    private String ProductName ;
    private String Content ;
    private String ContentDetail ;
    private float PriceInput ;
    private float PriceOutput;
    private LocalDate Created ;
    private int Views ;
    private int BuyItem;
    private boolean Status ;

    public Product() {
    }

    public Product(int ProductId, int CatelogId, String ProductName, String Content, String ContentDetail, float PriceInput, float PriceOutput, LocalDate Created, int Views, int BuyItem, boolean Status) {
        this.ProductId = ProductId;
        this.CatelogId = CatelogId;
        this.ProductName = ProductName;
        this.Content = Content;
        this.ContentDetail = ContentDetail;
        this.PriceInput = PriceInput;
        this.PriceOutput = PriceOutput;
        this.Created = Created;
        this.Views = Views;
        this.BuyItem = BuyItem;
        this.Status = Status;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getCatelogId() {
        return CatelogId;
    }

    public void setCatelogId(int CatelogId) {
        this.CatelogId = CatelogId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getContentDetail() {
        return ContentDetail;
    }

    public void setContentDetail(String ContentDetail) {
        this.ContentDetail = ContentDetail;
    }

    public float getPriceInput() {
        return PriceInput;
    }

    public void setPriceInput(float PriceInput) {
        this.PriceInput = PriceInput;
    }

    public float getPriceOutput() {
        return PriceOutput;
    }

    public void setPriceOutput(float PriceOutput) {
        this.PriceOutput = PriceOutput;
    }

    public LocalDate getCreated() {
        return Created;
    }

    public void setCreated(LocalDate Created) {
        this.Created = Created;
    }

    public int getViews() {
        return Views;
    }

    public void setViews(int Views) {
        this.Views = Views;
    }

    public int getBuyItem() {
        return BuyItem;
    }

    public void setBuyItem(int BuyItem) {
        this.BuyItem = BuyItem;
    }

    public boolean isStatus() {
        return Status;
    }
    public String getStatus(){
        return Status == true ? "Còn hàng" : "Hết hàng" ;
    } 
    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.printf("\tNhập mã danh mục:");
                CatelogId = sc.nextInt();
                while(CatelogId <0){
                    System.err.println("\tMã danh mục phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.printf("\tTên sản phẩm:");
        ProductName= sc.nextLine();
        while(true){
            if(ProductName.length()> 0){
                 break;
            }else{
                System.err.printf("\tTên sản phẩm không được để trống\n");
                System.out.printf("\tNhập lại:");
                ProductName = sc.nextLine(); 
            }
        }
        System.out.printf("\tNội dung:");
        Content= sc.nextLine();
        while(true){
            if(Content.length()> 0){
                 break;
            }else{
                System.err.printf("\tNội dung không được để trống\n");
                System.out.printf("\tNhập lại:");
                Content = sc.nextLine(); 
            }
        }
        System.out.printf("\tChi tiết nội dung:");
        ContentDetail= sc.nextLine();
        while(true){
            if(ContentDetail.length()> 0){
                 break;
            }else{
                System.err.printf("\tChi tiết nội dung không được để trống\n");
                System.out.printf("\tNhập lại:");
                ContentDetail = sc.nextLine(); 
            }
        }
        while (true) {
            try {
                System.out.printf("\tGiá gốc: ");
                this.PriceInput = sc.nextFloat();
                while(PriceInput < 0){
                    System.err.println("\tGiá gốc phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tGiá bán: ");
                this.PriceOutput = sc.nextFloat();
                while(PriceOutput < 0){
                    System.err.println("\tGiá bán phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }
        sc.nextLine();
        while(true){
             System.out.printf("\tNgày sản xuất: ");
            try {
                this.Created = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("\tKhông đúng định dạng: dd/MM/yyyyy");
            }
        }
        while (true) {
            try {
                System.out.printf("\tLượt xem: ");
                this.Views = sc.nextInt();
                while(Views < 0){
                    System.err.println("\tLượt xem phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }
        
        while (true) {
            try {
                System.out.printf("\tBuyItem: ");
                this.BuyItem = sc.nextInt();
                while(BuyItem < 0){
                    System.err.println("\tLượt xem phải lớn hơn 0");
                    System.out.printf("\tNhập lại:");
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }
        while(true){
            try {
            
               System.out.printf("\tNhập trạng thái sản phẩm:");
                Status = sc.nextBoolean();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập true hoặc false :");
                  sc.nextLine();
            }
        }
    }
    @Override
    public String toString() {
        return "Product{" + "ProductId=" + ProductId + ", CatelogId=" + CatelogId + ", ProductName=" + ProductName + ", Content=" + Content + ", ContentDetail=" + ContentDetail + ", PriceInput=" + PriceInput + ", PriceOutput=" + PriceOutput + ", Created=" + Created + ", Views=" + Views + ", BuyItem=" + BuyItem + ", Status=" + Status + '}';
    }
    public void display(){
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format("%-16d", this.ProductId));
        builder.append(String.format("%-14d", this.CatelogId));
        builder.append(String.format("%-20s", this.ProductName));
        builder.append(String.format("%-22s", this.Content));
        builder.append(String.format("%-23s", this.ContentDetail));
        builder.append(String.format("%-14.2f", this.PriceInput));
        builder.append(String.format("%-19.2f", this.PriceOutput));
        builder.append(String.format("%-15s", this.Created));
        builder.append(String.format("%-10d", this.Views));
        builder.append(String.format("%-10d", this.BuyItem));
        builder.append(String.format("%-10b", this.Status));
        
        System.out.println(builder.toString());
    }
    
}