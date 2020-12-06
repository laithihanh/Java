/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuyendemorong;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class DemoFunctionInterface {
    void evaluation(float number, Predicate<Float>pre){
        // Sử dụng Predicate kiểm tra điều kiện quy ước có phù hợp không
        // "điều kiện quy ước" có thể tùy biến ở biểu thức lambda
        
        if(pre.test(number)){
            System.out.println("#"+number);
        }else{
            System.out.println("Wrong number");
        }
    }
    
    static void printValue(String test){
        System.out.println(test);
    }
    
    public static void main(String[]args){
        DemoFunctionInterface main = new DemoFunctionInterface();
        
        // Demo 1: Predicate
        Predicate<Float>p = (preNum)->{
            return preNum > 2.7F;
        };
        main.evaluation(3.14f, p);
        main.evaluation(0.69f, p);
        
        // Demo 2: BinaryOperator
        BinaryOperator<Integer> boTong = (b1,b2)->b1+b2;
        BinaryOperator<Integer> boTru = (b1,b2)->b1-b2;
        
        System.out.println("Tổng:" +boTong.apply(5, 3));
        System.out.println("Tổng:" +boTru.apply(5, 3));
        System.out.println("-------------------------");
        
        // Demo 3: IntConsumer
        IntConsumer intC = (value)->{
            System.out.println("#"+value);
        };
        IntConsumer intC2 = (value)->System.out.println("2#" +value);
        IntConsumer intC3 = (a)->System.out.println("Square =" +a*a);
        intC.accept(5);
        intC2.accept(3);
        intC3.andThen(intC2).accept(6);
        
        //tham chiếu phương thức và toán tử:
        
        System.out.println("Method reference - double colon");
        DoubleConsumer douC = System.out::println;//Loại Instance method
        douC.accept(3.14);
        // Sử dụng toán tử :: (double colon) viết tắt code
        Consumer<String> con = DemoFunctionInterface::printValue; // Loại Static method
       con.accept("Kiss more & more");
       // Giải thích đoạn code bằng biểu thức lambda
        // Consumer<String> con = (str) -> {
        // main.printValue(str);
        // };
        // Viết lại đoạn code trên tường minh bằng cách tạo anonymous class
        // Consumer<String> con = new Consumer<String>() {
        // @Override
        // public void accept(String t) {
        // main.printValue(t);
        // }
        // };
        System.out.println("--------------------------");
        
        // Sử dụng trong List
        List<String> name = Arrays.asList("Nam", "Tùng", "Bách", "Thu", "Nga",
        "Hoàng");
        name.forEach(con);
            // Cách 1: viết bằng lambda
            // name.forEach((t) -> {
            // System.out.println("- " + t);
            // });
            // Cách 2: Viết kiểu Method reference
        name.forEach(System.out::println);
            // Khởi tạo Function Interface FUNCTION bằng method reference
            // gọi constructor (điều kiện là constructor có tham số)
        Function<String, Integer> f0 = (t) -> {
        return new Integer(t); // Lambda
        };
            // method reference
        Function<String, Integer> f01 = Integer::new;
            // Khởi tạo Function Interface FUNCTION bằng method reference
        Function<Integer, String> f = String::valueOf;
            // => Tường minh bằng biểu thức lambda
        Function<Integer, String> f1 = (t) -> {
            return String.valueOf(t); //To change body of generated lambdas, choose
        };
    }
    
}
