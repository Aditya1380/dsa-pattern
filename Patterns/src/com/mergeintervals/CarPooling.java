package com.mergeintervals;

import java.util.Arrays;

public class CarPooling {

	public static boolean carPooling(int[][] trips, int capacity) {
		// Because the max stop coordinate is guaranteed to be <= 1000,
		// we can create a fixed-size array to track passenger changes at each stop.
		int[] stopChanges = new int[1001];

		// Step 1: Log all pickup and drop-off events on the timeline
		for (int[] trip : trips) {
			int passengers = trip[0];
			int pickupStop = trip[1];
			int dropoffStop = trip[2];

			stopChanges[pickupStop] += passengers; // Passengers boarding (+)
			stopChanges[dropoffStop] -= passengers; // Passengers leaving (-)
		}

		// Step 2: Sweep chronologically through the timeline and check the capacity
		int currentPassengers = 0;
		for (int i = 0; i < stopChanges.length; i++) {
			currentPassengers += stopChanges[i]; // Update running total of people in the car

			// If at any stop the car overflows, the carpooling plan fails
			if (currentPassengers > capacity) {
				return false;
			}
		}

		// All stops evaluated successfully without overflowing!
		return true;
	}

	public static void main(String[] args) {
		int[][] trips1 = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity1 = 4;
		System.out.println("Can pool case 1? " + carPooling(trips1, capacity1)); // Output: false

		int[][] trips2 = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity2 = 5;
		System.out.println("Can pool case 2? " + carPooling(trips2, capacity2)); // Output: true
	}
}