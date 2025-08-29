package leetcode;

import java.util.Arrays;


public class ProductExceptSelf {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1)
            return nums;

        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int prod = 1;
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i - 1];
            res[i] = prod;
        }
        System.out.println(Arrays.toString(res));
        prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            res[i] *= prod;
        }
        return res;
    }
}