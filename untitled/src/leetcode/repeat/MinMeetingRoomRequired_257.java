package leetcode.repeat;

import leetcode.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRoomRequired_257 {
    public static void main(String[] args) {
        List<Interval> ar = new ArrayList<>();
        Interval in1 = new Interval(1, 5);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(10, 15);
        Interval in4 = new Interval(15, 20);
        ar.add(in1);
        ar.add(in2);
        ar.add(in3);
        ar.add(in4);
        System.out.println("res -- " + minMeetingRooms(ar));
    }

    //the idea is to check if the  start time of the current meeting is coming before
// the end time of meeting which is finishing earliest.
//for the same reason we are storing the endtimes of every meeting in min_heap so we get the meeting order by which finishes first
    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals.size();
        int room = 1;
        intervals.sort(((o1, o2) -> o1.start - o2.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start >= pq.peek())
                pq.poll();
            else
                room++;
            pq.offer(intervals.get(i).end);
        }

        return room;
    }
}
