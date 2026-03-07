package leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int el = nums[i];
            if (hm.containsKey(target - el)) {
                res[0] = hm.get(target - el);
                res[1] = i;
                return res;
            } else
                hm.put(el, i);
        }

        return new int[]{};
    }

}
