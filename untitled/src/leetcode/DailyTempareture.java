package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTempareture {
    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        //[1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures_usingArray(temps)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int el = temperatures[i];
            while (!stack.isEmpty() && el > temperatures[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperatures_usingArray(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        int l = 0;
        for (int i = 0; i < temperatures.length; i++) {
            int el = temperatures[i];
            //int l = i - 1;
            while (l >= 0 && el > temperatures[l] && res[l] == 0) {
                res[l] = i - l;
                l--;
            }
            l=i;
        }
        return res;
    }
}
