package leetcode.repeat;

import java.util.Stack;

public class LargestRectangleHistoGram_84 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int el = i == heights.length ? 0 : heights[i];

            while (stack.isEmpty() && el < heights[stack.peek()]) {
                int pop = stack.pop();
                int width = i - pop + 1;
                int height = heights[pop];
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }


}
