package leetcode.repeat;

import java.util.*;

public class LongestConsecutive_128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive_set(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int res = 1;
        int maxRes = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        Arrays.stream(nums).forEach(e -> treeSet.add(e));
        int prev = treeSet.pollFirst();
        while (!treeSet.isEmpty()) {
            int cur = treeSet.pollFirst();
            if (prev == cur - 1) {
                res++;
                maxRes = Math.max(maxRes, res);
            } else {
                res = 1;
            }
            prev = cur;
        }
        return maxRes;
    }

    public static int longestConsecutive_set(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Set<Integer> set = new HashSet<>();
        int count = 1;
        int maxCount = 1;
        Arrays.stream(nums).forEach(e -> set.add(e));

        for (int e : set) {
            int cur = e;
            while (set.contains(cur + 1)) {
                count++;
                maxCount = Math.max(count, maxCount);
                cur++;
            }
            count=1;
        }
        return maxCount;
    }
}
