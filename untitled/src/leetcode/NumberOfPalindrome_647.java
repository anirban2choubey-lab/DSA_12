package leetcode;

public class NumberOfPalindrome_647 {
    public static void main(String[] args) {

    }

    public  int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i + 1);

        }
        return res;
    }

    private  int countPalindrome(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r))
                res++;
            l--;
            r++;
        }
        return res;
    }
}
