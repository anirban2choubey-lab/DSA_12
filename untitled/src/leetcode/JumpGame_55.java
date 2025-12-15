package leetcode;

public class JumpGame_55 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.print(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int maxIndex = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1)
                return true;
        }
        return false;
    }
}
