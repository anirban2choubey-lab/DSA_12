package leetcode.repeat;

public class Robbery2_213 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int res = 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1)
            return nums[0];
        int n = rob_recursion(nums, 0, nums.length - 1);
        int n_1 = rob_recursion(nums, 1, nums.length);
        return Math.max(n, n_1);
    }

    public int rob_recursion(int[] nums, int s, int e) {
        int a = 0, b = nums[s], res = 0;
        for (int i = s + 1; i < e; i++) {
            res = Math.max(a + nums[i], b);
            a = b;
            b = res;
        }
        return res;
    }
}
