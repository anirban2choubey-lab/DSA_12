package leetcode.repeat;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.print(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sortedString = new String(chs);
            if (hm.containsKey(sortedString))
                hm.get(sortedString).add(s);
            else {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                hm.put(sortedString, tmp);
            }
        }
        return new ArrayList<>(hm.values());
    }
}
