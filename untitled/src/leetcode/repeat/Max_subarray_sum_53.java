package leetcode.repeat;

public class Max_subarray_sum_53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int j=i;
            while (sum >= 0 && j < nums.length) {
                sum += nums[j++];
                maxSum = Math.max(maxSum, sum);
            }
            i=j-1;
            sum = 0;
        }
        return maxSum;
    }
}
