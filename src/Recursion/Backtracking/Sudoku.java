package Recursion.Backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] sudokuPuzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        boolean ans = sudokuSolve(sudokuPuzzle);
        if(ans){
            display(sudokuPuzzle);
        } else {
            System.out.println("Sudoku can't be solved.");
        }

    }

    public static boolean sudokuSolve(int[][] board){
        int row = -1;
        int col = -1;

        // Find the grid with zero as value
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0){
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (row == -1 && col == -1){
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)){
                board[row][col] = i;
                // If the sudoku is solved then return true from here. Otherwise backtrack
                if (sudokuSolve(board)){
                    return true;
                }

                board[row][col] = 0;

            }
        }


        return false;
    }


    public static void display(int[][] board){
        for (int[] row : board){
            for (int col : row){
                System.out.print(col + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check in the row
        for (int c = 0; c < board.length; c++) {
            if(board[row][c] == num){
                return false;
            }
        }


        // Check in the column
        for (int r = 0; r < board.length; r++) {
            if(board[r][col] == num){
                return false;
            }
        }


        // Check in the sqrt(n) * sqrt(n) grid for the particular number
        int grid = (int) Math.sqrt(board.length);
        int rowStart = row - row % grid;
        int colStart = col - col % grid;

        for (int i = rowStart; i < rowStart + grid; i++) {
            for (int j = colStart; j < colStart + grid; j++) {
                if (board[i][j] == num){
                    return false;
                }
            }
        }


        return true;
    }
}
