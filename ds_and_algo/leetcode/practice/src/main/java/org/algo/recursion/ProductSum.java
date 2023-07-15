package org.algo.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSum {


    // Write a funation that takes in a special array and return its product sum

    // A special array is anon-empty array that contains integers or ether special arrays
    //The product sum of a special array is the sum of its elements, where special array inside it are summed themselves and the multiplied
    // by their level of depth
    // // [5, 2, [7, -1], 3, [6, [-13, 8], 4]] => 12  // 5 + 2 + 2 * ( 7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)

    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSum(array, 1);
    }

    //[5, 2, [7, -1], 3, [6, [-13, 8], 4]]
    private static int productSum(List<Object> array, int mul) {
        int sum = 0;
        for (Object element : array) {
            if (element instanceof ArrayList) {
                sum += productSum((ArrayList<Object>)element, mul + 1);
            }
            else {
                sum += (int) element;
            }
        }
        System.out.println("sum at level " + mul + " = " + sum);
        return sum * mul;
    }

    public static void main(String[] args) {
        ArrayList<Object> l1 = new ArrayList<>();
        l1.addAll(List.of(7, -1));

        ArrayList<Object> l2 = new ArrayList<>();
        ArrayList<Object> l3 = new ArrayList<>();
        l3.addAll(List.of(-13, 8));
        l2.addAll(List.of(6, l3, 4));


        List <Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(l1);
        list.add(3);
        list.add(l2);

        System.out.println(productSum(list));
    }
}
