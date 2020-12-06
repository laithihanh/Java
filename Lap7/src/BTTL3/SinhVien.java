/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL3;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class SinhVien {
    private int id ;
    private String rollNo ;
    private String sv_name;
    private String sv_address;
    private String sv_phone ;
    private String sv_email;

    public SinhVien() {
    }

    public SinhVien(int id, String rollNo, String sv_name, String sv_address, String sv_phone, String sv_email) {
        this.id = id;
        this.rollNo = rollNo;
        this.sv_name = sv_name;
        this.sv_address = sv_address;
        this.sv_phone = sv_phone;
        this.sv_email = sv_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getSv_name() {
        return sv_name;
    }

    public void setSv_name(String sv_name) {
        this.sv_name = sv_name;
    }

    public String getSv_address() {
        return sv_address;
    }

    public void setSv_address(String sv_address) {
        this.sv_address = sv_address;
    }

    public String getSv_phone() {
        return sv_phone;
    }

    public void setSv_phone(String sv_phone) {
        this.sv_phone = sv_phone;
    }

    public String getSv_email() {
        return sv_email;
    }

    public void setSv_email(String sv_email) {
        this.sv_email = sv_email;
    }
    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.println("Mã sinh viên: ");
            this.rollNo = s.nextLine();
        while(true){
        if(rollNo.length()<=8 && rollNo.length() > 0){
             break;
        }else{
            System.err.printf("\tMã sinh viên không vượt quá 8 ký tự\n");
            System.out.printf("\tNhập lại:");
            rollNo = s.nextLine(); 
        }
        }
        System.out.printf("\tTên sinh viên: ");
        this.sv_name = s.nextLine();
        while(true){
            if(sv_name.length()> 0){
                 break;
            }else{
                System.err.printf("\tTên sinh viên không được để trống\n");
                System.out.printf("\tNhập lại:");
                sv_name = s.nextLine(); 
            }
        }
        System.out.printf("\tĐịa chỉ: ");
        this.sv_address = s.nextLine();
        while (true) {
            if(sv_address.length()> 0){
                 break;
            }else{
                System.err.printf("\tĐịa chỉ không được để trống\n");
                System.out.printf("\tNhập lại:");
                sv_address = s.nextLine(); 
            }
        }
        // s.nextLine(); // clear
        System.out.printf("\tSố điện thoại: ");
        this.sv_phone = s.nextLine();
        while (true) {
            if(sv_phone.length() == 11 && sv_phone.length() >0 ){
                 break;
            }else{
                System.err.println("\tSố điện thoại phải đủ 11 số");
                System.out.printf("\tNhập lại:");
                sv_phone = s.nextLine(); 
            }
        }
        System.out.printf("\tEmail: ");
        this.sv_email = s.nextLine();
        while (true) {
            if(sv_email.length()> 0){
                 break;
            }else{
                System.err.println("\tEmail không được để trống");
                System.out.printf("\tNhập lại:");
                sv_email = s.nextLine(); 
            }
        }
        System.out.printf("Cảm ơn");
    }
    
}
