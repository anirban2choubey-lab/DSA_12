package leetcode.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_intervals {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] a = {intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && a[1] >= intervals[j][0]) {
                a[1] = Math.max(a[1], intervals[j][1]);
                j++;
            }
            res.add(a);
            i = j - 1;
        }
        return res.toArray(new int[res.size()][]);
    }
}
