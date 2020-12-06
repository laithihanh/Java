/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap_12.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import lap_12.work.Work;

/**
 *
 * @author USER
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

    
    public WorkOfBank(String PhongBanThucHien, int SoNhanVienThucHien, String CapDuyet, String workId, String workName, LocalDate startDate, LocalDate endDate, Double totalCost) {
        super(workId, workName, startDate, endDate, totalCost);
        this.PhongBanThucHien = PhongBanThucHien;
        this.SoNhanVienThucHien = SoNhanVienThucHien;
        this.CapDuyet = CapDuyet;
    }
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập phòng ban thực hiện:");
        PhongBanThucHien = sc.nextLine();
        while (true) {
            if(PhongBanThucHien.length()> 0  )
                break;
            else
                System.err.printf("\tPhòng ban không được để trống\n");
                System.out.printf("\tNhập lại:");
                PhongBanThucHien = sc.nextLine(); 
        }
        
        while (true) {
            try {
               System.out.printf("\tNhập số nhân viên thực hiện:");
                SoNhanVienThucHien = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số");
                  sc.nextLine();
            }
        }

        System.out.printf("\tNhập cấp duyệt:");
        sc.nextLine();
        CapDuyet= sc.nextLine();
        while (true) {
            if(CapDuyet.length()> 0)
                break;
            else
                System.err.printf("\tCấp duyệt không được để trống\n");
                System.out.printf("\tNhập lại:");
                CapDuyet = sc.nextLine(); 
        }

         
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
}


