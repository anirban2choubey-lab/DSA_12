package leetcode.repeat;

public class LongestPalindromicSubString_5 {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(LongestSubString(s));
    }

    private static String LongestSubString(String s) {
        String res = "";
        for (int i = 1; i <= s.length(); i++) {
            String tempodd = longestPalindrome(s, i, i);
            String tempEven = longestPalindrome(s, i, i + 1);

            if (tempodd.length() > res.length())
                res = tempodd;
            if (tempEven.length() > res.length())
                res = tempEven;
        }
        return res;
    }

    private static String longestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    private static int countPalindrome(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            totalCount += countPalindromeFromI(s, i, i);
            totalCount += countPalindromeFromI(s, i, i + 1);
        }
        return totalCount;
    }

    private static int countPalindromeFromI(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}


