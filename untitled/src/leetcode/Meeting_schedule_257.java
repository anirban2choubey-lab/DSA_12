package leetcode;

import java.util.*;

public class Meeting_schedule_257 {
    public static void main(String[] args) {
        List<Interval> ar = new ArrayList<>();
        Interval in1 = new Interval(0, 25);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(15, 20);
        Interval in4 = new Interval(30, 45);
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
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> sorted_end_time = new PriorityQueue<>();
        sorted_end_time.offer(intervals.get(0).end);
        Interval temp = intervals.get(0);
        int required_room = 1;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start >= sorted_end_time.peek())
                sorted_end_time.poll();
            else
                required_room++;

            sorted_end_time.offer(cur.end);
        }
        return required_room;
    }


    public int minMeetingRooms_Gemini_suggested(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 1. Sort the intervals based on their start times.
        // This ensures we process meetings chronologically.
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        // 2. Initialize a Min-Heap to store the *end times* of meetings
        // that are currently occupying a room/day.
        // The Min-Heap ensures we can quickly find the meeting that finishes earliest.
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        // 3. Process the first meeting: it always needs one day.
        endTimes.offer(intervals[0].end);

        // 4. Iterate through the rest of the meetings.
        for (int i = 1; i < intervals.length; i++) {
            Interval currentMeeting = intervals[i];

            // Get the earliest end time among all meetings currently scheduled.
            int earliestEndTime = endTimes.peek();

            // Check for a conflict:
            // If the current meeting's start time is GREATER THAN OR EQUAL to
            // the earliest end time, it means a day is freed up.
            if (currentMeeting.start >= earliestEndTime) {
                // The room is free, so remove the old meeting's end time
                // and use that same day for the current meeting.
                endTimes.poll();
            }

            // In BOTH cases (free day OR new conflict), we must schedule the current meeting.
            // Add the current meeting's end time to the heap.
            endTimes.offer(currentMeeting.end);
        }
//Arrays.sort(intervals,Comparator.comparingInt());
        // The size of the heap at the end represents the maximum number of
        // simultaneous meetings, which is the minimum number of days required.
        return endTimes.size();
    }
}

