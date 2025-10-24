package leetcode;

import java.util.*;

public class PermutationWithDuplicate_47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, res, new ArrayList<Integer>(),visited);
        return res;
    }

    private static void backtracking(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) continue;
            if (visited[i] == true) continue;
            temp.add(nums[i]);
            visited[i] = true;
            backtracking(nums, res, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
