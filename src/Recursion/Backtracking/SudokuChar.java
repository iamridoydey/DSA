package Recursion.Backtracking;

public class SudokuChar {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);
        for (char[] row : board){
            for (char col : row){
                System.out.print(col + " ");
            }

            System.out.println();
        }

        System.out.println();
    }


    public static void solveSudoku(char[][] board) {
        sudokuSolve(board);
    }

    public static boolean sudokuSolve(char[][] board){
        int row = -1;
        int col = -1;

        // Find the grid with zero as value
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.'){
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
            char num = (char) (i + 48);
            if (isSafe(board, row, col, num)){
                board[row][col] = num;
                // If the sudoku is solved then return true from here. Otherwise backtrack
                if (sudokuSolve(board)){
                    return true;
                }

                board[row][col] = '.';

            }
        }


        return false;
    }



    public static boolean isSafe(char[][] board, int row, int col, char num) {
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
