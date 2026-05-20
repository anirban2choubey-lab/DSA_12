package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class First_unique_character_387 {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> lm = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++)
            lm.put(s.charAt(i), lm.getOrDefault(s.charAt(i), 0) + 1);

        while (!lm.isEmpty()) {
            Map.Entry<Character, Integer> e = lm.pollFirstEntry();
            if (e.getValue() == 1)
                return s.indexOf(e.getKey());
        }
        return -1;
    }

    public int firstUniqChar_ar(String s) {
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++)
            chars[s.charAt(i) - 'A']++;
        for (int i = 0; i < s.length(); i++)
            if (chars[s.charAt(i) - 'A'] == 1)
                return i;
        return -1;
    }
}
