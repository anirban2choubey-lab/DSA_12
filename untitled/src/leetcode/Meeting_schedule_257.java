package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Meeting_schedule_257 {
    public static void main(String[] args) {
        List<Interval> ar = new ArrayList<>();
        Interval in1 = new Interval(0, 40);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(15, 20);
        Interval in4 = new Interval(30, 45);
        ar.add(in1);
        ar.add(in2);
        ar.add(in3);
        ar.add(in4);
        System.out.println("res -- "+minMeetingRooms(ar));
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals.size();
        intervals.sort(Comparator.comparingInt(a -> a.start));
        Interval temp = intervals.get(0);
        int conflict = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (temp.start <= cur.start && temp.end >= cur.start) {
                conflict++;
            }
            temp = cur;
        }
        return conflict + 1;
    }
}
