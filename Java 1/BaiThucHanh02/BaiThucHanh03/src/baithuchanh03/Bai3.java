/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithuchanh03;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bai3 {
    public static void main(String[] args) {
        int n,m;
    Scanner input = new Scanner(System.in);
    System.out.printf("Nhập vào số dòng:");
    n = Integer.parseInt(input.nextLine());
    System.out.printf("Nhập vào số cột:");
    m = Integer.parseInt(input.nextLine());
    int[][] arr = new int[n][m];
    
    do{
            System.out.println("\t**********MENU**********");
            System.out.println("\t1.Nhập giá trị phần tử mảng");
            System.out.println("\t2.Hiển thị mảng vừa nhập theo ma trận");
            System.out.println("\t3.In giá trị các phần từ nằm trên đường biên");
            System.out.println("\t4.In giá trị và tổng các phần tử nằm trên đường chéo chính và đường chéo phụ");
            System.out.println("\t5.Sắp xếp các cột trong mảng tăng dần");
            System.out.println("\t6.Sắp xếp các hàng trong mảng tăng dần");
            System.out.println("\t7.Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            
            int choice = Integer.parseInt(input.nextLine());
            
            switch(choice){
                case 1:
                    System.out.println("Nhập giá trị phần tử mảng:");
                    for (int i = 0; i < n; i++) {
                        for(int j=0; j<m; j++){
                            System.out.printf("arr[%d][%d]:",i,j);
                            arr[i][j] = Integer.parseInt(input.nextLine());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Các giá trị phần tử mảng là:");
                    for (int i = 0; i < n; i++) {
                        for(int j=0; j<m; j++){
                            System.out.printf("%d\t",arr[i][j]);
                        }
                        System.out.printf("\n");
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    System.out.println("Các phần tử nằm trên đường biên là:");
                    for (int i = 0; i < n; i++) {
                        for(int j=0; j<m; j++){
                            if(i==0 || j==0 || i==(n-1) || j==(m-1)){
                                System.out.printf(" %d ",arr[i][j]);
                            }
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 4:
                    int sum=0,tong=0;
                    System.out.println("Các phần tử nằm trên đường chéo chính là:");
                    for (int i = 0; i < n; i++) {
                        for(int j=0; j<m; j++){
                            if(i==j){
                                System.out.printf(" %d ",arr[i][j]);
                                sum+=arr[i][j];
                            }
                        }
                    }
                    System.out.printf("\n");
                    System.out.println("Tổng phần tử nằm trên đường chéo chính là:"+sum);
                    System.out.println("Các phần tử nằm trên đường chéo phụ là:");
//                    
                    for(int i=0;i<n;i++){
                        for( int j=0;j<n;j++){
                            if((j+i)==(m-1)){
                            System.out.printf(" %d ",arr[i][j]);
				tong+=arr[i][j];
                            }
                        }
                    }
                    System.out.printf("\n");
                    System.out.println("Tổng phần tử nằm trên đường chéo chính là:"+tong);
                    System.out.printf("Tổng đường chéo chính và phụ là:%d\n",sum+tong);
                    break;
                case 5:
                    System.out.printf("\nSắp xếp tăng theo cột\n");
                    BubbleSortA(arr,m,n);
                    XuatMaTran(arr,m,n);
                    break;
                case 6:
                    System.out.printf("\nSắp xếp tăng theo hàng\n");
                    BubbleSortB(arr,m,n);
                    XuatMaTran(arr,m,n);
                    break;
                case 7:
                    System.exit(0);
            }
    }while(true);
    }
//    Sắp xếp tăng theo cột
   public static void BubbleSortA(int [][] arr, int m, int n)
    {
        for(int k = 0; k<n ; k++)
            for(int i = 0; i<m-1 ; i++)
                for(int j = m-1; j>i ; j--)
                    if(arr[j][k]<arr[j-1][k])
                    {
                        int temp = arr[j][k];
                        arr[j][k] = arr[j-1][k];
                        arr[j-1][k] = temp;
                    }
    }
//   Sắp xếp tăng theo hàng
   public static void BubbleSortB(int [][] arr, int m, int n)
    {
        for(int k = 0; k<n ; k++)
            for(int i = 0; i<m-1 ; i++)
                for(int j = m-1; j>i ; j--)
                    if(arr[k][j]<arr[k][j-1])
                    {
                        int temp = arr[k][j];
                        arr[k][j] = arr[k][j-1];
                        arr[k][j-1] = temp;
                    }
    }
   public static void XuatMaTran(int [][] arr, int m, int n)
    {
      for(int i = 0; i<m ; i++)
      {
          System.out.printf("\n");
          for(int j = 0; j<n ; j++)
            System.out.printf("%d\t",arr[i][j]);
      }

    }
}
