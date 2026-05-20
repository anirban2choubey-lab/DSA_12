package leetcode.repeat;

import java.util.Arrays;

public class SumArrayK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
       System.out.println( subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        if (nums.length == 1)
            return nums[0] == k ? 1 : 0;
        Arrays.sort(nums);
        if (nums[0] > k)
            return 0;
        int l = 0;
        int r = 1;
        int sum = nums[l];
        while (r < nums.length && l < r) {
            if (sum == k)
                res++;
            if (sum > k)
                sum -= nums[l++];
            else
                sum += nums[++r];
        }
        return res;
    }
}

