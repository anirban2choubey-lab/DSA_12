package leetcode.repeat;

import java.util.*;

public class ThreesumProbem {
    public static void main(String[] args) {

    }

    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //l is starting from i+1 instead of 0 to avoid duplication of array i,e.->[-1,0,1] && [0,-1,1]
            int l = i + 1, r = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (l < r) {
                if ((l != i && r != i) && (nums[l] + nums[i] + nums[r] == 0)) {
                    res.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                } else if (nums[l] + nums[i] + nums[r] < 0)
                    l++;
                else
                    r--;
            }
        }

        return res;
    }
}
