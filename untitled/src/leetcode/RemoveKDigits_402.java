package leetcode;

import java.util.Stack;

public class RemoveKDigits_402 {
    public static void main(String[] args) {
        String num = "33526221184202197273";
        int k = 19;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char el = num.charAt(i);
            while (!stack.isEmpty() && el < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(el);
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty())
            return "0";
        while (!stack.isEmpty())
            res.append(stack.pop());
        int i = 0;
        while (res.charAt(i) == 0) {
            res.deleteCharAt(i);
            i++;
        }
        return res .reverse().toString();
    }
}
