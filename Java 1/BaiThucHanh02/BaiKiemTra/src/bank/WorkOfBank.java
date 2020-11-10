/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import work.Work;

/**
 *
 * @author ADMIN
 */
public class WorkOfBank extends Work{
    private String PhongBanThucHien ;//Phòng ban thực hiện
    private int SoNhanVienThucHien; //Số nhân viên thực hiện
    private String CapDuyet; //- Cấp duyệt

    public WorkOfBank() {
    }

    public String getPhongBanThucHien() {
        return PhongBanThucHien;
    }

    public void setPhongBanThucHien(String PhongBanThucHien) {
        this.PhongBanThucHien = PhongBanThucHien;
    }

    public int getSoNhanVienThucHien() {
        return SoNhanVienThucHien;
    }

    public void setSoNhanVienThucHien(int SoNhanVienThucHien) {
        this.SoNhanVienThucHien = SoNhanVienThucHien;
    }

    public String getCapDuyet() {
        return CapDuyet;
    }

    public void setCapDuyet(String CapDuyet) {
        this.CapDuyet = CapDuyet;
    }

    public WorkOfBank(String PhongBanThucHien, int SoNhanVienThucHien, String CapDuyet, String workId, String workName, Date startDate, Date endDate, Double totalCost) {
        super(workId, workName, startDate, endDate, totalCost);
        this.PhongBanThucHien = PhongBanThucHien;
        this.SoNhanVienThucHien = SoNhanVienThucHien;
        this.CapDuyet = CapDuyet;
    }

    @Override
    public void display() {
        super.display();
        StringBuilder builder = new StringBuilder();
        builder.append((String.format("%20s",this.PhongBanThucHien)));
        builder.append("\t|");
        builder.append((String.format("%20s",this.SoNhanVienThucHien)));
        builder.append("\t|");
        builder.append((String.format("%25s",this.CapDuyet)) );

        System.out.println(builder.toString());
       
    }

    @Override
    public void input() {
        super.input(); 
         Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập phòng ban thực hiện:");
        PhongBanThucHien = sc.nextLine();
        
        System.out.printf("\tNhập số nhân viên thực hiện:");
        SoNhanVienThucHien = sc.nextInt();
        
        System.out.printf("\tNhập cấp duyệt:");
        sc.nextLine();
        CapDuyet= sc.nextLine();
        
    }
    
    
   
}
