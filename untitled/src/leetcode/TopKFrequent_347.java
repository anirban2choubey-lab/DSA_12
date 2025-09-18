package leetcode;

import java.util.*;

public class TopKFrequent_347 {
    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int e : nums)
            hm.put(e, hm.getOrDefault(e, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> e : list) {
            sortedMap.put(e.getKey(), e.getValue());
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            res[count] = entry.getValue();
            count++;
            if (count == k) break; // stop after k
        }
        return res;
    }

    public static int[] topKFrequent_withPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int[] temp = heap.poll();
            ans[i] = temp[0];
        }
        return ans;
    }
}
