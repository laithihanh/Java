/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Work implements IWork{
    private String workId ;
    private String workName;
    private Date startDate;
    private Date endDate;
    private Double totalCost;

    public Work() {
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getStartDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(startDate);
    }
    public Date getEndDate() {
        return endDate;
    }
    public String getEndDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(endDate);
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
    public Work(String workId, String workName, Date startDate, Date endDate, Double totalCost) {
        this.workId = workId;
        this.workName = workName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
    }
    

    @Override
    public void input() {
       Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã công việc:");
        workId= sc.nextLine();
        System.out.printf("\tNhập tên công việc:");
        workName= sc.nextLine();
        System.out.printf("\tNhập ngày bắt đầu cv:");
        while(true){
            try {
               String d = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 this.startDate = sdf.parse(d);
                 Date now = new Date(System.currentTimeMillis());
                 if(startDate.getYear() < now.getYear()){
                      break;
                 }
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng(dd/MM/yyyy)");
                System.out.printf("\tNhập bắt đầu cv: ");
            }
        }
        System.out.printf("\tNhập ngày kết thúc cv:");
        while(true){
            try {
               String d = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 this.endDate = sdf.parse(d);
                 Date now = new Date(System.currentTimeMillis());
                 if(endDate.getYear() <= now.getYear()){
                      break;
                 }
            } catch (Exception e) {
                System.err.println("\tNhập sai định dạng(dd/MM/yyyy)");
                System.out.printf("\tNhập ngày kết thúc cv : ");
            }
        }
        System.out.printf("\tNhập tổng chi phí:");
        totalCost= sc.nextDouble();
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append((String.format(this.workId)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.workName)));
        builder.append("\t|");
        builder.append((String.format("%10s",this.getStartDateString())));
        builder.append("\t|");
        builder.append((String.format("%10s",this.getEndDateString())));
        builder.append("\t|");
        builder.append((String.format("%10s", this.totalCost)));
        
        System.out.print(builder.toString());
    }
    @Override
    public double calcualteCostPerDay() {
        long time1= startDate.getTime();
        long time2= endDate.getTime();
        double ngayTH = ((time2-time1)/(24*60*60*1000));
        return totalCost/ngayTH;
    }
     public double ngayTH() {
        long time1= startDate.getTime();
        long time2= endDate.getTime();
        double ngayTH = ((time2-time1)/(24*60*60*1000));
        return ngayTH;
    }
    

}
