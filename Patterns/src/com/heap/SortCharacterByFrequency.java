package com.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharacterByFrequency {

	public static void main(String[] args) {
		String s = "tree";
		System.out.println("Sorted by frequency: " + frequencySort(s));
		// Expected Output: "eert" or "eetr"
	}

	private static String frequencySort(String s) {

		HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a, b) -> freqMap.get(b) - freqMap.get(a));

		maxHeap.addAll(freqMap.keySet());

		StringBuilder sb = new StringBuilder();

		while (!maxHeap.isEmpty()) {
			char current = maxHeap.poll();
			int count = freqMap.get(current);

			for (int i = 0; i < count; i++) {
				sb.append(current);
			}
		}

		return sb.toString();
	}
}
