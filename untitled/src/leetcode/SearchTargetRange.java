package leetcode;

public class SearchTargetRange {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (target > nums[nums.length - 1] || nums[0] > target)
            return new int[]{-1, -1};
        int start = 0, end = nums.length - 1;
        int ans_0 = -1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (nums[m] == target) {
                ans_0 = m;
                end = m - 1;
            } else if (nums[m] > target) {
                start = m + 1;
            } else
                end = m - 1;
        }
        if (ans_0 == -1)
            return new int[]{-1, -1};
        res[0] = ans_0;
        start = 0;
        end = nums.length - 1;
        int ans_1 = -1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (nums[m] == target) {
                ans_1 = m;
                start = m + 1;
            } else if (nums[m] > target) {
                start = m + 1;
            } else
                end = m - 1;
        }
        res[1] = ans_1;
        return res;
    }
}
