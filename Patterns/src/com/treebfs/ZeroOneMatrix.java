package com.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize our queue and mark "unvisited" nodes
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    // 0s are our multi-source roots. Put them in line!
                    queue.add(new int[]{r, c});
                } else {
                    // Mark 1s as -1 so we know they haven't been calculated yet
                    mat[r][c] = -1;
                }
            }
        }

        // Direction vectors for moving Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Continuous Multi-Source BFS Flow
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // Inspect all 4 neighbors
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                // Check boundaries and make sure the neighbor is UNVISITED (-1)
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && mat[nextR][nextC] == -1) {
                    // The neighbor's distance is exactly 1 step further than the current cell!
                    mat[nextR][nextC] = mat[r][c] + 1;
                    
                    // Add this newly calculated cell to the line so it can infect its neighbors
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);

        // Printing output matrix
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        /* Expected Output:
        0 0 0 
        0 1 0 
        1 2 1 
        */
    }
}