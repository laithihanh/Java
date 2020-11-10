/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic3;

/**
 *
 * @author USER
 */
public class Private_bai2 {
    private String printRank(float theory, float pracical) {
            if (theory < 40 && pracical < 40) {
                return "Thi lại môn Java";
            } else if (theory < 40 && pracical >= 40) {
                return "Thi lại lý thuyết môn Java";
            } else if (theory >= 40 && pracical < 40) {
                return "Thi lại thực hành môn Java";
            } else {
                return "Pass môn Java";
            }
        }
     public static void main(String[] args) {
        Bai2 xm = new Bai2();
        xm.studentInput();
        xm.studentInfo();
        
        Private_bai2 cd32 = new Private_bai2();
            System.out.println(cd32.printRank(xm.gettMark(), xm.getpMark()));
    }
}
