/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Categories implements ICategories{
    
    private int catalogId ;// – Mã danh mục – Phải là số nguyên lớn hơn 0, duy nhất
    private String catalogName;//  – Tên danh mục – Phải gồm từ 6-30 ký tự
    private String descriptions; //– Mô tả danh mục – Không được để trống khi nhập
    private boolean catalogStatus ;//  – Trạng thái danh mục – chỉ nhận giá trị true hoặc false khi nhập
    private int parentId ;// – Mã danh mục cha – khi nhập danh mục cha phải tồn tại (chỉ quản lý tối đa 3 cấp danh mục – danh mục gốc có parentId = 0)

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
        this.parentId = parentId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    
    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã danh mục:");
        catalogId = sc.nextInt();
        while (catalogId>0) {
            System.err.printf("\tMã danh mục phải > 0\n");
            System.out.printf("\tNhập mã danh mục:");
            catalogId = sc.nextInt(); 
        }
        System.out.printf("\tNhập tên danh mục:");
        catalogName = sc.nextLine();
        while (catalogName.length()>6 || catalogName.length()<30) {
            System.err.printf("\tTên danh mục phải > 6 và <30 ký tự\n");
            System.out.printf("\tNhập tên danh mục:");
            catalogName = sc.nextLine(); 
        }
        System.out.printf("\tNhập mô tả danh mục:");
        descriptions = sc.nextLine();
        while (descriptions.length()>0) {
            System.err.printf("\tMô tả không được để trống\n");
            System.out.printf("\tNhập mô tả danh mục:");
            descriptions = sc.nextLine(); 
        }
        
        while (true) {
            try {
                System.out.printf("\tNhập trạng thái:");
                catalogStatus = sc.nextBoolean();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập true hoặc false:");
                  sc.nextLine();
            }
        }
        while (true) {
            try {
                System.out.printf("\tNhập mã danh mục cha:");
                parentId = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số nguyên:");
                  sc.nextLine();
            }
        }
    }

    @Override
    public void displayData() {
       System.out.printf("\tMã danh mục: "+catalogId);
        System.out.printf("\tTên danh mục: "+catalogName);
        System.out.printf("\tMô tả danh mục:"+descriptions);
        System.out.printf("\tTrạng thái danh mục:"+(catalogStatus == true ? "Hoạt động" : "Không hoạt động"));
        System.out.printf(" \tMã danh mục cha:"+parentId);
    }
    
}
