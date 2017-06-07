package org.kalpads.dsalgo.stack;

/**
 * Created by kalpasenanayake on 6/6/17.
 */
public class StackTest {

    public static void main(String [] args) throws StackFullException, EmptyStackException {
        String s = reverseSpellings("Hello World!");
        System.out.println(s);
    }

    private static void stackTest() throws StackFullException, EmptyStackException {
        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        while (true) {
            long value = (long)stack.pop();
            System.out.println(value);
        }
    }


    private static String reverseSpellings(String word) throws StackFullException, EmptyStackException {
        char [] characters = word.toCharArray();
        Stack stack = new Stack(characters.length);
        for (Character c : characters) {
            stack.push(c);
        }
        char [] reverse = new char[characters.length];
        int index = 0;
        while (!stack.isEmpty()) {
            reverse[index] = (char) stack.pop();
            index++;
        }
        return new String(reverse);
    }
}
