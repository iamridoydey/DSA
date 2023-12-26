package Maths;

public class LengthOfDigits {
    public static void main(String[] args) {
        int ans = bitLength(100, 10);
        System.out.println(ans);
    }

    public static int bitLength(int n, int b){
        return (int) (Math.log(n) / Math.log(b)) + 1;
    }
}
