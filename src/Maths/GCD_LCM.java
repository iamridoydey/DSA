package Maths;

public class GCD_LCM {
    public static void main(String[] args) {
        int ans = lcm(3, 6);
        System.out.println(ans);
    }

    public static int gcd(int a, int b){
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}
