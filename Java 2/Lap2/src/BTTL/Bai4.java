/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTL;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class Bai4 {
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private float price;

    public Bai4() {
    }

   

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public Bai4(String isbn, String bookName, String author, String publisher, float price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    String REGEX = "^[a-zA-Z 0-9]{1,64}$";
    String gia = "[0-9]{1,3}$";
   public void nhap(){
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập isbn:");
            isbn = nhap.nextLine();
            
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(isbn);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tIsbn không để trống");
            }
        }while(true);
        
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập bookName:");
            bookName = nhap.nextLine();
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(bookName);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tKhông vượt để trống");
            }
        }while(true);
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập author:");
             author = nhap.nextLine();
            
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(author);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tKhông để trống");
            }
        }while(true);
        do{
             Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập publisher:");
             publisher = nhap.nextLine();
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(publisher);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tKhông để trống");
            }
        }while(true);
         Scanner nhap = new Scanner(System.in);
        System.out.printf("\tNhập price:");
         price = nhap.nextFloat();
//         do{
//            Scanner nhap = new Scanner(System.in);
//            System.out.printf("\tNhập price:");
//             price = nhap.nextFloat();
//            Pattern pattern = Pattern.compile(gia);
//            Matcher matcher = pattern.matcher(nhap.nextLine());
//            if(matcher.matches()){
//                break;
//            }else{
//                System.err.println("\tKhông để trống");
//            }
//        }while(true);
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
  
        builder.append((String.format(this.isbn)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.bookName)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.author)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.publisher)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.price)));
        
        System.out.println(builder.toString());
        return super.toString();
    }
    
    
}
