package leetcode;

import java.util.*;

public class Subsets_without_dups {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int start) {
       res.add(new ArrayList<>(temp));
       for (int i=start;i< nums.length;i++){
           if (i>start && nums[i]==nums[i-1]) continue;
           temp.add(nums[i]);
           backtrack(nums,res,temp,i+1);
           temp.remove(temp.size()-1);
       }
    }
}
