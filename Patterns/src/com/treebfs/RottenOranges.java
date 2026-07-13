package com.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        System.out.println("Minutes until all rot: " + orangesRotting(grid)); // Expected Output: 4
    }

    private static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // ---------- STEP 1: initial scan ----------
        // Push every rotten orange's position into the queue (these are minute-0 sources).
        // Count total fresh oranges so we know when we're "done".
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // Edge case: nothing was ever fresh, so 0 minutes needed.
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        int[] dr = {-1, 1, 0, 0}; // up, down, left, right (row deltas)
        int[] dc = {0, 0, -1, 1}; // matching column deltas

        // ---------- STEP 2: level-by-level BFS ----------
        // Each full pass of the while loop = exactly one minute.
        while (!queue.isEmpty() && freshCount > 0) {

            // Snapshot how many cells are rotten AT THE START of this minute.
            // This is the key trick: without it, cells rotted during this pass
            // would get processed in the SAME pass, collapsing minute 1 and 2 together.
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                // Check all 4 neighbors of this rotten cell
                for (int dir = 0; dir < 4; dir++) {
                    int newR = r + dr[dir];
                    int newC = c + dc[dir];

                    // Bounds check
                    if (newR < 0 || newR >= rows || newC < 0 || newC >= cols) {
                        continue;
                    }

                    // Only care about fresh oranges
                    if (grid[newR][newC] != 1) {
                        continue;
                    }

                    // Rot it, track it, queue it for the NEXT minute's pass
                    grid[newR][newC] = 2;
                    freshCount--;
                    queue.add(new int[]{newR, newC});
                }
            }

            // We just finished processing one full "ring" of rotten oranges = one minute passed.
            // This sits OUTSIDE the for loop on purpose — one increment per minute, not per cell.
            minutes++;
        }

        // ---------- STEP 3: final check ----------
        // If any fresh oranges are still left, some were unreachable -> impossible.
        return freshCount == 0 ? minutes : -1;
    }
}