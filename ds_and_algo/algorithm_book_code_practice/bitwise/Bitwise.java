public class Bitwise {

    public void and() {
        int x = 0b0000_0001;
        int y = 0b0000_0010;
        System.out.println("Result: " + Integer.toBinaryString(x) + " & " + Integer.toBinaryString(y) + " = " + Integer.toBinaryString(x & y));
    }

    public void or() {
        int x = 0b0000_0001;
        int y = 0b0000_0010;
        System.out.println("Result: " + Integer.toBinaryString(x) + " | " + Integer.toBinaryString(y) + " = " + Integer.toBinaryString(x | y));
    }

    public void xor() {
        int x = 0b0000_0011;
        int y = 0b0000_0111;
        System.out.println("Result: " + Integer.toBinaryString(x) + " ^ " + Integer.toBinaryString(y) + " = " + Integer.toBinaryString(x ^ y));
    }

    public void unary() {
       int x = 0b0000_0001;
       System.out.println("Result: " + " ~ " + Integer.toBinaryString(x) + " = " + Integer.toBinaryString(~x) + "\n");
    }

    public void twosComplimentDemo() {
       int x = 0b0000_0000_0000_0000_0000_0000_0001_0000; //16
       int x_compliment = ~ x;
       int y = x_compliment + 1;
       System.out.println("x:                " + Integer.toBinaryString(x) + " = " + x);
       System.out.println("x's complement:   " + Integer.toBinaryString(x_compliment));
       System.out.println("x_compliment + 1: " + Integer.toBinaryString(y) + " = " + y);
       System.out.println("\n");
    }

    public int add(int x, int y) {
        while (y != 0) {
            // first we find carries, all posistions where x and y has its bits set.
            int carry = (x & y);
            System.out.println("carry :" + Integer.toBinaryString(carry) + " = " + carry);
            // addition of the digits, ignoring the carry, and store it in x.
            x = x ^ y;
            System.out.println("x :" + Integer.toBinaryString(x) + " = " + x);
            // shifts the carry to the next digit position.
            y = carry << 1;
            System.out.println("y :" + Integer.toBinaryString(y) + " = " + y);
            System.out.println("\n");
        }
        return x;
    }

    public int addUsingJustXor(int x) {
        int total = 0;
        int i = 0;
        while (i <= x) {
            System.out.println("total :" + Integer.toBinaryString(total) + " ^ "+ Integer.toBinaryString(i)+" = " + (total ^ i));
            total = total ^ i;
            i++;
        }
        return total;
    }

    public static void main(String [] args) {
        Bitwise bitwise = new Bitwise();
        bitwise.and();
        bitwise.or();
        bitwise.xor();
        bitwise.unary();

        bitwise.twosComplimentDemo();

        int res = bitwise.add(6, 7);
        System.out.println(res);

        bitwise.addUsingJustXor(10);
        
    }
    
}