package leetcode.repeat;

public class MaxProduct_subarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] max = new int[nums.length + 1];
        int[] min = new int[nums.length + 1];
        max[0] = nums[0];
        min[0] = nums[0];
        int max_val = Integer.MIN_VALUE;
        //int prod
        for (int i = 1; i < nums.length; i++) {
            int prod = max[i - 1] * nums[i];
            int prod_min = min[i - 1] * nums[i];
            max[i] = Math.max(nums[i], Math.max(prod, prod_min));
            min[i] = Math.min(nums[i], Math.min(prod_min, prod));
            max_val = Math.max(max_val, Math.max(max[i], min[i]));
        }
        return max_val;
    }
}
