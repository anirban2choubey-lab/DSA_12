package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram_49 {
    public static void main(String[] args) {

    }



    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();

            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (hm.containsKey(sortedString))
                hm.get(sortedString).add(strs[i]);
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hm.put(sortedString, list);
            }
        }
        for (String el : hm.keySet()) {
            res.add(hm.get(el));
        }
        return res;
    }
}
