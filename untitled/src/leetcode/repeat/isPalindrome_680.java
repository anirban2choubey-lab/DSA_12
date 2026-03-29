package leetcode.repeat;

public class isPalindrome_680 {
    public static void main(String[] args) {
//abca

    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                if (!isPalindrom(s, l + 1, r) && !isPalindrom(s, l, r - 1))
                    return false;
            l++;
            r--;
        }
        return true;
    }

    static boolean isPalindrom(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
