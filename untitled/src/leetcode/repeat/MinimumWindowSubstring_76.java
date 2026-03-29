package leetcode.repeat;

public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String res = s + " ";
        if (s.equals(t))
            return s;
        if (t.length() > s.length())
            return "";

        for (int i = t.length(); i <= s.length(); i++) {
            int l = 0;
            String temp = s.substring(l, i);
            while (i - l >= t.length() && containsWord(temp, t)) {
                res = temp.length() < res.length() ? temp : res;
                 temp = s.substring(++l, i);
            }

        }
        return res;

    }

    public static boolean containsWord(String temp, String t) {
        int[] ar = new int[256];
        for (char c : temp.toCharArray())
            ar[c - 'A']++;
        for (char c : t.toCharArray()) {
            ar[c - 'A']--;
            if (ar[c - 'A'] < 0)
                return false;
        }
        return true;
    }
}
