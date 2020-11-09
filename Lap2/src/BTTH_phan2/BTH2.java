/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan2;

/**
 *
 * @author ADMIN
 */
public class BTH2 {
    public static < E> void printArray(E[] inputArray) {
    // Display array elements
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        //Bước 2: Khởi tạo các mảng với kiểu dữ liệu khác nhau.
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        //Bước 4: Gọi hàm printArray() và truyền dữ liệu.
        System.out.println("Array integerArray contains:");
        printArray(intArray); // pass an Integer array
        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // pass a Double array
        System.out.println("\nArray characterArray contains:");
        printArray(charArray); // pass a Character array
    }
}
