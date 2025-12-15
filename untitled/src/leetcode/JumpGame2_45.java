package leetcode;

import java.util.Arrays;

public class JumpGame2_45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.print(jump2_optimized(nums));
    }

    public static int jump2(int[] nums) {
        if (nums.length == 1) return 0;
        int maxIndex = -1;
        int range = nums[0];
        int c = 0;
        int jump = 0;
        while (c < nums.length) {
            jump++;
            if (c + range >= nums.length - 1)
                return jump;
            int temp = 0;
            for (int i = c; i <= c + range; i++) {
                if (temp <= i + nums[i]) {
                    temp = i + nums[i];
                    maxIndex = i;
                }
            }
            c = maxIndex;
            range = nums[maxIndex];
        }
        return 0;
    }

    public static int jump2_optimized(int[] nums) {
        int jump = 0, currentEnd = 0, furthest = 0;
        for (int i = 0; i < nums.length-1; i++) {

            furthest = Math.max(furthest, i + nums[i]);
            if (i == currentEnd) {
                jump++;
                currentEnd = furthest;
            }
        }
        return jump;
    }

}
