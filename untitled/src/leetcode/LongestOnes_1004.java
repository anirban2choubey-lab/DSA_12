package leetcode;

public class LongestOnes_1004 {
    public static void main(String[] args) {

    }

    public int longestOnes(int[] nums, int k) {
        int maxCount = 0, limit = k;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                limit--;
            while (limit == -1 && l < i) {
                maxCount = Math.max(maxCount, i - l + 1);
                if (nums[i] == 0)
                    limit++;
                l++;
            }
        }
        maxCount = Math.max(maxCount, nums.length - l);
        return maxCount;
    }
}
