package leetcode.repeat;

import java.util.Arrays;

public class ProductExceptSelf_238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        productExceptSelf(nums);
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums==null||nums.length==1)
            return nums;
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        int mul = 1;
        for (int i = 1; i < nums.length; i++) {
           mul*=nums[i-1];
           res[i]=mul;
        }
        mul = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            mul*=nums[i+1];
            res[i]*=mul;
        }
        System.out.println("after adding suffix- " + Arrays.toString(res));
        return res;
    }

    // Output: [24,12,8,6]
}
