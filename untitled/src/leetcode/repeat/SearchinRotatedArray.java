package leetcode.repeat;

public class SearchinRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3,1};
        int t = 1;
        System.out.println(search(nums, t));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return m;
            if (nums[l] <= nums[m]) {
                if (target < nums[m] && target >= nums[l])
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }


        }
        return -1;
    }
}
