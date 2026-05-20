package leetcode.repeat;

import java.util.Stack;

public class MinStack {
    Stack<Integer> val_stack;
    Stack<Integer> min_stack;

    public MinStack() {
        val_stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        val_stack.push(val);
        if (min_stack.isEmpty() || min_stack.peek() > val)
            min_stack.push(val);
    }

    public void pop() {
        if (val_stack.isEmpty())
            throw new RuntimeException("stack is empty");
        if (min_stack.peek() == val_stack.peek())
            min_stack.pop();
        val_stack.pop();
    }

    public int top() {
        return val_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
