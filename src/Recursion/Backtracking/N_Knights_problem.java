package Recursion.Backtracking;

public class N_Knights_problem {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        nKnights(board, 0, 0, n);
        int validBoard = numsOfValidBoard(board, 0, 0, n);
        System.out.println(validBoard);
    }



    public static void nKnights(boolean[][] board, int r, int c, int target){
        if (target == 0){
            display(board);
            System.out.println();
            return;
        }

        if (r == board.length - 1 && c == board[0].length){
            return;
        }

        if (c == board[0].length){
            nKnights(board, r + 1, 0, target);
            return;
        }

        if (isSafe(board, r, c)){
            board[r][c] = true;
            nKnights(board, r, c + 1, target - 1);
            board[r][c] = false;
        }

        nKnights(board, r, c + 1, target);
    }

    public static int numsOfValidBoard(boolean[][] board, int r, int c, int target){
        if (target == 0){
            return 1;
        }
        int sum = 0;

        if (r == board.length - 1 && c == board[0].length){
            return 0;
        }

        if (r == board.length){
            return 0;
        }

        if (c == board[0].length){
            sum += numsOfValidBoard(board, r + 1, 0, target);
            return sum;
        }



        if (isSafe(board, r, c)){
            board[r][c] = true;
            sum += numsOfValidBoard(board, r, c + 1, target - 1);
            board[r][c] = false;
        }

        sum += numsOfValidBoard(board, r, c + 1, target);

        return sum;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        // Check for the left side
        if (r - 1 >= 0 && c - 2 >= 0){
            if (board[r - 1][c - 2]){
                return false;
            }
        }

        // Check for the right side
        if (r - 1 >= 0 && c + 2 < board[0].length){
            if (board[r - 1][c + 2]){
                return false;
            }
        }

        // Check for the above left
        if (r - 2 >= 0 && c - 1 >= 0){
            if (board[r - 2][c - 1]){
                return false;
            }
        }

        // Check for the above right
        if (r - 2 >= 0 && c + 1 < board[0].length){
            if (board[r - 2][c + 1]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board){
            for (boolean grid : row){
                if (grid){
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }

            System.out.println();
        }
    }
}
