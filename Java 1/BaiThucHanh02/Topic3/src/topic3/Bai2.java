/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic3;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai2 {
    private String rollNo;
    private String name;
    private int age;
    private String address;
    private float tMark;
    private float pMark;
    
    public Bai2() {
    }

    public Bai2(String rollNo, String name, int age, String address, float tMark, float pMark) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tMark = tMark;
        this.pMark = pMark;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float gettMark() {
        return tMark;
    }

    public void settMark(float tMark) {
        this.tMark = tMark;
    }

    public float getpMark() {
        return pMark;
    }

    public void setpMark(float pMark) {
        this.pMark = pMark;
    }
    
    public void studentInput(){
        Scanner nhap = new Scanner(System.in);
        System.out.printf("Nhap mã số sinh viên:");
        rollNo = nhap.nextLine();
        System.out.printf("Tên sinh viên:");
        name = nhap.nextLine();
        System.out.printf("Tuổi sinh viên:");
        age = nhap.nextInt();
        nhap.nextLine();
        System.out.printf("Địa chỉ:");
        address = nhap.nextLine();
        System.out.printf("Điểm lý thuyết:");
        tMark = nhap.nextFloat();
        System.out.printf("Điểm thực hành:");
        pMark = nhap.nextFloat();
        
    }
//    public void studentInfo(){
//        System.out.println("\trollNo:"+rollNo);
//        System.out.println("\t:name "+name);
//        System.out.println("\tage: "+age);
//        System.out.println("\taddress: "+address);
//        System.out.println("\tMark: "+tMark);
//        System.out.println("\tpMark: "+pMark);
//    }
    public void studentInfo() {
        String data = "Student{" + "rollNo=" + rollNo + ", name=" + name
        + ", age=" + age + ", address=" + address
        + ", tMark=" + tMark + ", pMark=" + pMark + '}';
        System.out.println(data);
    }
    
    
}
