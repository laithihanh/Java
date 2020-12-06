/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import person.IPerson;

/**
 *
 * @author USER
 */
public class Player implements IPerson {
    private String playerId ;// Cố định 3 kí tự
    private String playerName ;// Không được rỗng
    private Boolean gender ;// Chỉ được nhập true/false
    private Date birthday ;//Không được sau ngày hiện tại

    public Player() {
    }

    public Player(String playerId, String playerName, Boolean gender, Date birthday) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }
    public String getBirthdayString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(birthday);
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã: ");
        while(true){
              this.playerId = sc.nextLine();
              if(this.playerId.length() == 3){
                  break;
              }else{
                  System.err.println("\tMã phải nhập đủ 3 ký tự");  
                  System.out.printf("\tNhập mã: ");
              }
        }
        
        System.out.printf("\tNhập tên: ");
       
        while(true){
              this.playerName = sc.nextLine();
              if(this.playerName.length() > 0){
                  break;
              }else{
                  System.err.println("\tTên không được để trống");
                  System.out.printf("\tNhập tên: ");
              }
        }
        
        System.out.printf("\tNhập giới tính: ");
        while(true){
            try {
                this.gender = sc.nextBoolean();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng(true/false)");
                System.out.printf("\tNhập giới tính: ");
                sc.nextLine();
            }
        }
        System.out.printf("\tNhập ngày sinh: ");
        while(true){
            try {
               String d = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 this.birthday = sdf.parse(d);
                 Date now = new Date(System.currentTimeMillis());
                 if(birthday.getYear() < now.getYear()){
                      break;
                 }
               
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng(dd/MM/yyyy)");
                System.out.printf("\tNhập ngày sinh: ");
//                sc.nextLine();
            }
        }
        
    }

    @Override
    public void display() {
       StringBuilder builder = new StringBuilder();
        builder.append(this.playerId);
        builder.append("\t|");
        builder.append(this.playerName);
        builder.append("\t|");
        builder.append( this.getGender());
        builder.append("\t|");
        builder.append( this.getBirthdayString());
        
        System.out.print(builder.toString());
    }

    
}
