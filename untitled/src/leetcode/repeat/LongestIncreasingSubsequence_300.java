package leetcode.repeat;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] tab = new int[nums.length];

        Arrays.fill(tab, 1);
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    tab[i] = Math.max(tab[i], tab[j] + 1);
            }
            maxLen = Math.max(tab[i], maxLen);
        }
        return maxLen;
    }

    public static int lengthOfLIS_binarySearch(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] tab = new int[nums.length + 1];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int low = 0, high = size;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (tab[mid] < num)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            if (low == size)
                size++;
            tab[low] = num;
        }
        return size;
    }
}
