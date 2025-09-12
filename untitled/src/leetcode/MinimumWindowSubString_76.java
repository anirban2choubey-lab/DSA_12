package leetcode;

public class MinimumWindowSubString_76 {
    public static void main(String[] args) {
        String s = "bbaa", t = "aba";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        if (s.length() < t.length())
            return s.equals(t) ? s : "";
        String minWindow = s + " ";
        String temp = "";
        int l = 0;
        for (int i = t.length(); i <= s.length(); i++) {
            temp = s.substring(l, i);
            while (containsChars(temp, t)) {
                if (temp.length() < minWindow.length())
                    minWindow = temp;
                temp = s.substring(++l, i);
            }
        }
        return minWindow.length() > s.length() ? "" : minWindow;
    }

    public static boolean containsChars(String s, String t) {
        int[] chars = new int[256];
        for (char c : t.toCharArray())
            chars[c - 'a']++;
        for (char c : s.toCharArray())
            chars[c - 'a']--;
        for (char c : t.toCharArray())
            if (chars[c - 'a'] > 0)
                return false;

        return true;
    }

}
