package leetcode;

import java.util.Arrays;

public class RobHouseCircullar_213 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 1};
        System.out.print(rob_reusable(nums));
    }

    public static int rob(int[] nums) {
        int index0 = 0;
        int index1 = 0;
        int n = nums.length;
        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = nums[0];
        for (int i = 2; i <= nums.length - 1; i++) {
            tab[i] = Math.max(tab[i - 1], nums[i - 1] + tab[i - 2]);
        }
        index0 = tab[nums.length - 1];
        Arrays.fill(tab, 0);
        tab[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            tab[i] = Math.max(tab[i - 1], nums[i - 1] + tab[i - 2]);
        }
        index1 = tab[nums.length];
        return Math.max(index0, index1);
    }

    public static int rob_reusable(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int x = rob_recursion(nums, 0, nums.length - 1);
        int y = rob_recursion(nums, 1, nums.length);
        return Math.max(x, y);
    }

    static int rob_recursion(int[] nums, int begin, int end) {
        int a = 0;
        int b = nums[begin];
        int c = 0;
        for (int i = begin + 1; i < end; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
