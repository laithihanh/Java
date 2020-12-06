/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class MainActivity {
    ETransaction eTran;
    private int showMenu() {
        System.out.println("\t.: " + eTran.getText(ELanguage.menu) + " :.");
        System.out.println("1. " + eTran.getText(ELanguage.importc));
        System.out.println("2. " + eTran.getText(ELanguage.display));
        System.out.println("3. " + eTran.getText(ELanguage.search));
        System.out.println("4. " + eTran.getText(ELanguage.transactionDay));
        System.out.println("5. " + eTran.getText(ELanguage.change));
        System.out.println("6. " + eTran.getText(ELanguage.exit));
        System.out.println(eTran.getText(ELanguage.plzchoose));
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    private void insert() {
        GiaoDich p = new GiaoDich();
        p.input();
        Main_Transaction pm = new Main_Transaction(eTran);
        pm.insert(p);
    }
    private void display() {
        Main_Transaction pm = new Main_Transaction(eTran);
        pm.display();
    }
    private void search() {
        Main_Transaction pm = new Main_Transaction(eTran);
        pm.search(0);
    }
    private void transactionDay() {
        Main_Transaction pm = new Main_Transaction(eTran);
        pm.transactionDay();
    }
    private void doiNgonNgu() {
        System.out.println(eTran.getText(ELanguage.clanguage) + ":");
        System.out.println("1. English");
        System.out.println("2. Japanese");
        System.out.println("3. Tiếng Việt");
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        switch (c) {
            case 1:
            eTran.setLocale(ELanguage.US);
            break;
            case 2:
            eTran.setLocale(ELanguage.JAPAN);
            break;
            case 3:
            eTran.setLocale(ELanguage.VIET_NAM);
            break;
        }
    }
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        MainActivity main = new MainActivity();
            main.eTran = new ETransaction();
            main.eTran.setLocale(ELanguage.US);
        int luaChon = 0;
        while(true){
//            System.out.println("===== MENU =====");
//            System.out.println("1. Nhập giao dịch.");
//            System.out.println("2. Hiển thị giao dịch.");
//            System.out.println("3. Tìm kiếm giao dịch");
//            System.out.println("4. Giao dịch trong ngày");
//            System.out.println("5. Đổi ngôn ngữ");
//            System.out.println("6. Thoát");
//            System.out.printf("Vui lòng chọn từ 1 -> 6:");
//            
//            int chon = nhap.nextInt();
//            nhap.nextLine();
//            GiaoDich gd= new GiaoDich();
            luaChon = main.showMenu();
            
            switch(luaChon){
                case 1:
                    main.insert();
                    break;
                case 2:
                    main.display();
                    break;
                case 3:
                    main.search();
                    break;
                case 4:
                    main.transactionDay();
                    break;
                case 5:
                    main.doiNgonNgu();
                    break;
                case 6:
                     System.exit(0);
                    break;
            }
        }
    }
        
}
