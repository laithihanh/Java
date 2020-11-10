/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ManagerMark {
    List<BKapStudent> lstBKapStudent = new ArrayList<>();

    public void showMenu() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("**********************MENU*********************");
            System.out.println("1. Nhập vào thông tin điểm thi của n sinh viên Bách Khoa Aptech");
            System.out.println("2. Hiển thị thông tin vừa nhập");
            System.out.println("3. Sắp xếp và hiển thị thông tin giảm dần theo học bổng nhận được");
            System.out.println("4. Sắp xếp và hiển thị thông tin tăng dần theo tên lớp");
            System.out.println("5. Tìm kiếm thông tin sinh viên theo tên lớp");
            System.out.println("6. Thoát");
             System.out.print("Chọn chức năng 1->6: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    input(sc);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    sortSalaryByscholarShip(sc);
                    break;
                case 4:
                    sortName(sc);
                    break;
                case 5:
                    search(sc);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private void input(Scanner sc) {
        System.out.printf("Số lượng sinh viên cần nhập: ");
        int n = sc.nextInt();
        BKapStudent Student;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên " + (i + 1));
            Student = new BKapStudent();
            Student.input();
            lstBKapStudent.add(Student);
        }
    }

    private void display() {

        System.out.println("Tên \t Giới tính \t Tên lớp \t Điểm C \t Điểm HTML \t Điểm SQL \t Điểm PHP \t Tên khóa học \t Học bổng ");
        for (BKapStudent f : lstBKapStudent) {
            f.display();
            System.out.println("=====================================================================================================================================");
        }
    }

    private void sortSalaryByscholarShip(Scanner sc) {
        Collections.sort(lstBKapStudent, (
            BKapStudent o1, BKapStudent o2) -> (int) (o2.getScholarShip() - o1.getScholarShip())
        );
        System.out.println("Danh sách sắp xếp giảm dần theo học bổng là: ");
        System.out.println("Tên \t Giới tính \t Tên lớp \t Điểm C \t Điểm HTML \t Điểm SQL \t Điểm PHP \t Tên khóa học \t Học bổng ");
            for(int i=0;i<lstBKapStudent.size();i++){
                lstBKapStudent.get(i).display();
                System.out.println("------------------------------");
            }
    }

    private void sortName(Scanner sc) {
        Collections.sort(
            lstBKapStudent,
            (BKapStudent o1, BKapStudent o2) -> o1.getClassName().compareTo(o2.getClassName())
        );
        System.out.println("Danh sách sắp xếp tăng dần theo tên lớp là: ");
        System.out.println("Tên \t Giới tính \t Tên lớp \t Điểm C \t Điểm HTML \t Điểm SQL \t Điểm PHP \t Tên khóa học \t Học bổng ");
            for(int i=0;i<lstBKapStudent.size();i++){
                lstBKapStudent.get(i).display();
                System.out.println("------------------------------");
            }
    }

    private void search(Scanner sc) {
         BKapStudent setSer = new BKapStudent();
         sc.nextLine();
        System.out.printf("Nhập tên lớp: ");
        String name = sc.nextLine();
        int flag = 0;
        System.out.println("Tên \t Giới tính \t Tên lớp \t Điểm C \t Điểm HTML \t Điểm SQL \t Điểm PHP \t Tên khóa học \t Học bổng ");
        for (BKapStudent f : lstBKapStudent) {
            if (f.getClassName().toLowerCase().contains(name.trim().toLowerCase())) {
                f.display();
                flag++;
                System.out.println("=====================================================================================================================================");
            }
        }

        if (flag == 0) {
            System.err.println("Không tìm thấy dữ liệu phù hợp: " + name);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ManagerMark managerStudent = new ManagerMark();
        managerStudent.showMenu();
    }
}
