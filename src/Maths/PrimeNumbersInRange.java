package Maths;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        seiveOfEratosthenes(40);
    }


    public static void seiveOfEratosthenes(int len){
        boolean[] numbers = new boolean[len + 1];

        for (int i = 2; i * i < len + 1; i++) {
            if (!numbers[i]){
                for (int j = 2; j <= len / i; j++) {
                    if(!numbers[i * j]){
                        numbers[i * j] = true;
                    }
                }
            }
        }


        for (int i = 2; i < len + 1; i++) {
            if (!numbers[i]){
                System.out.print(i + " ");
            }
        }
    }
}
