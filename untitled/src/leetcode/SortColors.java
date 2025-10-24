package leetcode;

public class SortColors {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        switch (nums[mid]) {
            case 0: {
                swap(nums[low], nums[mid]);
                mid++;
                low++;
                break;
            }
            case 1 :{
                mid++;
                break;
            }
            case 2:{
                swap(nums[high], nums[mid]);
                high--;
                break;
            }
        }

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
