package Maths;

public class PowerOfTwo {
    public static void main(String[] args) {
        boolean isPow = isPowerOfTwo(25);
        System.out.println(isPow);
    }

    public static boolean isPowerOfTwo(int number){
        if (number < 1){
            return false;
        }
        int N = bitsLength(number);
        return (number ^ (1 << (N - 1))) == 0;
    }

    public static int bitsLength(int N){
        return (int) (Math.log(N) / Math.log(2)) + 1;
    }
}
