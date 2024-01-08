package Recursion.Backtracking;

public class MazeWithObstacle {

    public static void main(String[] args) {
        boolean[][] paths = {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };

        int numOfPath = printAllPaths("", paths, 0, 0);
        System.out.println(numOfPath);
    }
    public static int printAllPaths(String up, boolean[][] paths, int r, int c){
        if (r == paths.length - 1 && c == paths[0].length - 1){
            System.out.println(up);
            return 1;
        }
        // Check for the obstacle (river)
        // If it is a river then should be true hence need to stop here
        if (!paths[r][c]){
            return 0;
        }

        int sum = 0;
        // Move diagonally
        if (r < paths[0].length - 1 && c < paths[0].length - 1){
            sum += printAllPaths(up + 'd', paths, r + 1, c + 1);
        }

        // Move to down
        if (r < paths.length - 1){
            sum += printAllPaths(up + 'D', paths, r + 1, c);
        }

        // Move to the right
        if (c < paths[0].length - 1){
            sum += printAllPaths(up + 'R', paths, r, c + 1);
        }

        return sum;
    }
}
