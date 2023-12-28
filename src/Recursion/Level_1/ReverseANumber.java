package Recursion.Level_1;

public class ReverseANumber {
    public static void main(String[] args) {
        int ans = reverse(0, 2536);
        System.out.println(ans);
    }

    public static int reverse(int ans, int num){
        if (num == 0){
            return ans;
        }

        return reverse(ans * 10 + num % 10, num / 10);
    }
}
