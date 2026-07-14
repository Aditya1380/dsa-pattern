package com.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Scan the matrix. Find all gates and load them as simultaneous starters
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        // Standard 4-directional offset trick: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Continuous Multi-Source BFS Flow
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                // Check boundaries AND verify if the target room is completely UNVISITED 
                // (We check if it equals Integer.MAX_VALUE)
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && rooms[nextR][nextC] == Integer.MAX_VALUE) {
                    // Update value in-place: current cell distance + 1
                    rooms[nextR][nextC] = rooms[r][c] + 1;
                    
                    // Line it up so it can broadcast to its neighbors
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
            {INF,  -1,   0, INF},
            {INF, INF, INF,  -1},
            {INF,  -1, INF,  -1},
            {  0,  -1, INF, INF}
        };

        wallsAndGates(rooms);

        // Printing results
        for (int[] row : rooms) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
        /* Expected Output:
          3  -1   0   1 
          2   2   1  -1 
          1  -1   2  -1 
          0  -1   3   4 
        */
    }
}