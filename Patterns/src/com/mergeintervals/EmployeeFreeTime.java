package com.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition for an Interval given by the problem
class Interval {
	public int start;
	public int end;

	public Interval() {
	}

	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
}

public class EmployeeFreeTime {

	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> allIntervals = new ArrayList<>();

		// Step 1: Flatten all schedules into a single master list
		for (List<Interval> employeeSchedule : schedule) {
			allIntervals.addAll(employeeSchedule);
		}

		// Step 2: Sort the master list by start times
		Collections.sort(allIntervals, (a, b) -> Integer.compare(a.start, b.start));

		List<Interval> freeTime = new ArrayList<>();

		// Track the end of the current active busy block
		int currentEnd = allIntervals.get(0).end;

		// Step 3: Greedy sweep to find gaps
		for (int i = 1; i < allIntervals.size(); i++) {
			Interval nextInterval = allIntervals.get(i);

			// If the next busy block starts AFTER our current tracked busy block ends,
			// we have found a company-wide free gap!
			if (nextInterval.start > currentEnd) {
				freeTime.add(new Interval(currentEnd, nextInterval.start));
			}

			// Update our end tracker greedily
			currentEnd = Math.max(currentEnd, nextInterval.end);
		}

		return freeTime;
	}

	public static void main(String[] args) {
		// Formulating the sample schedule:
		// Employee 1: [[1, 3], [6, 7]]
		// Employee 2: [[2, 4]]
		// Employee 3: [[2, 5], [9, 12]]
		List<List<Interval>> schedule = new ArrayList<>();

		List<Interval> emp1 = new ArrayList<>();
		emp1.add(new Interval(1, 3));
		emp1.add(new Interval(6, 7));

		List<Interval> emp2 = new ArrayList<>();
		emp2.add(new Interval(2, 4));

		List<Interval> emp3 = new ArrayList<>();
		emp3.add(new Interval(2, 5));
		emp3.add(new Interval(9, 12));

		schedule.add(emp1);
		schedule.add(emp2);
		schedule.add(emp3);

		List<Interval> freeSlots = employeeFreeTime(schedule);

		System.out.print("Common Free Time Blocks: ");
		for (Interval slot : freeSlots) {
			System.out.print("[" + slot.start + ", " + slot.end + "] ");
		}
		// Expected Output: [5, 6] [7, 9]
	}
}