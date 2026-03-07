package leetcode.repeat;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {-4, -3};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int[] min_array = new int[nums.length];
        int[] max_array = new int[nums.length];
        int max = nums[0];
        max_array[0] = nums[0];
        min_array[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_array[i] = Math.max(nums[i], Math.max(max_array[i - 1] * nums[i], min_array[i - 1] * nums[i]));
            min_array[i] = Math.min(nums[i], Math.min(max_array[i - 1] * nums[i], min_array[i - 1] * nums[i]));
            max = Math.max(max, Math.max(max_array[i], min_array[i]));
        }
        return max;
    }
}
