/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ManagerPlayer {
    List<FootBallPlayer> lstFootBallPlayer = new ArrayList<>();

    public void showMenu() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("**********************MENU*********************");
            System.out.println("1. Nhập thông tin cho n cầu thủ bóng đá");
            System.out.println("2. Hiển thị thông tin các cầu thủ");
            System.out.println("3. Sắp xếp danh sách giảm dần theo tổng lương theo năm và hiển thị");
            System.out.println("4. Sắp xếp danh sách tăng dần theo tên các cầu thủ và hiển thị");
            System.out.println("5. Tìm kiếm thông tin cầu thủ theo tên đội bóng");
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
                    sortSalaryByYear(sc);
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
        System.out.printf("Số lượng cầu thủ cần nhập: ");
        int n = sc.nextInt();
        FootBallPlayer footBallPlayer;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập cầu thủ " + (i + 1));
            footBallPlayer = new FootBallPlayer();
            footBallPlayer.input();
            lstFootBallPlayer.add(footBallPlayer);
        }
    }

    private void display() {

        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh \t Câu lạc bộ \t Vị trí \t Phí chuyển nhượng \t Lương theo tuần \t Lương theo tháng \t Lương theo năm");
        for (FootBallPlayer f : lstFootBallPlayer) {
            f.display();
            System.out.println("=====================================================================================================================================");
        }
    }

    private void sortSalaryByYear(Scanner sc) {
        Collections.sort(lstFootBallPlayer, (
            FootBallPlayer o1, FootBallPlayer o2) -> (int) (o2.salaryForYear() - o1.salaryForYear())
        );
        System.out.println("Danh sách sắp xếp giảm dần là: ");
            for(int i=0;i<lstFootBallPlayer.size();i++){
                lstFootBallPlayer.get(i).display();
                System.out.println("------------------------------");
            }
    }

    private void sortName(Scanner sc) {
        Collections.sort(
            lstFootBallPlayer,
            (FootBallPlayer o1, FootBallPlayer o2) -> o1.getPlayerName().compareTo(o2.getPlayerName())
        );
        System.out.println("Danh sách sắp xếp tăng dần theo tên cầu thủ là: ");
            for(int i=0;i<lstFootBallPlayer.size();i++){
                lstFootBallPlayer.get(i).display();
                System.out.println("------------------------------");
            }
    }

    private void search(Scanner sc) {
         FootBallPlayer setSer = new FootBallPlayer();
         sc.nextLine();
        System.out.printf("Nhập tên đội bóng: ");
        String name = sc.nextLine();
        int flag = 0;
        System.out.println("Mã \t Tên \t Giới tính \t Ngày sinh \t Câu lạc bộ \t Vị trí \t Phí chuyển nhượng \t Lương theo tuần \t Lương theo tháng \t Lương theo năm");
        for (FootBallPlayer f : lstFootBallPlayer) {
            if (f.getFootballClub().toLowerCase().contains(name.trim().toLowerCase())) {
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
        ManagerPlayer managerPlayer = new ManagerPlayer();
        managerPlayer.showMenu();
    }
}
