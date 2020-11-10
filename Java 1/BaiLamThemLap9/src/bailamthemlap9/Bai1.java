/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap9;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai1 {

    private String Name; //Tên nhân viên
    public int YearOfBirth; //Năm sinh
    private float Salary;; //Lương
    private int Gender;// 0: Nữ, 1: Nam

    public Bai1() {
    }

    public Bai1(String Name, int YearOfBirth, float Salary, int Gender) {
        this.Name = Name;
        this.YearOfBirth = YearOfBirth;
        this.Salary = Salary;
        this.Gender = Gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(int YearOfBirth) {
        this.YearOfBirth = YearOfBirth;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }
   
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên nhân viên:");
        Name = sc.nextLine();
        while (Name.length()>30) {
            System.out.printf("\tHọ tên phải không vượt quá 30 ký tự\n");
            System.out.printf("\tNhập tên nhân viên:");
            Name = sc.nextLine(); 
        }
        while (true) {
            try {
            
               System.out.printf("\tNhập năm sinh:");
               YearOfBirth = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }
        while (true) {
            try {
            
               System.out.printf("\tNhập lương:");
                Salary = sc.nextFloat();
                break;
            } catch (Exception ex) {
                System.out.println("Yêu cầu nhập số thực:");
                System.out.println(""+ex.getLocalizedMessage());
                  sc.nextLine();
            }
        }   
        
        System.out.printf("\tNhập giới tính(0 chọn nữ, 1 chọn nam):");
        Gender = sc.nextInt();
        while ((Gender!=0) && (Gender !=1)) {
            System.out.printf("\tNữ (0), Nam (1):");
            Gender = sc.nextInt(); 
        }
    }
    public void display(){
       
        System.out.println("\tTên:"+Name);
        System.out.println("\tNăm sinh:"+YearOfBirth);
        System.out.println("\tLương:"+Salary);
        System.out.println("\tGiới tính:"+Gender);
    }

   
   
}
