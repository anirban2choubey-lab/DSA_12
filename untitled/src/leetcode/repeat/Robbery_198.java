package leetcode.repeat;

public class Robbery_198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int res = 0;
        if (nums.length == 1)
            return nums[0];

        int a = 0;
        int b = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(a + nums[i], b);
            a = b;
            b = res;
        }
        return res;
    }
}
