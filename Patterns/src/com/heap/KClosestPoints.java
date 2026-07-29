package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {

    public static int[][] kClosest(int[][] points, int k) {
        // Step 1: Create a Max-Heap using a custom comparator on squared distance (x^2 + y^2)
        // (b[0]^2 + b[1]^2) - (a[0]^2 + a[1]^2) sorts in DECREASING order (Max-Heap)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        // Step 2: Iterate through all points
        for (int[] point : points) {
            maxHeap.add(point);

            // Step 3: Keep max-heap size bounded to K
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Evict the farthest point
            }
        }

        // Step 4: Collect remaining K closest points into output array
        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}};
        int k = 1;

        int[][] result = kClosest(points, k);
        System.out.println("Closest points: " + Arrays.deepToString(result));
        // Expected Output: [[-2, 2]]
        // (-2)^2 + (2)^2 = 8, whereas 1^2 + 3^2 = 10 and 5^2 + 8^2 = 89
    }
}