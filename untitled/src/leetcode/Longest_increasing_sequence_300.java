package leetcode;

public class Longest_increasing_sequence_300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.print(lengthOfLIS(nums));
//        input: nums = [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    }

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        if (nums.length <= 1)
            return nums.length;
        int maxLength = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = size, el = nums[i];
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] <= el)
                    left = mid + 1;

                else
                    right = mid;
            }
            tails[left] = el;
            if (left == size)
                size++;
        }
        return size;
    }
}
