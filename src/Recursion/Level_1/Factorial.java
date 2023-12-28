package Recursion.Level_1;

public class Factorial {
    public static void main(String[] args) {
        int p = factor(6);
        System.out.println(p);
    }

    public static int factor(int n){
        if (n < 1){
            return 1;
        }
        return n * factor(n - 1);
    }
}
