/**
 * The partiy of a binary word is 1 if the number of 1s in the word is odd; otherwise it is 0.
 * Ex :
 *      1011 -> 1
 *      10001000 -> 0
 */

public class Parity {

    // brute force approch
    private static int compute_bf_mine(long word) {
        int count = 0;
        long bit = 0;
        while (word != 0) {
            bit = word & 1;
            if (bit == 1) {
                count++;
            }
            word >>>= 1;
        }
        if (count % 2 != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // this is an improved version of the brute froce approch
    // the improvmenets are as follows.
    // 1. it uses less memoery by not using varibale to hold the result of each bit.

    // Time complexity : O(n) where n = number digits in the word.
    private static int compute_bf_improved(long word) {
        int count = 0;
        while (word != 0) {
            // here the result of (word & 1) results 1 if word is odd, results 0 if word is even.
            // doing XOR on that results act as a mathmatical addition without carry, which means is act as % 2
            count ^= (word & 1);
            word >>>= 1;
        }
        return count;
    }
    
    /**
     * This is an improvment of above using a bitwise machanism to clear the lowest set bit [ x & (x-1) ]
     * Henec number of iterations get reduced to number of set bits.
     *
     * Time complexity : O(k) where k = number of set bits in the word.
     */
    private static short compute_using_lowest_set_bit(long x) {
        short count = 0;
        while (x != 0) {
            count ^= 1;
            // every iteration clear the lowest set bit, until there are no more
            x &= (x-1);
        }
        return count;
    }

    // this arry act as the 16-bit number Parity look up table 
    static int [] preComputedParity = new int [65536];

    /**
     * This method use the divide and concure approch to solve the problem.
     * By using following 
     * 1. It use the pre calculated 16-bit Parities to calculate the 64-bit Parity.
     * 2. It use the associativity of XOR in to use to achive above.
     *
     * Time Complexity :  Let  l be the width of the word we cache [here  l = 16]
     *                    Let  n be the with of the word we compute the Parity [here n = 64]
     * hence time complexity =  O (n / l) where and n > l > 0
     */
    private static int compute_using_divide_and_concure(long x) {

       final int MASK_SIZE = 16;
       final int BIT_MASK = 0xFFFF; // mask all bits but last 16 bits

       int result = (int) ( 
                preComputedParity[(int) (x >>> (3 * MASK_SIZE)) & BIT_MASK ] ^
                preComputedParity[(int) (x >>> (2 * MASK_SIZE)) & BIT_MASK ] ^
                preComputedParity[(int) (x >>> (MASK_SIZE)) & BIT_MASK ] ^
                preComputedParity[(int) x & BIT_MASK] );
        return result;
    }

    /**
     * This method use the XOR properties
     * associativity : It does not matter how we group the bits
     * commutative : The order we performe the XOR does not change the result
     *
     */
    private static int compute_using_xor_properties(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        // get the least significent bit
        return (int) x & 1;
    }

    /**
     * This method populates the preComputedParity arry which act as the look up table.
     */
    private static void buildParityTable() {
         // first we build an array which hold the parity of 16-bit word.
        int i = 0;
        while (i < 65536) {
            preComputedParity[i] = compute_using_lowest_set_bit(i);
            i++;
        }
        System.out.println("16 bit parity table build finished.");
    }

    public static void main(String [] args) {
        Timer timer = new Timer();
        long x = Long.MAX_VALUE;
        timer.start();
        int count = compute_bf_mine(x);
        timer.stop();
        System.out.println("Parity of " + x + ": " + count + " time taken in nano seconds:" + timer.getTotalTime());

        timer.clear();
        timer.start();
        count = compute_bf_improved(x);
        timer.stop();
        System.out.println("Parity of " + x + ": " + count + " time taken in nano seconds:" + timer.getTotalTime());

        timer.clear();
        timer.start();
        count = compute_using_lowest_set_bit(x);
        timer.stop();
        System.out.println("Parity of " + x + ": " + count + " time taken in nano seconds:" + timer.getTotalTime());

        buildParityTable();
        timer.clear();
        timer.start();
        count = compute_using_divide_and_concure(x);
        timer.stop();
        System.out.println("Parity of " + x + ": " + count + " time taken in nano seconds:" + timer.getTotalTime());

        timer.clear();
        timer.start();
        count = compute_using_xor_properties(x);
        timer.stop();
        System.out.println("Parity of " + x + ": " + count + " time taken in nano seconds:" + timer.getTotalTime());
    }
}