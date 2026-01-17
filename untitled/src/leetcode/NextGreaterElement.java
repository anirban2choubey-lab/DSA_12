package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return nums;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            int el = nums[i % n];
            while (!stack.isEmpty() && el > nums[stack.peek()]) {
                res[stack.pop()] = el;
            }
            stack.push(i % n);
        }
        return res;
    }
}

