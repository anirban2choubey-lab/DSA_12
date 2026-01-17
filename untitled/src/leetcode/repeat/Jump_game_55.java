package leetcode.repeat;

public class Jump_game_55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 1;
        if (nums.length <= 1) return nums.length;
        int max_length = -1;
        int jumpCount = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i + nums[i] > max_length) {
                jumpCount++;
                max_length = i + nums[i];
                if (max_length >= nums.length - 1)
                    return jumpCount;
            }
        }
        return -1;
    }

    public static int jump2(int[] nums) {
        if (nums.length <= 1) return 0;
        int max_index = -1;
        int range = nums[0];
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (range >= nums.length - 1) return jump;
            max_index = Math.max(i + nums[i], max_index);
            if (i == range) {
                jump++;
                range = max_index;
            }
        }
        return jump;
    }
}
