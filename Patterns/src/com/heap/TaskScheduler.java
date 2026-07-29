package com.heap;
import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        // Step 1: Count task frequencies
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Step 2: Max-Heap to store frequencies (largest first)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : frequencies) {
            if (freq > 0) {
                maxHeap.add(freq);
            }
        }

        // Step 3: Cooldown queue storing arrays: {remaining_frequency, unlock_time}
        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        // Step 4: Simulate the CPU ticking clock
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++; // 1 unit of time passes

            // If a task is available to run, execute it!
            if (!maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll();
                currentFreq--; // Task is executed once

                // If it still needs to run again, bench it in the cooldown queue
                if (currentFreq > 0) {
                    cooldownQueue.add(new int[]{currentFreq, time + n});
                }
            }

            // Check if the benched task at the front of the queue is ready to wake up
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.add(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Minimum time required: " + leastInterval(tasks, n));
        // Expected Output: 8
    }
}