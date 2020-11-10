/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon;

/**
 *
 * @author USER
 */
public interface IProduct {
    public static double MIN_INTEREST_RATE = 0.2;// lãi suất nhỏ nhất trên từng sản phẩm
    void inputData();// Nhập thông tin sản phẩm
    void displayData();// Hiển thị thông tin sản phẩm
    void calProfit();// Tính lợi nhuận trên tất cả sản phẩm
}
