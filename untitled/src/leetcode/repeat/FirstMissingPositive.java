package leetcode.repeat;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {0, 1,2,3, 3, 4,6};
        System.out.println(firstPositive(nums));
    }

    private static int firstPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }
}
