
/**
    Space and Time Complexity

     push()
        C1 time for the intesrting the arraye item 
        Only when array resize happen , the operation cost C * N

     pop()
        C2 time for the returning the arraye item 
         Only when array resize happen , the operation cost C * N

     isEmpty()
        C4 constant time.

     Space
        8 bytes to reference of the array
        24 bytes array overhead
        8 bytes * array size  
        4 bytes int 
        4 bytes padding
        --
        48 byes 
 */
public class ArrayResizedStack {

    String [] stack;
    int N = 0;

    public ArrayResizedStack() {
        stack = new String [10];
    }

    public void push(String item) {
        if (N == stack.length) {
            resize(2 * N);
        }
        stack[N++] = item;
    }

    public String pop() {
        String item  = stack[--N];
        stack[N] = null;
        // this is the optimal way to shrink the stack size
        if (N > 0 && N == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // we call this doubling resize.
    private void resize(int size) {
        String [] newStack = new String [size];
        for (int i = 0; i < N; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public int size() {
        return N;
    }

    public String toString() {
        String result = "";
        for (String s : stack) {
             result += " " + s;
        }
        return result;
    }

 

    public static void main(String [] args) {

        ArrayResizedStack arrayStack = new ArrayResizedStack();
        
        System.out.println("isEmpty :" + arrayStack.isEmpty());
        arrayStack.push("Hello");
        arrayStack.push("It's me");
        arrayStack.push("I");
        arrayStack.push("was wondering");
        arrayStack.push("If");
        arrayStack.push("After all");
        arrayStack.push("these years");
        arrayStack.push("you");
        arrayStack.push("would like to");
        arrayStack.push("meet");
        System.out.println("stack length :" + arrayStack.stack.length);
        System.out.println("size :" + arrayStack.size());
        
        arrayStack.push("you..");
        System.out.println("stack length :" + arrayStack.stack.length);
       // System.out.println(arrayStack.toString());

        while (arrayStack.size() >= 5) {
            System.out.println(arrayStack.pop());
           // System.out.println("size :" + arrayStack.size());
        }
        System.out.println("stack length :" + arrayStack.stack.length);

       // System.out.println(arrayStack.toString());
    }
}