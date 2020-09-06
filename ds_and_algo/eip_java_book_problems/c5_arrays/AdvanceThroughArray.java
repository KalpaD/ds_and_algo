import java.util.Arrays;
import java.util.List;

public class AdvanceThroughArray {

    /**
     * Write a program which takes an array of n integers, where A[i] denotes maximum
     * you can advace from index i, and returns whether it is possible to the last index 
     * starting from the begining of the array.
     */

     private static boolean isWinnable(List<Integer> gamePath) {
        int lastIndex = gamePath.size() - 1;
        int furthestDistanceSoFar = 0;

        for (int i = 0; i < gamePath.size(); i++) {
            furthestDistanceSoFar = Math.max(furthestDistanceSoFar, i + gamePath.get(i));
            System.out.print(furthestDistanceSoFar); 
        }

        System.out.println("");
        return furthestDistanceSoFar >= lastIndex;
     }

     public static void main(String [] args) {
        List<Integer> gamePath1 = Arrays.asList(3, 3, 1, 0, 2, 0, 1);
        List<Integer> gamePath2 = Arrays.asList(3, 2, 0, 0, 2, 0, 1);
        boolean result1 = isWinnable(gamePath1);
        boolean result2 = isWinnable(gamePath2);
        System.out.println("result of gamePath1 :" + result1);
        System.out.println("result of gamePath2 :" + result2);
     }
}