package leetcode;

public class MaxProduct_152 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] minDp = new int[nums.length + 1];
        minDp[0] = nums[0];
        int[] maxDp = new int[nums.length + 1];
        maxDp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int el = nums[i];
            int prod = el * maxDp[i - 1];
            int prod_neg = el * minDp[i - 1];
            maxDp[i] = Math.max(prod_neg, prod);
            maxDp[i] = Math.max(maxDp[i], el);
            minDp[i] = Math.min(prod_neg, prod);
            minDp[i] = Math.min(minDp[i], el);
            max = Math.max(maxDp[i], max);
        }

        return max;
    }
}
