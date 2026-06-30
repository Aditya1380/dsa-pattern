package com.mergeintervals;

import java.util.Arrays;

public class MeetingRooms {
	public static void main(String[] args) {
		// Case 1: Overlapping meetings ([0,30] completely swallows the others)
		int[][] schedule1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("Can attend schedule 1? " + canAttendMeetings(schedule1)); // Output: false

		// Case 2: Clean back-to-back meetings
		int[][] schedule2 = { { 5, 8 }, { 9, 15 }, { 15, 20 } };
		System.out.println("Can attend schedule 2? " + canAttendMeetings(schedule2)); // Output: true
	}

	private static boolean canAttendMeetings(int[][] intervals) {
		if (intervals.length <= 1 || intervals == null) {
			return true;
		}

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < intervals.length - 1; i++) {
			int currentMeetingEnd = intervals[i][1];
			int nextMeetingStart = intervals[i + 1][0];

			if (nextMeetingStart < currentMeetingEnd) {
				return false;
			}
		}

		return true;
	}
}
