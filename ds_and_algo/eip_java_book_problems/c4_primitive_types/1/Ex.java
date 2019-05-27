/**
 * This class is for the excersis recomanded in this chapter.
 * Each method corresponds to a particuler excersis. 
 */
public class Ex {

    /** 
     * This method right propagrate the right most set bit of the given integer.
     * Ex : 11010000  -> 11011111
     */
    private static int rightPropagateRightMostBit(int x) {
        //  11010000
        //| 11001111
        //  11011111
        int result = x | (x-1);
        return result;
    }

    /**
     * If a is power of 2, then it will only have once bit set in it's binary representation.
     * 16 = 10000
     *  8 = 1000
     *
     * hence decrimenting the devicer we can create a mask (16-1) = 01111
     * we can use this mask to get the remainder
     *  87 % 16  = 7
     *  
     *  1010111 & (01111) = 0111 = 7
     *
     *  Note that this will only work if the divicer is 2 ^(n)
     */
    private static int mod(int x, int a) {
        int result = x & (a-1);
        return result;
    }



    public static void main(String [] args) {
        int x  = 208;
        int result = 0;
        result = rightPropagateRightMostBit(x);
        System.out.println("Result of rightPropagateRightMostBit() when x = " + Integer.toBinaryString(x) + " : " + Integer.toBinaryString(result));

        x = 77;
        int a = 64;
        result = mod(x, a);
        System.out.println("Result of mod() when x = " + x + " and a = " + a + " : " + Integer.toBinaryString(result));

        x = 128;
        a = 64;
        result = mod(x, a);
        System.out.println("Result of mod() when x = " + x + " and a = " + a + " : " + Integer.toBinaryString(result));
    }

}