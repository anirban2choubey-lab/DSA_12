package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTempareture {
    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
      //[1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length <= 1)
            return temperatures;
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
