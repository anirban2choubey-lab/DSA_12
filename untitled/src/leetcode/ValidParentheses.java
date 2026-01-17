package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put('}', '{');

        Stack<Character> braces = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c= s.charAt(i);
            if (map.containsKey(c)) {
                if (braces.isEmpty() || braces.pop() != map.get(c))
                    return false;
            } else
                braces.push(c);
        }
        return braces.isEmpty();
    }
}
