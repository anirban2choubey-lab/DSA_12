package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Merge_interval_56 {

//    We are given a list of intervals. If any intervals overlap, we want to merge them into one.
//    Sorting by start time allows us to scan through and merge overlapping intervals on the go.
//    Approach -
//    Sort intervals by starting time.
//    Initialize a prev interval.
//    Iterate through the intervals:
//    If current interval overlaps with prev, merge them by updating the end time.
//    Else, add prev to result and update prev.
//    After loop ends, add the last prev.

    public static void main(String[] args) {
       // int[][] ar = {{1, 3}, {2, 5}, {5,6}, {8, 10}, {7, 18},{1,10}};
        int[][] ar = {{1, 4}, {4, 7}};
        int[][] res = merge(ar);
        for (int[] el : res) {
            System.out.print(Arrays.toString(el));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        List<int[]> res = new ArrayList<>();
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if ((current[0] >= temp[0] && current[0] <= temp[1]) ) {
                temp[1] = Math.max(current[1], temp[1]);

            } else {
                res.add(temp);
                temp = current;
            }
        }
       // if ((res.isEmpty() )|| (temp[0] != res.get(res.size()-1)[0] && temp[1]!=res.get(res.size()-1)[1]))
            res.add(temp);
        return res.toArray(new int[0][]);
    }
}
