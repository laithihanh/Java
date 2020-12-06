/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_12.work;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Work implements IWork,Comparable<Work>{
    private String workId; //Mã công việc (workId : String)
    private String workName; //Tên công việc (workName: String)
    private LocalDate startDate; //Ngày bắt đầu (startDate: Datetime)
    private LocalDate endDate; //Ngày kết thúc (endDate: Datetime)
    private Double totalCost; //Tổng chi phí (totalCost: Double)

    public Work() {
    }

    public Work(String workId, String workName, LocalDate startDate, LocalDate endDate, Double totalCost) {
        this.workId = workId;
        this.workName = workName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập mã công việc:");
        workId = sc.nextLine();
        while (workId.length() < 3) {
            System.err.printf("\tMã công việc phải từ 3 ký tự\n");
            System.out.printf("\tNhập mã cv:");
            workId = sc.nextLine(); 
        }
        System.out.printf("\tNhập tên công việc:");
        workName = sc.nextLine();
        while (true) {
            if(workName.length() > 0)
                break;
            else
                System.err.printf("\tTên công việc không được để trống\n");
                System.out.printf("\tNhập lại:");
                workName = sc.nextLine(); 
        }
        System.out.printf("\tNhập ngày bắt đầu:");
            startDate= string2LocalDate(sc);
        System.out.printf("\tNhập ngày kết thúc:");
            endDate= string2LocalDate(sc);
         while (true) {
            try {
               System.out.printf("\tNhập tổng chi phí:");
               totalCost= sc.nextDouble();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số thực:");
                  sc.nextLine();
            }
        }
    }
    public LocalDate string2LocalDate( Scanner sc){
        LocalDate ld = null;
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(sc.nextLine(),dateTimeFormatter);
        }catch(DateTimeParseException e){
               System.err.println("\tNgày sinh không hợp lệ (dd/MM/yyyy)");
               System.out.printf("\tNhập lại :");
               sc.nextLine();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return ld;
    }
    @Override
    public void display() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder builder = new StringBuilder();
        builder.append((String.format(this.workId)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.workName)));
        builder.append("\t|");
        builder.append((String.format("%10s",startDate.format(dtf))));
        builder.append("\t|");
        builder.append((String.format("%10s",endDate.format(dtf))));
        builder.append("\t|");
        builder.append((String.format("%15s", this.totalCost)));
         builder.append("\t|");
        builder.append((String.format("%10s", this.NgayThucHien())));
        
        System.out.print(builder.toString());
    }

    @Override
    public double calcualteCostPerDay() {
       return totalCost/NgayThucHien();
    }

    @Override
    public int compareTo(Work o) {
         return this.getWorkName().compareTo(o.getWorkName());
    }
    public int NgayThucHien() {
         Period days = Period.between(startDate, endDate);
         int y,m,d;
         y= days.getYears();
         m = days.getMonths();
         d= days.getYears();
           return (y*365)+(m*12)+d;
           
    }
    
}
