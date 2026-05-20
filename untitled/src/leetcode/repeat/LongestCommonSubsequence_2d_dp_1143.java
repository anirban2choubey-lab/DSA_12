package leetcode.repeat;

import java.util.Arrays;

public class LongestCommonSubsequence_2d_dp_1143 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = temp;
            }
        }
        return dp[m][n];
    }

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int leftSum = 0, rightSum = 0;

        while (l < r) {
            leftSum += nums[l];
            rightSum += nums[r];
            if (leftSum==rightSum)
                return true;
            if (leftSum<rightSum)
                l++;
            else
                r++;
        }
    }
}


