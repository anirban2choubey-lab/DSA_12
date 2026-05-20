package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestSum_373 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        while (k > 0) {
            if (i == 0 && j == 0)
                res.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
            if (nums1[i + 1] < nums2[j + 1])
                i++;
            else
                j++;
            k++;
        }
        return res;
    }
}
