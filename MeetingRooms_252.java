
//https://www.lintcode.com/problem/meeting-rooms/
//https://www.youtube.com/watch?v=i2bBG7CaVxs

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_252 {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public boolean interval() {
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] ary = new Interval[3];
		ary[0] = i1;
		ary[1] = i2;
		ary[2] = i3;
		boolean canAttend = canAttendMeeting(ary);
		System.out.println(canAttend);
		return canAttend;
	}
	
	//Solution 1
	public boolean canAttendMeeting(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].end > intervals[i].start) {
				return false;
			}
		}

		return true;
	}

	//Solution2
	public boolean canAttendMeetings2(Interval[] intervals) {
		if (intervals.length == 0) {
			return true;
		}

		int min = intervals[0].start, max = intervals[0].end;

		PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.start - b.start);

		for (Interval itr : intervals) {
			pq.add(itr);
		}

		Interval meetingTime = pq.poll();
		int start = meetingTime.start, end = meetingTime.end;

		while (!pq.isEmpty()) {
			Interval nextMeeting = pq.poll();
			if (nextMeeting.start < meetingTime.end) {
				return false;
			}
			start = nextMeeting.start;
			end = nextMeeting.end;
		}

		return true;
	}

	public static void main(String[] args) {
		MeetingRooms_252 rooms = new MeetingRooms_252();
		rooms.interval();

	}

}
