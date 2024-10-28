package telran.interview;

import java.util.*;

public class MyStackInt {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    public void push(int num) {        
        stack.push(num);
        if (maxStack.isEmpty() || num >= maxStack.peek()) {
            maxStack.push(num);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int top = stack.pop();
        if (top == maxStack.peek()) {
            maxStack.pop();
        }
        return top;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }        
        return stack.peek();
    }

    public boolean isEmpty() {        
        return stack.isEmpty();
    }

    public int getMaxElement() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }
}
