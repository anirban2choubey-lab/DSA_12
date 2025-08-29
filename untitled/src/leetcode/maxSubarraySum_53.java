package leetcode;

public class maxSubarraySum_53 {


    public static void main(String[] args) {
        int[] nums = { -2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));

    }

    //mainly we need to keep on adding elements from left till the sum become negative
    // if it's negative have to update the value tp zero & keep on comparing with
    // max sum
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int currentSum = nums[i];
            int j = i + 1;

            while (j < nums.length && currentSum + nums[j] > 0) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
                j++;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //maxSum = Math.max(nums[i], maxSum);
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0)
                currentSum = 0;


        }
        return maxSum;
    }


}
