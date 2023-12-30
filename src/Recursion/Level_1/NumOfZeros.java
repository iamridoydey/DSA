package Recursion.Level_1;

public class NumOfZeros {
    public static void main(String[] args) {
        int ans = zeros(2503007);
        System.out.println(ans);
    }

    public static int zeros(int n){
        return helper(0, n);
    }


    public static int helper(int count, int n){
        if (n == 0){
            return count;
        }

        if(n % 10 == 0){
            count++;
        }

        return helper(count, n / 10);
    }
}
