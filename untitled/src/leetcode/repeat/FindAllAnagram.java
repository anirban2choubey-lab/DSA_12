package leetcode.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagram {
    public static void main(String[] args) {

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = p.length();
            for (int i = 0; i < s.length() - p.length() + 1; i++) {
                String t = s.substring(i, i + p.length());
                if (isAnagram(s, p, i))
                    res.add(i);
            }
        return res;
    }

    static boolean isAnagram(String s, String p, int l) {
        int[] chars = new int[256];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'A']++;
            chars[s.charAt(l + i) - 'A']--;
        }
        for (int i : chars) {
            if (i != 0)
                return false;
        }
        return true;
    }


}
