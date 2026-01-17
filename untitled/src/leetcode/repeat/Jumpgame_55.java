package leetcode.repeat;

public class Jumpgame_55 {
    public boolean canJump(int[] nums) {
        int max_index = nums[0];
        int start = 0;
        int limit = max_index;
        for (int i = 0; i < nums.length; i++) {
            max_index = Math.max(i + nums[i], max_index);
            if (max_index >= nums.length)
                return true;
            if (nums[i] == 0)
                return false;
        }
        return false;
    }
}
