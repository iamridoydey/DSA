package Maths;

public class PrimeNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + "  " + isPrime(i));
        }
    }

    public static boolean isPrime(int num){
        if (num <= 1){
            return false;
        }
        int i = 2;
        while (i * i <= num){
            if (num % i == 0){
                return false;
            }
            i++;
        }

        return true;
    }
}
