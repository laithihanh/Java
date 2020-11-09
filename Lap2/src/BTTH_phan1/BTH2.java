/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_phan1;

import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author ADMIN
 */
public class BTH2 {
    public static void main(String[] args) {
        int count[] = {34,22,10,60,30,22};
        System.out.println("Original Array: " + Arrays.toString(count));
        
        TreeSet sortedSet = new TreeSet<Integer>();
        for (int i = 0; i < 5; i++) {
        sortedSet.add(count[i]);
        }
        System.out.println("The sorted list is:");
        System.out.println(sortedSet);
        System.out.println("The First element of the set is: " + (Integer) sortedSet.first());
        System.out.println("The last element of the set is: " + (Integer) sortedSet.last());
    }
}
