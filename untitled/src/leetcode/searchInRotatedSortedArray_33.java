package leetcode;

public class searchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target <= nums[mid])
                    j = mid - 1;
                else
                    i = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[j])
                    i = mid + 1;
                else
                    j = mid - 1;


            }
        }
        return -1;
    }
}
