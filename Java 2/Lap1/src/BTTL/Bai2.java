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
public class Bai2 {
    String RollNo ;
    String Fullname;
    String Deskphone;
    String Cellphone;
    String Email ;
    String YearOfBirth ;

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getDeskphone() {
        return Deskphone;
    }

    public void setDeskphone(String Deskphone) {
        this.Deskphone = Deskphone;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public void setCellphone(String Cellphone) {
        this.Cellphone = Cellphone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(String YearOfBirth) {
        this.YearOfBirth = YearOfBirth;
    }

    String rollNo = "^C[0-9]{7}$";
    String fullname= "^[a-zA-Z 0-9]{1,64}$";
    String deskphone= "[0-9]{3}.[0-9]{6,7}$";
    String cellphone= "[0-9]{10,11}";
    String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@*gmail";
    String yearOfBirth = "^19([7-8][0-9])|(9[0-6])$";
     
     public void input(){
         
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập RollNo:");
            this.RollNo= nhap.nextLine();
            
            Pattern pattern = Pattern.compile(rollNo);
            Matcher matcher = pattern.matcher(RollNo);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tRollNo gồm 8 ký tự");
            }
        }while(true);
        
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập fullname:");
            this.Fullname= nhap.nextLine();
            Pattern pattern = Pattern.compile(fullname);
            Matcher matcher = pattern.matcher(Fullname);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tFullname không vượt quá 64 ký tự");
            }
        }while(true);
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập deskphone:");
            this.Deskphone= nhap.nextLine();
            Pattern pattern = Pattern.compile(deskphone);
            Matcher matcher = pattern.matcher(Deskphone);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tPhải có dạng 043.667788");
            }
        }while(true);
        do{
            Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập cellphone:");
            this.Cellphone= nhap.nextLine();
            Pattern pattern = Pattern.compile(cellphone);
            Matcher matcher = pattern.matcher(Cellphone);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tCellphone phải có 10-11 số");
            }
        }while(true);
         do{
             Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập email:");
            this.Email= nhap.nextLine();
            Pattern pattern = Pattern.compile(email);
            Matcher matcher = pattern.matcher(Email);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tEmail k đúng định dạng");
            }
        }while(true);
         do{
             Scanner nhap = new Scanner(System.in);
            System.out.printf("\tNhập yearOfBirth:");
            this.YearOfBirth= nhap.nextLine();
            Pattern pattern = Pattern.compile(yearOfBirth);
            Matcher matcher = pattern.matcher(YearOfBirth);
            if(matcher.matches()){
                break;
            }else{
                System.err.println("\tYearOfBirth k hợp lệ");
            }
        }while(true);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
  
        builder.append((String.format(this.RollNo)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.Fullname)));
        builder.append("\t|");
        builder.append((String.format("%15s",this.Deskphone)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.Cellphone)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.Email)));
        builder.append("\t|");
        builder.append((String.format("%10s", this.YearOfBirth)));
        
        
        System.out.println(builder.toString());
        return super.toString();
        
    }
     
     
}
