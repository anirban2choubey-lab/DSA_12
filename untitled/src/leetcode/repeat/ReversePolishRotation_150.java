package leetcode.repeat;

import java.util.Stack;

public class ReversePolishRotation_150 {
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println("result::"+evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            switch (s) {

                case "+": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b + a);
                    continue;
                }
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    continue;
                }
                case "*": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b * a);
                    continue;
                }
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    continue;
                }
                default: {
                    stack.push(Integer.valueOf(s));
                }
            }
        }
        return stack.pop();
    }
}
