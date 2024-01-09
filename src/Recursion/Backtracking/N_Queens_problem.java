package Recursion.Backtracking;

public class N_Queens_problem {
    public static void main(String[] args) {
        boolean[][] board = new boolean[6][6];
        nQueens(board, 0);
        int validBoard = numsOfValidBoard(board, 0);
        System.out.println(validBoard);
    }


    public static void nQueens(boolean[][] board, int r){
        if (r == board.length){
            display(board);
            System.out.println();
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(board, r, i)){
                board[r][i] = true;
                nQueens(board, r + 1);
                board[r][i] = false;
            }
        }
    }

    public static int numsOfValidBoard(boolean[][] board, int r){
        if (r == board.length){
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(board, r, i)){
                board[r][i] = true;
                sum += numsOfValidBoard(board, r + 1);
                board[r][i] = false;
            }
        }

        return sum;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        // Check the above position
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c]){
                return false;
            }
        }

        int leftN = Math.min(r, c);
        // Check the left diagonal
        for (int i = 1; i <= leftN; i++) {
            if (board[r - i][c - i]){
                return false;
            }
        }


        int rightN = Math.min(r, board[0].length - 1 - c);
        // Check the left diagonal
        for (int i = 1; i <= rightN; i++) {
            if (board[r - i][c + i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board){
            for (boolean grid : row){
                if (grid){
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }

            System.out.println();
        }
    }
}
