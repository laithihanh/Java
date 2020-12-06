/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_4;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BTH1 {
    private String rollNumber;
    private String fullName;
    private String className;
    
    public BTH1() {
    }
    
    public BTH1(String rollNumber, String fullName, String className) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.className = className;
    }
    
    public String getRollNumber() {
    return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getFullName() {
    return fullName;
    }
    public void setFullName(String fullName) {
    this.fullName = fullName;
    }
    public String getClassName() {
    return className;
    }
    public void setClassName(String className) {
    this.className = className;
    }
    
    public void inputData(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhap vao ma sinh vien:");
        rollNumber = nhap.nextLine();
        System.out.printf("Nhap vao ho ten sinh vien:");
        fullName = nhap.nextLine();
        System.out.printf("Nhap vao ten lop hoc:");
        className = nhap.nextLine();
    }
    
    public void displayData(){
        System.out.println("Sinh vien:");
        System.out.println("\tMa sinh vien: "+rollNumber);
        System.out.println("\tHo ten: "+fullName);
        System.out.println("\tLop: "+className);
    }
    }