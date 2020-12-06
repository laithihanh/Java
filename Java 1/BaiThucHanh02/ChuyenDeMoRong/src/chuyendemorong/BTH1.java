/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuyendemorong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BTH1 {
    List<Employee> lstBkap = new ArrayList<>();
    
    class Employee{
        String name;
        int age;
    }
    private void sortEmp(){
        //Old case(Trường hợp cũ)
        Comparator<Employee> oldCase = new Comparator<Employee>(){
          @Override
          public int compare(Employee o1, Employee o2){
              return o1.name.compareTo(o2.name);
          }
        };
        //lambda
        //Viết tường minh có đầy đủ kiểu dữ liệu đối số và từ khóa return
        Comparator<Employee> lambdaCase = (Employee emp1, Employee emp2)->
        {
            return emp1.name.compareTo(emp2.name);
        };
        //Viết Lambda khai báo tường minh có return
        Comparator<Employee> lambdaCase2 = (emp1,emp2)->
        {
            return emp1.age > emp2.age ? 1:-1;
        };
        // Viết Labda lược bớt kiểu dữ liệu và return
        Comparator<Employee> lambdaCase3 = (o1, o2) ->
        o1.name.compareTo(o2.name);
        lstBkap.sort(lambdaCase3);
    }
    
    interface Caculate{
        int operator(int a,int b);
    }
    
    void sieuMayTinh(){
        Caculate tong = (a,b)->a+b;
        Caculate tru = (a,b)->a-b;
        System.out.println("Tổng: "+tong.operator(1,2));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       BTH1 main = new BTH1();
       main.sieuMayTinh();
    }
    
}
