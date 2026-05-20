package leetcode.repeat;

import java.util.*;

public class TopKFrequent_347 {
    public static void main(String[] args) {
//        input: nums = [1,1,1,2,2,3], k = 2
//
//        Output: [1,2]
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int e : nums)
            freq.put(e, freq.getOrDefault(e, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> el : freq.entrySet())
            priorityQueue.add(el);

        for (int i = 0; i < res.length; i++)
            res[i]=priorityQueue.poll().getKey();

        return res;
    }
}
