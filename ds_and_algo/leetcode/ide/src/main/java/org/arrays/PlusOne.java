package org.arrays;


public class PlusOne {

    /**
     * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
     *
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
     *
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int forNext = 0;
        for (int index = digits.length - 1; index > -1; index --) {

            if (index == digits.length - 1) {
                int plusOne = 1 + digits[index];
                int remaining = plusOne % 10;
                if (remaining == 0) {
                    forNext ++;
                    digits[index] = remaining;
                } else {
                    digits[index] = plusOne;
                }
            } else {
                int temp = forNext > 0 ? forNext-- : 0;
                int neVal = temp + digits[index];
                int remaining = neVal % 10;
                if (neVal != 0 && remaining == 0) {
                    forNext ++;
                    digits[index] = 0;
                } else {
                    digits[index] = neVal;
                }
            }
        }

        if (forNext > 0) {
            // something left
            int [] resizedArray = new int [digits.length + 1];
            for (int j = 1; j < resizedArray.length; j++) {
                resizedArray[j] = digits[j-1];
            }
            resizedArray[0] = forNext;
            return resizedArray;
        }
        return digits;
    }


    public static void main(String[] args) {
        int [] digits = {1, 0, 0, 0, 0};
        int[] plusOneNum = plusOne(digits);
        for (int i = 0; i < plusOneNum.length; i++) {
            System.out.print(plusOneNum[i]);
        }
    }
}
