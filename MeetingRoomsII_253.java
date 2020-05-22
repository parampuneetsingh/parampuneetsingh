//https://www.lintcode.com/problem/meeting-rooms-ii
//https://www.youtube.com/watch?v=PWgFnSygweI

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {

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

	public int interval() {
		 Interval i1 = new Interval(0,30);
		 Interval i2 = new Interval(5,10);
		 Interval i3 = new Interval(15,20);
		//Interval i1 = new Interval(6, 15);
		//Interval i2 = new Interval(13, 20);
		//Interval i3 = new Interval(6, 17);
		Interval[] ary = new Interval[3];
		ary[0] = i1;
		ary[1] = i2;
		ary[2] = i3;
		int min = minMeetingRooms2(ary);
		System.out.println(min);
		return min;
	}

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(1, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});

		minHeap.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval current = intervals[i];
			Interval earliest = minHeap.remove();
			if (current.start >= earliest.end) {
				earliest.end = current.end;
			} else {
				minHeap.add(current);
			}

			minHeap.add(earliest);
		}
		return minHeap.size();
	}

	public int minMeetingRooms2(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.end - b.end);

		pq.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Interval current = intervals[i];
			Interval earliest = pq.poll();
			if (current.start >= earliest.end) {
				earliest.end = current.end;
			} else {
				pq.add(current);
			}

			pq.add(earliest);
		}
		return pq.size();
	}

	public static void main(String[] args) {
		MeetingRoomsII_253 rooms = new MeetingRoomsII_253();
		rooms.interval();
	}

}
