import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class MultiplyTwoInteger {

    /**
     * Write a progam that takes two arrays representing integers,
     * and returns and integer representing their product.
     */

    public static List<Integer> multiplyInteger(List<Integer> a, List<Integer> b) {
        int lenA = a.size();
        int lenB = b.size();

        int sign = getResultSign(a.get(0), b.get(0));
        System.out.println("sign is : "+ sign);

        // make numbers sign agnostic 
        a.set(0, Math.abs(a.get(0)));
        b.set(0, Math.abs(b.get(0)));


        // the result maximum lenght could be lenA + lenB
        List<Integer> result = new ArrayList<>(Collections.nCopies(lenA + lenB, 0));

        for (int i = lenA - 1; i >= 0; --i) {
            for (int j = lenB - 1; j >= 0; --j) {

                int resAtIPlusJPlusOne = result.get(i + j + 1) + (a.get(i) * b.get(j));
                result.set(i + j + 1, resAtIPlusJPlusOne);
                
                int resAtIPlusJ = result.get(i + j) + (result.get(i + j + 1) / 10);
                result.set(i + j, resAtIPlusJ);

                result.set(i + j + 1, resAtIPlusJPlusOne % 10);
            }
            System.out.println("intermediate results : "+ result);
        }

        int firstNonZeroIndex  = leadingNonZeroIndex(result);
        System.out.println("firstNonZeroIndex : "+ firstNonZeroIndex);
        result = result.subList(firstNonZeroIndex, result.size());
        result.set(0, result.get(0) * sign);
        
        return result;
    }

    private static int getResultSign(int x, int y) {
        // the sign bit is 1 in negative numbers
        // the sign bit is 0 in positive numbers
        int sign = x < 0 ^ y < 0 ? -1 : 1;
        return sign;
    }

    private static int leadingNonZeroIndex(List<Integer> list) {
       int firstNonZeroIndex = 0;
       while (firstNonZeroIndex < list.size() && list.get(firstNonZeroIndex) == 0) {
           ++firstNonZeroIndex;
       }
       return firstNonZeroIndex;
    }

    public static void main(String [] args) {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(2, 5, 6);
        List<Integer> result = multiplyInteger(a, b);
        print(result);
    }

    public static void print(List<Integer> list) {
        list.forEach(System.out::print);
    }
}