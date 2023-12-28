package Recursion.Level_1;

public class PrintRangeOfNumber {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n){
        if (n < 1){
            return;
        }

        print(n - 1);
        System.out.println(n);
    }
}
