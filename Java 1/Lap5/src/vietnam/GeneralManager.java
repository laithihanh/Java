/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vietnam;

import java.util.Scanner;
import lap5.Bai1;

/**
 *
 * @author USER
 */
public class GeneralManager {
    Bai1 arrMayTinh[] = new Bai1[5];
        private int showMenu() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\t.: MENU :.");
            System.out.println("\t1. Nhập thông tin cho n sản phẩm được nhập khẩu vào VietNam");
            System.out.println("\t2. Nhập thông tin cho n sản phẩm được nhập khẩu vào ThaiLand");
            System.out.println("\t3. Hiển thị tất cả thông tin các sản phẩm ở Việt Nam cũng như ở Thái Lan");
            System.out.println("\t4. Sắp xếp các sản phẩm tăng dần theo tên sản phẩm và hiển thị danh sách\n" +"sau khi sắp xếp.");
            System.out.println("\t5. Tính toán giá bán sản phẩm ở Việt Nam và ở Thái Lan sau đó hiển thị danh\n" +"sách sản phẩm với thông tin và cả giá bán.");
            System.out.println("\t6. Tìm kiếm sản phẩm theo giá bán và hiển thị kết quả tìm kiếm");
            System.out.println("\t7.Kết thúc.");
            return sc.nextInt();
        }
}
