package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int l = 0, r = 0, sum = 0;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        while (r < nums.length) {
            temp.add(nums[r]);
            sum += nums[r];
            if (sum == target && temp.size()==4)
                res.add(temp);
            if (sum > target) {
                temp.remove(nums[l]);
                sum -= nums[l++];
            }
            r++;
        }
        return res;
    }
}
