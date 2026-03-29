package leetcode.repeat;

import java.util.*;

public class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.print(Arrays.toString(maxSlidingWindow(ar, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i])
                dq.removeLast();
            if (!dq.isEmpty() && dq.getLast() == k - i)
                dq.removeLast();
            if (i >= k)
                res[i - k + 1] = nums[dq.getFirst()];
            dq.addFirst(i);


        }
        return res;
    }
}