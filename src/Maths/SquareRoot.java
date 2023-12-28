package Maths;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 40;
        double actual = Math.sqrt(n);
        double ans1 = sqrt1(n, 10);
        double ans2 = sqrt2(n);
        System.out.println(actual);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    // Square root of a number using binary search techniques
    public static double sqrt1(int number, int precision){
        int start = 0;
        int end = number;
        double root = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (mid * mid == number){
                root = number;
                break;
            } else if (mid * mid < number){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // If it is not correct root then end will have the integer ans
        root = end;

        // Get the additional value after decimal point
        double point = 0.1;
        for (int i = 0; i <= precision; i++) {
            while (root * root <= number){
                root += point;
            }

            // Decrease root by point because when root * root is bigger number
            // then while loop will stop. So to get the exact root subtract point from root
            root -= point;
            point /= 10;
        }

        return root;
    }


    // Newton Raphson Method
    public static double sqrt2(double n){
        double x = n;
        double root = 0.0;
        while(true){
           root = .5 * (x + (n / x));

           // Check for the error
           if (Math.abs(root - x) < .1){
               break;
           }

           x = root;
        }

        return root;
    }
}
