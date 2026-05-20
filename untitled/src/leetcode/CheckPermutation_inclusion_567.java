package leetcode;

import java.util.Arrays;

public class CheckPermutation_inclusion_567 {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion_optimised(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int r = s1.length();
        char[] cs = s1.toCharArray();
        Arrays.sort(cs);
        String ss = String.valueOf(cs);
        for (int i = 0; i <= s2.length() - r; i++) {
            char[] ca = s2.substring(i, i + r).toCharArray();
            Arrays.sort(ca);
            if (ss.equals(String.valueOf(ca)))
                return true;
        }
        return false;

    }

    public static boolean checkInclusion_optimised(String s1, String s2) {
        int[] ar = new int[26];
        for (char c : s1.toCharArray())
            ar[c - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] inclusions = Arrays.copyOf(ar, ar.length);
            if (allIncluded(i, i + s1.length(), inclusions, s2))
                return true;
        }
        return false;
    }

    private static boolean allIncluded(int l, int r, int[] chars, String s) {
        for (int i = l; i < r; i++) {
            char c= s.charAt(i);
            if (chars[c - 'a'] <= 0)
                return false;
            chars[c - 'a']--;
        }
        return true;
    }
}
