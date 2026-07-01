package com.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

	public static void main(String[] args) {
		// Case 1: Requires 2 rooms because [5, 10] and [15, 20] can share a room after
		// [0, 30] takes room 1
		int[][] schedule1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("Minimum rooms needed for schedule 1: " + minMeetingRooms(schedule1)); // Output: 2

		// Case 2: Clean back-to-back meetings can all share 1 room
		int[][] schedule2 = { { 7, 10 }, { 2, 4 } };
		System.out.println("Minimum rooms needed for schedule 2: " + minMeetingRooms(schedule2)); // Output: 1
	}

	private static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		PriorityQueue<Integer> roomEndTimes = new PriorityQueue<Integer>();

		roomEndTimes.add(intervals[0][1]);

		for (int i = 1; i < intervals.length - 1; i++) {
			int currentMeetingStart = intervals[i][0];
			int currentMeetingEnd = intervals[i][1];

			int earliestEnd = roomEndTimes.peek();

			if (currentMeetingStart >= earliestEnd) {
				roomEndTimes.poll();
			}

			roomEndTimes.add(currentMeetingEnd);
		}

		return roomEndTimes.size();
	}
}
