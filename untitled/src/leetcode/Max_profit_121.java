package leetcode;

import java.util.*;

public class Max_profit_121 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            hm.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != nums[i])
                return new int[]{i, hm.get(target - nums[i])};
        }
        return new int[]{};
    }
}
