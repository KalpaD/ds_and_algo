package org.kalpads.dsalgo.stack;

/**
 * Created by kalpasenanayake on 6/6/17.
 */
public class Stack<T> {

    private int maxSize;
    private T [] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = (T[]) new Object[this.maxSize];
        this.top = -1; // initialize the top variable to
                       // -1 so that first item's top will be 0.
    }

    public void push(T input) throws StackFullException {
        if(isFull()) {
           throw new StackFullException();
        } else {
            top++; // increment the top
            stackArray[top] = input; // assign new value to top location.
        }
    }

    public T pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            int old_top = top; // hold the old top so that we can return the removed value.
            top--;
            return stackArray[old_top];
        }
    }

    public T peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (maxSize - 1 == top);
    }
}
