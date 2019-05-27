/**
 *  Develop a method to take 64-bit integer and indices i and j
 *  return swap the the bits at i and j.
 *  if i  = 6 , j = 1
 *  7 6 543210    765432 1 0
 *  0 1 001001 -> 000010 1 1
 */
public class SwapBits {

    // find two bits
    // check whather we need a swap ie : if bits are different we need to swap

    // if we need a swap then there are two cases
    // i  j
    // 0  1 ; set i, unset j
    // 1  0 ; unset 1, set j

    private static int swapBits_bf_mine(int x, int i, int j) {
        int iBit = ((x & (1 << i)) == 0) ? 0 : 1;
        int jBit = ((x & (1 << j)) == 0) ? 0 : 1;

        if ((iBit ^ jBit) == 1) {
            if (iBit == 0) {
                x = x | (1 << i);
            } else if (iBit == 1) {
                x = x & ~(1 << i);
            }

            if (jBit == 0) {
                x = x | (1 << j);
            } else if (jBit == 1) {
                x = x & ~(1 << j);
            }
        }
        return x;
    }

    private static int swapBits_improved(int x, int i, int j) {
        // we only case about the scnario where ith and jth bits are diffrent.
        if ( (x & (1 << i)) != (x & (1 << j)) ) {
            // create a bit mask with i and j 
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }


    public static void main(String [] args) {
        Timer timer = new Timer();

        int x = 75;
        int i = 2;
        int j = 5;

        timer.start();
        int y = swapBits_bf_mine(x, i, j);
        timer.stop();
        System.out.println("Results of swap bits for x = " + x + ", i = " + i + ", j = " + j + "  : " +
         Integer.toBinaryString(y) + " time taken in nano seconds:" + timer.getTotalTime());

        System.out.println("\n");

        timer.clear();
        timer.start();
        y = swapBits_improved(x, i, j);
        timer.stop();
        System.out.println("Results of swap bits for x = " + x + ", i = " + i + ", j = " + j + "  : " +
         Integer.toBinaryString(y) + " time taken in nano seconds:" + timer.getTotalTime());
    }
}