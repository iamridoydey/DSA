package Maths;

public class XORInRange {
    public static void main(String[] args) {
        int n = 5;
        int xor = xorTillNumber(n);
        int xorValue = xorInRange(3 ,9);

//        System.out.println(xor);

        System.out.println(xorValue);
    }

    public static int xorInRange(int a, int b) {
        return xorTillNumber(b) ^ xorTillNumber(a - 1);
    }


    public static int xorTillNumber(int n){
        if (n % 4 == 0){
            return n;
        } else if(n % 4 == 1){
            return 1;
        } else if (n % 4 == 2){
            return n + 1;
        }

        return 0;
    }
}
