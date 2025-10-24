package leetcode;

import java.util.*;

public class Combination_sum_40 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void backtracking(int[] candidates, List<List<Integer>> res, ArrayList<Integer> temp, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i>start && candidates[i]==candidates[i-1]) continue;
            int num = candidates[i];
            if (num > target) break;
            temp.add(num);
            backtracking(candidates, res, temp, target - num, i + 1);
            temp.remove(temp.size()-1);
        }

    }
}
