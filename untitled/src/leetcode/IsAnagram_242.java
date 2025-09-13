package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram_242 {
    public static void main(String[] args) {
        String s = "abcdEF!", t = "EFabcd!";
        System.out.println(isAnagramWithUnicode(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] freq = new char[256];
        for (char c : s.toCharArray())
            freq[c - 'A']++;
        for (char c : t.toCharArray()) {
            if (freq[c - 'A'] <= 0)
                return false;
            freq[c - 'A']--;
        }

        return true;

    }

    public static boolean isAnagramWithUnicode(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c) || freq.get(c) == 0)
                return false;
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        return true;
    }
}
