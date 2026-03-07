package leetcode.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container_with_most_water {
    public static void main(String[] args) {
        int[] height = {1, 1};
        System.out.println("max water ::" + maxArea(height));
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int maxWater = 0;
        if (height.length <= 1)
            return 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int water = 0;
            if (height[l] > height[r]) {
                water = (r - l) * height[r];
                r--;
            } else {
                water = (r - l) * height[l];
                l++;
            }
            maxWater = Math.max(maxWater, water);
        }
        return maxWater;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0)
                    l++;
                else if (sum > 0)
                    r--;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }
            }
        }
        return res;
    }
}
