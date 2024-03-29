package org.algo.bitwise;

public class BitShiftExample {

    private void shiftLeft(int x, int shift) {
        int y = x << shift;
        System.out.println("Result: " + Integer.toBinaryString(x) + " << "+ shift + " = " + Integer.toBinaryString(y) + " = " + y);
    }

    private void shiftRight_Singed(int x, int shift) {
        int y = x >> shift;
        System.out.println("Result: " + Integer.toBinaryString(x) + " >> "+ shift + " = " + Integer.toBinaryString(y) + " = " + y);
    }

    private void shiftRight_Unsigned(int x, int shift) {
        int y = x >>> shift;
        System.out.println("Result: " + Integer.toBinaryString(x) + " >>> "+ shift + " =    " + Integer.toBinaryString(y) + " = " + y);
    }


    public static void main(String [] args) {
        BitShiftExample bs = new BitShiftExample();
        int x = 3; // 0011
        bs.shiftLeft(x, 2);

        // this demonstrate Java's singed right shit behaviour, where
        // a binary number starts with 1 will right shift in the value of the sign.
        x = 0xFFFFFFF0; // 0b1111_1111_1111_1111_1111_1111_1111_0000
        System.out.println(x);
        bs.shiftRight_Singed(x, 4);

        bs.shiftRight_Unsigned(x, 4);

        System.out.println((8 - 1) & 8);
    }
}
