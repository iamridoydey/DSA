package Maths;

public class NumberOfSetBits {
    public static void main(String[] args) {
        int n = 21;
        int setBits = numOfSetBits(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setBits);
    }

    public static int numOfSetBits(int num) {
        int count = 0;
        while (num != 0){
            num &= (num - 1);
            count++;
        }

        return count;
    }
}
