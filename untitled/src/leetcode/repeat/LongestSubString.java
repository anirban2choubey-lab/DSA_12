package leetcode.repeat;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int l = i;

            while (l < s.length() && set.add(s.charAt(l))) {
                res = Math.max(res, set.size());
                l++;
            }

        }
        return res;
    }
}
