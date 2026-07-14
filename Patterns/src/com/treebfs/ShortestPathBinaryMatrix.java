package com.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Edge Case: If the start or the finish is blocked by a 1, it's impossible
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        // Add the start cell (row, col) to the line
        queue.add(new int[]{0, 0});
        
        // We track steps. The starting cell itself counts as step 1.
        int pathLength = 1;

        // Expanded 8-directional offset array (Up, Down, Left, Right + 4 Diagonals)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Cardinal directions
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // Diagonal directions
        };

        // Standard BFS Wave Engine
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Clear out the current step's layer wave completely
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                // EARLY TERMINATION: If we just pulled the bottom-right corner, we win!
                if (r == n - 1 && c == n - 1) {
                    return pathLength;
                }

                // Check all 8 neighbors
                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];

                    // Verify boundaries and ensure the neighbor cell is an unvisited CLEAR path (0)
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && grid[nextR][nextC] == 0) {
                        // Mark it as visited immediately by flipping it to 1 so no one else queues it
                        grid[nextR][nextC] = 1; 
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }
            
            // Increment the path step count as we step out to the next wave layer
            pathLength++;
        }

        return -1; // If the queue runs empty without hitting the exit corner
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };

        System.out.println("Shortest path length: " + shortestPathBinaryMatrix(grid)); // Expected Output: 4
    }
}