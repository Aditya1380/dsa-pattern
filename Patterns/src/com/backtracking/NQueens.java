package com.backtracking;

import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        // Initialize empty board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Sets to track occupied columns and diagonals in O(1)
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>(); // (row + col)
        Set<Integer> negDiag = new HashSet<>(); // (row - col)

        backtrack(0, n, board, cols, posDiag, negDiag, result);
        return result;
    }

    private static void backtrack(int row, int n, char[][] board, 
                                  Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, 
                                  List<List<String>> result) {
        // Step 1: Base Case - All n queens are placed
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        // Step 2: Try placing queen in every column for the current row
        for (int col = 0; col < n; col++) {
            int pDiag = row + col;
            int nDiag = row - col;

            // Pruning: Check if column or diagonals are under attack
            if (cols.contains(col) || posDiag.contains(pDiag) || negDiag.contains(nDiag)) {
                continue;
            }

            // STEP A: MAKE CHOICE
            cols.add(col);
            posDiag.add(pDiag);
            negDiag.add(nDiag);
            board[row][col] = 'Q';

            // STEP B: RECURSE to next row
            backtrack(row + 1, n, board, cols, posDiag, negDiag, result);

            // STEP C: UNDO CHOICE (Backtrack!)
            cols.remove(col);
            posDiag.remove(pDiag);
            negDiag.remove(nDiag);
            board[row][col] = '.';
        }
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("Total solutions for " + n + "-Queens: " + solutions.size());
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}