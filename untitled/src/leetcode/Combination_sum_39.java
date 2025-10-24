package leetcode;

import java.util.*;

public class Combination_sum_39 {
    public static void main(String[] args) {

    }

    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<>();
        backtrack(res,candidates,new ArrayList<Integer>(),target,0);
        return res;
    }

    private  void backtrack(List<List<Integer>> res, int[] candidates, ArrayList<Integer> temp, int target,int start) {
        if(target==0){
            res.add(temp);
            return;
        }
        if (target<0){
            //temp.remove(temp.size()-1);
            target-=temp.get(temp.size()-1);
            return;
        }
        for (int i =start;i< candidates.length;i++){
            if (candidates[i] > target) break; // no need to continue
            temp.add(candidates[i]);
            backtrack(res,candidates,temp,target-candidates[i],i+1);
            temp.remove(temp.size()-1);

        }

    }
}
