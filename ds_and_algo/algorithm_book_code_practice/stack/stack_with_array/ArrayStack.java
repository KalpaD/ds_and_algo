public class ArrayStack {

    String [] stack;
    int N = 0;
    int capacity = 0;

    // Asking clinet to provide the capacity is not ideal
    // In most cases clients have not idea how much cpacity they need.
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new String [capacity];
    }

    public void push(String item) {
        // note that the for push we use the N and then increment it
        // otherwise we will never be eable to populate 0th position.
        stack[N++] = item;
    }

    public String pop() {
        // Note that for pop we decrement N forst and then use it.
        // otherwise will will recive Nth item not N-1th item

        // there is another phonemena call "Loitering"
        // where the we still keep the a array pointer which we no longer use for 
        // stack operations, hence we need to let Java know that it should it no longer in use.
        // for that we can use following improvement.

        // String item  = stack[--N]
        // stack[N] = null;
        // return item;
        return stack[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == capacity;
    }

    public String toString() {
        String result = "";
        for (String s : stack) {
             result += " " + s;
        }
        return result;
    }

    public static void main(String [] args) {

        ArrayStack arrayStack = new ArrayStack(10);
        
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
        System.out.println("isFull :" + arrayStack.isFull());
        
        System.out.println(arrayStack.toString());

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

        System.out.println(arrayStack.toString());
    }
}