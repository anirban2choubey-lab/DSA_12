package leetcode;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] strings = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(strings));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            int first = 0, second = 0;

            String el = tokens[i];

            switch (el) {
                case "+": {
                    first = numbers.pop();
                    if (numbers.isEmpty())
                        return 0;
                    second = numbers.pop();
                    numbers.push(first + second);
                    break;
                }
                case "-": {
                    first = numbers.pop();
                    if (numbers.isEmpty())
                        return 0;
                    second = numbers.pop();
                    numbers.push(second - first);
                    break;
                }
                case "*": {
                    first = numbers.pop();
                    if (numbers.isEmpty())
                        return 0;
                    second = numbers.pop();
                    numbers.push(first * second);
                    break;
                }
                case "/": {
                    first = numbers.pop();
                    if (numbers.isEmpty())
                        return 0;
                    second = numbers.pop();
                    numbers.push(second / first);
                    break;
                }
                default: {
                    numbers.push(Integer.valueOf(tokens[i]));
                }
            }

        }
        if (numbers.isEmpty() || numbers.size() > 1)
            return 0;
        else
            return numbers.pop();
    }
}
