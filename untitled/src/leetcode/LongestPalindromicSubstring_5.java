package leetcode;

import java.util.concurrent.ThreadPoolExecutor;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bab"));
    }
//not covering all test cases needs revisit
    public static String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        String res = "";
        for (int i = 0; i <= s.length(); i++) {
            String s1 = longestPalindromFromMiddle(s.substring(0, i));
            res = res.length() < s1.length() ? s1 : res;
        }
        return res;
    }

    public static String longestPalindromFromMiddle(String s) {
        String res = "";
        int i = 0, j = 0;
        if (s.length() % 2 == 0) {
            i = s.length() / 2-1;
            j = s.length() / 2 ;
        } else {
            i =s.length() / 2;
            j=s.length()/2;
        }
        while (i >= 0 && j <= s.length() && s.charAt(i) == s.charAt(j)) {
            res = s.substring(i, j+1 );
            i--;
            j++;

        }
        return res;
    }
}
