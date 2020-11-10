/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mark;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Mark implements IMark{
    private String fullName;
    private Boolean gender;
    private String className;
    public float markOfC;
    public float markOfHTML;
    public float markOfSQL ;
    public float markOfPHP;

    public Mark() {
    }

    public Mark(String fullName, Boolean gender, String className, float markOfC, float markOfHTML, float markOfSQL, float markOfPHP) {
        this.fullName = fullName;
        this.gender = gender;
        this.className = className;
        this.markOfC = markOfC;
        this.markOfHTML = markOfHTML;
        this.markOfSQL = markOfSQL;
        this.markOfPHP = markOfPHP;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMarkOfC() {
        return markOfC;
    }

    public void setMarkOfC(float markOfC) {
        this.markOfC = markOfC;
    }

    public float getMarkOfHTML() {
        return markOfHTML;
    }

    public void setMarkOfHTML(float markOfHTML) {
        this.markOfHTML = markOfHTML;
    }

    public float getMarkOfSQL() {
        return markOfSQL;
    }

    public void setMarkOfSQL(float markOfSQL) {
        this.markOfSQL = markOfSQL;
    }

    public float getMarkOfPHP() {
        return markOfPHP;
    }

    public void setMarkOfPHP(float markOfPHP) {
        this.markOfPHP = markOfPHP;
    }
    
    
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\tNhập tên: ");
        this.fullName = sc.nextLine();
        while (true) {
            if(this.fullName.length()>0 )
                break;
            else
                System.err.printf("\tTên không được để trống\n");
                System.out.printf("\tNhập lại:");
                this.fullName = sc.nextLine(); 
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
        System.out.printf("\tNhập tên lớp: ");
        this.className = sc.nextLine();
        while(this.className.length() < 3){
            System.err.printf("\tTên lớp không nhỏ hơn 3 ký tự\n");
            System.out.printf("\tNhập lại:");
            className = sc.nextLine(); 
        }

        while (true) {
            try {
                System.out.printf("\tNhập điểm môn C: ");
                this.markOfC = sc.nextFloat();
                while(this.markOfC >20){
                    System.err.printf("\tĐiểm không vượt quá 20\n");
                    System.out.printf("\tNhập lại:");
                    markOfC = sc.nextFloat(); 
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
        
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn HTML: ");
                this.markOfHTML = sc.nextFloat();
                while(this.markOfHTML >20){
                    System.err.printf("\tĐiểm không vượt quá 20\n");
                    System.out.printf("\tNhập lại:");
                    markOfHTML = sc.nextFloat(); 
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn SQL: ");
                this.markOfSQL = sc.nextFloat();
                while(this.markOfSQL > 20){
                    System.err.printf("\tĐiểm không vượt quá 20\n");
                    System.out.printf("\tNhập lại:");
                    markOfSQL = sc.nextFloat(); 
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
        while (true) {
            try {
                System.out.printf("\tNhập điểm môn PHP: ");
                this.markOfPHP = sc.nextFloat();
                while(this.markOfPHP > 20){
                    System.err.printf("\tĐiểm không vượt quá 20\n");
                    System.out.printf("\tNhập lại:");
                    markOfPHP = sc.nextFloat(); 
                }
                break;
            } catch (Exception ex) {
                System.err.println("\tYêu cầu nhập số:");
                  sc.nextLine();
            }
        }  
        
        
        
        
    }

    @Override
    public void display() {
       StringBuilder builder = new StringBuilder();
        builder.append(this.fullName);
        builder.append("\t|");
        builder.append(this.gender);
        builder.append("\t|");
        builder.append((String.format("%15s",this.className)));
        builder.append("\t|");
        builder.append((String.format("%5s",this.markOfC)));
        builder.append("\t|");
         builder.append( (String.format("%15s",this.markOfHTML)));
        builder.append("\t|");
        builder.append((String.format("%8s",this.markOfSQL)));
        builder.append("\t|");
        builder.append( (String.format("%10s",this.markOfPHP)));
        builder.append("\t|");
        System.out.print(builder.toString());
    }

    @Override
    public float averageMark() {
        return (markOfC+markOfHTML+markOfSQL+markOfPHP)/4;
    }
    
}
