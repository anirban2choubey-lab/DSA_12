package leetcode;

import java.util.*;

public class Permutation_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private static void backtracking(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int start) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            temp.add(num);
            backtracking(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
