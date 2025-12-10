package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        Boolean[] visited = new Boolean[nums.length];
        int[] target = nums;
        Arrays.sort(nums);
        backTracking(nums, new ArrayList<Integer>(), target, visited);
    }

    private static void backTracking(int[] nums, ArrayList<Integer> temp, int[] target, Boolean[] visited) {
        List<Integer> prev = new ArrayList<>();

        if (!prev.isEmpty() &&  prev.equals(Arrays.asList(target))) {
            nums = temp.stream().mapToInt(Integer::intValue).toArray();
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && visited[i] == true) continue;
            temp.add(nums[i]);
            visited[i] = true;
            if (temp.size() == target.length) {
                prev = temp;
            }
            backTracking(nums, temp, target, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
