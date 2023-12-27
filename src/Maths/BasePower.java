package Maths;

public class BasePower {
    public static void main(String[] args) {
        int ans = power(4, 12);
        System.out.println(ans);
    }

    public static int power(int base, int pow){
        int ans = 1;
        while(pow != 0){
            if ((pow & 1) == 1){
                ans *= base;
            }
            pow >>= 1;
            base *= base;
        }

        return ans;
    }
}
