package leetcode;

import java.util.*;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //ArrayList<Integer> res = new ArrayList<>();
        int[] resAr = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++)
            priorityQueue.add(nums[i]);
        for (int i = 0; i < nums.length - k; i++) {
            resAr[i] = priorityQueue.peek();
            //res.add(priorityQueue.peek());
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[i + k]);
        }
        resAr[resAr.length - 1] = priorityQueue.peek();
        return resAr;
    }

    public static int[] maxSlidingWindow_tree(int[] nums, int k) {
        int n = nums.length;
        int[] resAr = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < n - k; i++) {
            resAr[i] = map.firstKey();

            //removing the first element
            if (map.get(nums[i])==1)
                map.remove(nums[i]);
                //this is to handle duplication scenario
                //i.e [3,5,3],without the else block if we remove 3 both the 3 will be removed
            else
                map.put(nums[i], map.get(nums[i]) - 1);

            map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1);
        }
        resAr[resAr.length - 1] = map.firstKey();
        return resAr;
    }
}
