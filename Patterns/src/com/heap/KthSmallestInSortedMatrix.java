package com.heap;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // Min-Heap storing triples: {val, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Step 1: Push the first element of up to min(n, k) rows into the Min-Heap
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        // Step 2: Pop k - 1 times to reach the k-th smallest element
        for (int step = 0; step < k - 1; step++) {
            int[] current = minHeap.poll();
            int r = current[1];
            int c = current[2];

            // If there is a next column element in the same row, add it to the heap
            if (c + 1 < n) {
                minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }

        // The top of the heap is now the k-th smallest element
        return minHeap.peek()[0];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 4;

        System.out.println("8th Smallest Element: " + kthSmallest(matrix, k));
        // Expected Output: 13
    }
}