package Recursion.Level_1;

public class SumOfRangeOfN {
    public static void main(String[] args) {
        int s = sum(5);
        System.out.println(s);
    }

    public static int sum(int N){
        if (N < 1){
            return N;
        }

        return N + sum(--N);
    }
}
