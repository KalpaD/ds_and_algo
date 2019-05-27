/**
 * Please note that in this class bit numeration starts with 0, so it is 0th bit, 1st bit, ... 7th bit.
 */
public class BitOps {

    /**
     * Note : set bit mean a bit which hold value '1'.
     * Hence, this method prints the right most set bits position.
     *
     * The algorithm is as follows.
     * 1. Take two's complement of a given number, as it will have all bits are reverted except the first set bit.
     * 2. Do and bitwise AND with original number, this will allow the orginal number to act as bit mask.
     * 3. Take the log2() of the number, this will return the x such that  2 ^(x) = n
     * 4. But for binary number 2 ^(x) starts from 0, hence the numberf from step 3 is 0 based, hence adding one here to get the correct position.
     */
    private void printRightmostSetBitPos(int n) {
        System.out.println("n :      " + Integer.toBinaryString(n));
        int n_comp = -n;
        System.out.println("n_comp : " + Integer.toBinaryString(n_comp));
        int band = n & n_comp;
        System.out.println("band :   " + Integer.toBinaryString(band));

        int log2 = (int)(Math.log10(band) / Math.log10(2));
        System.out.println("log2 :   " + log2);
    }

    /**
     * The algorithm is as follows.
     * 1. We know that n & ~n =0 , we add 1 to the number it will make mosrt unset bit to 1., If there are any set bits in the right of unset bit those
     * bits in the right side of unset bit, those bis will become zero.
     * 2. If we take one's complement of the original number it will make the right most unset bit to 1.
     * 3. Now ~n & (n+1) will make all the bits 0 but the right most unset bit of the number.
     */
    private void printRightMostUnsetBitPos(int n) {
        System.out.println("n :      " + Integer.toBinaryString(n));
        int n_comp = ~n;
        System.out.println("n_comp : " + Integer.toBinaryString(n_comp));
        int n_plus_one = n + 1;
        System.out.println("n+1 :    " + Integer.toBinaryString(n_plus_one));
        int band = n_comp & n_plus_one;
        System.out.println("band :   " + Integer.toBinaryString(band));
        int log2 = (int)(Math.log10(band) / Math.log10(2));
        System.out.println("log2 :   " + log2);
    }

    /**
     * This method check the given integer even or odd by doing a bitwise AND operation with 1.
     * The rational is to check wheather the least significant bit is 1, or 0.
     * if it is 1 then the number is odd, if it o then the number if 0.
     */
    private boolean isEven(int x) {
        return (x & 1) == 0;
    }

    /** 
     * This methos check the given integer's nth bit and return true if is set.
     * The rational is to left shift 1 up until nth position and use that as a bit mask for the
     * number n's nth position to see whather it is set or not.
     */
    private boolean isBitSet(int x, int n) {
        System.out.println("x :      " + Integer.toBinaryString(x));
        System.out.println("r :      " + Integer.toBinaryString(x & (1 << (n))) );
        return (x & (1 << (n))) != 0;
    }

    /**
     * Set nth bit of a given integer.
     */
    private void setBit(int x, int n) {
        int y = x | (1 << n );
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("\n");
    }

    /**
     * Unset nth bit of a given integer.
     */
    private void unSetBit(int x, int n) {
        int y = x & ~(1 << n);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("\n");
    }

    /**
     * Togglenth bit of a given integer.
     */
    private void toggleBit(int x, int n) {
        int y = x ^ (1 << n);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("\n");
    }

    private void trunOffRightmostSetBit(int x) {
        int y = x & (x-1);
        System.out.println("x :       " + Integer.toBinaryString(x));
        System.out.println("x-1 :     " + Integer.toBinaryString(x-1));
        System.out.println("x & (x-1) " + Integer.toBinaryString(y));
        System.out.println("\n");
    }

    private void turnOnRightmostUnSetBit(int x) {
        int y = x | (x +1);
        System.out.println("x :       " + Integer.toBinaryString(x));
        System.out.println("x+1 :     " + Integer.toBinaryString(x+1));
        System.out.println("x | (x+1) " + Integer.toBinaryString(y));
        System.out.println("\n");
    }

    private void isolateRightmostSetBit(int x) {
        int y = x & (-x);
        System.out.println("x :       " + Integer.toBinaryString(x));
        System.out.println("-x :     " + Integer.toBinaryString(-x));
        System.out.println("x & (-x) " + Integer.toBinaryString(y));
        System.out.println("\n");
    }

    public static void main(String [] args) {
        BitOps bops = new BitOps();
        int x = 18;
        bops.printRightmostSetBitPos(x);
        x = 15;
        bops.printRightMostUnsetBitPos(x);

        System.out.println("Is : " + x + " even ? " + bops.isEven(x));
        x = 7;
        int n = 2;
        System.out.println("Is : " + x + "'s "+ n +"th bit set ? " + bops.isBitSet(x, n));

        n = 3;
        bops.setBit(x, n);

        bops.setBit(x, n);
        x = 83;
        bops.trunOffRightmostSetBit(x);
        x = 16;
        bops.trunOffRightmostSetBit(x);

        bops.turnOnRightmostUnSetBit(x);
        x = 11;
        bops.isolateRightmostSetBit(x);
    } 
}