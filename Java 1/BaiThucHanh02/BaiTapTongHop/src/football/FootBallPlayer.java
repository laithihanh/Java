/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package football;

import java.util.Date;
import java.util.Scanner;
import player.Player;
import salary.ISalary;

/**
 *
 * @author USER
 */
public class FootBallPlayer extends Player implements ISalary{
    private String footballClub;
    private String playPosition;
    private double transferCost;
    private double salaryPerWeek;

    public FootBallPlayer() {
    }

    public FootBallPlayer(String footballClub, String playPosition, double transferCost, double salaryPerWeek, String playerId, String playerName, Boolean gender, Date birthday) {
        super(playerId, playerName, gender, birthday);
        this.footballClub = footballClub;
        this.playPosition = playPosition;
        this.transferCost = transferCost;
        this.salaryPerWeek = salaryPerWeek;
    }

    public String getFootballClub() {
        return footballClub;
    }

    public void setFootballClub(String footballClub) {
        this.footballClub = footballClub;
    }

    public String getPlayPosition() {
        return playPosition;
    }

    public void setPlayPosition(String playPosition) {
        this.playPosition = playPosition;
    }

    public double getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(double transferCost) {
        this.transferCost = transferCost;
    }

    public double getSalaryPerWeek() {
        return salaryPerWeek;
    }

    public void setSalaryPerWeek(double salaryPerWeek) {
        this.salaryPerWeek = salaryPerWeek;
    }
    
    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
        StringBuilder builder = new StringBuilder();
        builder.append("\t|");
        builder.append(this.footballClub);        
        builder.append("\t|");
        builder.append(this.playPosition);
        builder.append("\t|");
        builder.append(this.transferCost);
        builder.append("\t|");
        builder.append(this.salaryPerWeek);
        builder.append("\t|");
        builder.append(this.salaryForMonth());
        builder.append("\t|");
        builder.append(this.salaryForYear());
        System.out.println(builder.toString());
    }

    @Override
    public void input() {
        super.input(); //To change body of generated methods, choose Tools | Templates.
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập câu lạc bộ: ");
        this.footballClub = sc.nextLine();
        System.out.printf("\tVị trí: ");
        this.playPosition = sc.nextLine();
        System.out.printf("\tPhí chuyển nhượng: ");
        this.transferCost = sc.nextDouble();
        System.out.printf("\tLương theo tuần: ");
        this.salaryPerWeek = sc.nextDouble();
    }
    @Override
    public double salaryForMonth() {
        return this.salaryPerWeek * 4;//tính lương theo tháng
    }

    @Override
    public double salaryForYear() {
        return this.salaryForMonth() * 12;//tính lương theo năm
    }
}
