/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailamthemlap11.manager;

import bailamthemlap11.Bai2.Person;
import bailamthemlap11.employee.Employee;
import bailamthemlap11.student.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class PersonManager {
    List<Person> lstPerson = new ArrayList<>();
    
    public PersonManager(){
        
    }
    public void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\t==========Chon menu=========");
            System.out.println("\t1. Nhập thông tin cho n người");
            System.out.println("\t2.Hiển thị thông tin vừa nhập");
            System.out.println("\t3. Sắp xếp thông tin theo tên người tăng dần và hiển thị");
            System.out.println("\t4. Tìm kiếm thông tin theo tên người và đếm xem có bao nhiêu người có tên như vậy.");
            System.out.println("\t5. Thoát");
            System.out.print("Chọn chức năng 1->5: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    input(sc);
                    break;
                case 2:
                    display(lstPerson);
                    break;
                case 3:
//                   sortDescending();
                   sortAscending();//tăng
                    break;
                case 4:
                    search(sc);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    public void input(Scanner sc) {
        System.out.printf("Nhập nhân viên chọn(v); Nhập học sinh chọn (s):");
        String str =  sc.nextLine();
         char c = ' ';
        if(str.length() >= 0){
             c = str.charAt(0);
        }
       
        System.out.printf("Số người cần nhập: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhân viên %d \n",i+1);
            if (c == 'v' || c == 's') {
                Employee person = new Employee();
                person.input();
                lstPerson.add(person);
            } else {
                Student person = new Student();
                System.out.printf("Nhân viên %d \n",i+1);
                System.out.println("");
                person.input();
                lstPerson.add(person);
            }
        }
    }
    public void display(List<Person> lst) {
        for (int i = 0; i < lstPerson.size(); i++) {
            if (lstPerson.get(i) instanceof Employee) {
                ((Employee) lstPerson.get(i)).display();
                System.out.println("");
            } else {
                 System.out.println("");
                ((Student) lstPerson.get(i)).display();
            }
        }
    }
    public void sortAscending(){
        Collections.sort(lstPerson);
        System.out.println("Danh sách tăng dần theo tên người: ");
        for(Person f : lstPerson){
            f.display();
        }
    }
    public void search(Scanner sc){
        Person searchSer;
        Person setSer = new Person();
        int i;
        int count =0;
         System.out.print("Nhập tên người cần tìm: ");
         String search = sc.nextLine();
         setSer.setHoTen(search);
        System.out.println("Danh sách người tìm thấy: ");
        for(i=0; i<lstPerson.size();i++){
            searchSer = (Person) lstPerson.get(i);
            if(searchSer.getHoTen().contains(search)){
                count++;
                searchSer.display();
            }
        }
        System.out.println("Tổng số người tìm thấy : "+count);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        PersonManager app = new PersonManager();
        app.run();
    }
}
