package Recursion.Backtracking;

public class MazeProblem {
    public static void main(String[] args) {
        int paths = numsOfPaths(3, 3);
//        System.out.println(paths);
        boolean[][] path = new boolean[3][3];
        printAllPaths(path, 0, 0);
    }


    public static int numsOfPaths(int r, int c){
        if (r == 1 || c == 1){
            return 1;
        }

        int left = numsOfPaths(r - 1, c);
        int right = numsOfPaths(r, c - 1);

        return left + right;
    }

    public static void printPaths(String up, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(up);
            return;
        }

        if (r > 1) {
            printPaths(up + 'D', r - 1, c);
        }

        if (c > 1) {
            printPaths(up + 'R', r, c - 1);
        }
    }

    public static void printAllPaths(boolean[][] paths, int r, int c){
        if (r == paths.length - 1 && c == paths[0].length - 1){
            paths[r][c] = true;
            int i = 1;
            for(boolean[] path : paths){
                for(boolean p : path){
                    if (p){
                        System.out.print(i + " ");
                        i++;
                    } else {
                        System.out.print("X" + " ");
                    }
                }
                System.out.println();
            }

            System.out.println();
            paths[r][c] = false;
            return;
        }

        if (r < paths.length - 1){
            paths[r][c] = true;
            printAllPaths(paths, r + 1, c);
            paths[r][c] = false;
        }

        if (c < paths[0].length - 1){
            paths[r][c] = true;
            printAllPaths(paths, r, c + 1);
            paths[r][c] = false;
        }

    }
}
