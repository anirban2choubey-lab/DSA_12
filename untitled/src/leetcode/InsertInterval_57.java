package leetcode;

import java.util.ArrayList;

public class InsertInterval_57 {
    public static void main(String[] args) {

    }
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    // 1st iteration =>res ==> [] temp=> {4,8} cur =>1,2 temp==>4,8
    //2nd=> res->1,2 temp->4,8, cur->3,5===> temp->3,8
    //3rd => res->1,2 temp =>3,8,cur=> 6,7 ==>temp=3,8
    //4th => res ->1,2 temp=>3,8, cur =>8,10 ===>temp=>3,10
    //5th => res ->1,2 temp=>3,10 cur =>12,16 ===> temp =>12,16

    //Output: [[1,2],[3,10],[12,16]]
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length < 1 || intervals.length < 1)
            return intervals;
        ArrayList<int[]> res = new ArrayList<>();
        int[] temp = newInterval;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if ((cur[0] >= temp[0] && cur[0] <= temp[i]) || temp[0] >= cur[0] && temp[0] <= cur[1]) {
                temp[0] = Math.min(temp[0], cur[0]);
                temp[1] = Math.max(temp[1], cur[1]);
            } else {
                if (cur[0] <= temp[0])
                    res.add(cur);
                else {
                    res.add(temp);
                    temp = cur;
                }
            }
        }
        res.add(temp);
        return res.toArray(new int[0][]);
    }
}
