package Recursion.Backtracking;

public class MazeAllDirectionPaths {
    public static void main(String[] args) {
        boolean[][] paths = {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };
        int numOfPath = printAllDirectionPaths("", paths, 0, 0);
        System.out.println(numOfPath);
    }
    public static int printAllPaths(String up, boolean[][] paths, int r, int c){
        if (r == paths.length - 1 && c == paths[0].length - 1){
            System.out.println(up);
            return 1;
        }

        // If the path is used then stop here. Because can't use the same path twice in a way.
        if (!paths[r][c]){
            return 0;
        }

        int sum = 0;
        // Move Up
        if (r > 0){
            paths[r][c] = false;
            sum += printAllPaths(up + 'U', paths, r - 1, c);
            paths[r][c] = true;
        }

        // Move down
        if (r < paths.length - 1){
            paths[r][c] = false;
            sum += printAllPaths(up + 'D', paths, r + 1, c);
            paths[r][c] = true;
        }

        // Move to the right
        if (c < paths[0].length - 1){
            paths[r][c] = false;
            sum += printAllPaths(up + 'R', paths, r, c + 1);
            paths[r][c] = true;
        }

        // Move to the left
        if (c > 0){
            paths[r][c] = false;
            sum += printAllPaths(up + 'L', paths, r, c - 1);
            paths[r][c] = true;
        }



        return sum;
    }



    public static int printAllDirectionPaths(String up, boolean[][] paths, int r, int c){
        if (r == paths.length - 1 && c == paths[0].length - 1){
            System.out.println(up);
            int i = 1;
            paths[r][c] = false;
            for(boolean[] path : paths){
                for(boolean p: path){
                    if (!p){
                        System.out.print(i + "  ");
                        i++;
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            paths[r][c] = true;
            return 1;
        }

        // If the path is used then stop here. Because can't use the same path twice in a way.
        if (!paths[r][c]){
            return 0;
        }

        int sum = 0;

        // Let's assume it is in my path then set it false
        paths[r][c] = false;
        // Move Up
        if (r > 0){
            sum += printAllDirectionPaths(up + 'U', paths, r - 1, c);
        }

        // Move down
        if (r < paths.length - 1){
            sum += printAllDirectionPaths(up + 'D', paths, r + 1, c);
        }

        // Move to the right
        if (c < paths[0].length - 1){
            sum += printAllDirectionPaths(up + 'R', paths, r, c + 1);
        }

        // Move to the left
        if (c > 0){
            sum += printAllDirectionPaths(up + 'L', paths, r, c - 1);
        }

        paths[r][c] = true;

        return sum;
    }

}
