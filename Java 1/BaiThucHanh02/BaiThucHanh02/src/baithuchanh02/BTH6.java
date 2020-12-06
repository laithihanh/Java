/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh02;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class BTH6 {
    public static void main(String[] args) {
        int nhap,n;
        Scanner input = new Scanner(System.in);
    while(true){
    System.out.println("\t========MENU=======");
    System.out.println("\t1. Vẽ tam giác vuông đặc");
    System.out.println("\t2. Vẽ tam giác vuông đặc ngược");
    System.out.println("\t3. Vẽ tam giác cân đặc");
    System.out.println("\t4.Thoát");
    
    System.out.printf("Mời bạn chọn:");
    nhap = input.nextInt();

        switch(nhap){
            case 1:
                System.out.printf("Nhập n cạnh của tam giác:");
                n = input.nextInt();
                for(;n<=0;)
                    {
                        System.out.printf("Phai nhap n > 0 \nNhap lai n: ");
                         n = input.nextInt();
                    }
                for(int i = 1; i <= n; i++)
                {
                    for(int j = 1; j <= i; j++)
                    {
                         System.out.printf("*");            
                    }
                     System.out.printf("\n");
                }    
                break;
            case 2:
                System.out.printf("Nhập n cạnh của tam giác:");
                n = input.nextInt();
                for(;n<=0;)
                    {
                        System.out.printf("Phai nhap n > 0 \nNhap lai n: ");
                         n = input.nextInt();
                    }
                for(int i = n; i >= 1; i--) {
                    for(int j = 1; j <= i; j++)
                       System.out.printf("$ ");

                    System.out.printf("\n");
                }
                break;
            case 3:
                int q=0;
                System.out.printf("Nhập n cạnh của tam giác:");
                n = input.nextInt();
                for(;n<=0;)
                    {
                        System.out.printf("Phai nhap n > 0 \nNhap lai n: ");
                         n = input.nextInt();
                    }
                while (n > 0)
                {
                    for (int i = 1; i<n; i++)
                        System.out.printf("%c", ' ');
                    for (int k = 0; k <= q; k ++)
                        System.out.printf("%c", '*');
                    n -- ;
                    q += 2 ;
                    System.out.printf("\n");
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Bạn chọn sai mời chọn lại!!!!");
        }
        }
    }
}
