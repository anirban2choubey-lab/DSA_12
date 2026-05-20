package leetcode.repeat;

public class HouseRobber_198 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1], nums[i] + res[i - 2]);
        }
        return res[nums.length];
    }

    //house robber circullar
    public int rob_circular(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] oddRes = new int[nums.length + 1];
        int[] evenRes = new int[nums.length + 1];
        oddRes[0] = 0;
        oddRes[1] = nums[0];
        evenRes[0] = 0;
        evenRes[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            oddRes[i] = Math.max(oddRes[i - 1], oddRes[i - 2] + nums[i-1]);
        }
        for (int i = 2; i <= nums.length; i++) {
            evenRes[i] = Math.max(evenRes[i - 1], evenRes[i - 2] + nums[i-1]);
        }
        return Math.max(evenRes[nums.length], oddRes[nums.length - 1]);
    }
}
