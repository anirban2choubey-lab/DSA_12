package leetcode;

import java.util.HashMap;

public class SubArraySumEqualsK_560 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};//
        System.out.println(subarraySum(nums, 3));
    }
//explanation : https://www.youtube.com/watch?v=fFVZt-6sgyo
    //the confusing part is why (preSum-k) is working but k-presum is not working
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (hm.containsKey(preSum - k))
                res += hm.get(preSum - k);
            hm.put(preSum, hm.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }


}

