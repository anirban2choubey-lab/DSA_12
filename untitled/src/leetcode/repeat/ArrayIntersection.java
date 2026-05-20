package leetcode.repeat;

import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int n1 : nums1)
            map.put(n1, map.getOrDefault(n1, 0) + 1);

        for (int n2 : nums2) {
            if (map.containsKey(n2) && map.get(n2) > 0) {
                res.add(n2);
                map.put(n2, map.get(n2) - 1);
            }
        }
        int[] res_ar = new int[res.size()];
        for (int i = 0; i < res_ar.length; i++)
            res_ar[i] = res.get(i);
        return res_ar;
    }

}
