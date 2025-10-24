package leetcode;

import java.util.*;

public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private static void backTrack(int[] nums, ArrayList<Integer> temp, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(nums, temp, result, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
