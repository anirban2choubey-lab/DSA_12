package leetcode.repeat;

import java.util.Stack;

public class DecodeString_394 {
    public static void main(String[] args) {
        String s = "3[c2[c]]";
        // Output: "accaccacc"
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> string_stack = new Stack<>();
        Stack<Integer> num_stack = new Stack<>();
        int num = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + c - '0';
            else if (c == '[') {
                num_stack.add(num);
                num = 0;
                if (!temp.isEmpty()) {
                    string_stack.add(temp.toString());
                    temp = new StringBuilder();
                }

            } else if (Character.isLetter(c)) {
                temp.append(c);
            } else if (c == ']') {
                String pop = string_stack.isEmpty() ? "" : string_stack.pop();
                int end = num_stack.pop();
                StringBuilder add = new StringBuilder();
                for (int j = 0; j < end; j++) {
                    if (temp.isEmpty())
                        add.append(pop);
                    else
                        add.append(temp);
                }
                temp = new StringBuilder();
                string_stack.add(pop + add.toString());
            }

        }
        return string_stack.pop();
    }

    public static String decodeString2(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                stringStack.add(sb.toString());
                integerStack.add(num);
                num = 0;
                sb = new StringBuilder();
            } else {
                StringBuilder pop = new StringBuilder(stringStack.pop());
                int repeat = integerStack.pop();
                StringBuilder nw = new StringBuilder();
                for (int j = 0; j < repeat; j++)
                    nw.append(sb);
                pop.append(nw);
                stringStack.add(pop.toString());

            }
        }
        return stringStack.pop();
    }

}
