package Maths;

public class PascalTriangle {
    public static void main(String[] args) {
        int sum = pascalRowSum(9);
        System.out.println(sum);
    }

    public static int pascalRowSum(int n) {
        return (1 << (n - 1));
    }
}
