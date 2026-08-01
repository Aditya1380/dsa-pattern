package com.backtracking;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Scan grid for starting matching character
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (backtrack(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // Step 2: Base Case - Entire word has been matched!
        if (index == word.length()) {
            return true;
        }

        // Step 3: Out of bounds check OR character mismatch check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // STEP A: MAKE CHOICE (Mark cell as visited in-place)
        char temp = board[r][c];
        board[r][c] = '#';

        // STEP B: RECURSE in 4 directions (Up, Down, Left, Right)
        boolean found = backtrack(board, word, r - 1, c, index + 1) || // Up
                        backtrack(board, word, r + 1, c, index + 1) || // Down
                        backtrack(board, word, r, c - 1, index + 1) || // Left
                        backtrack(board, word, r, c + 1, index + 1);   // Right

        // STEP C: UNDO CHOICE (Backtrack! Restore original character)
        board[r][c] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println("Word 'ABCCED' exists? " + exist(board, "ABCCED")); // true
        System.out.println("Word 'ABCB' exists? " + exist(board, "ABCB"));     // false
    }
}