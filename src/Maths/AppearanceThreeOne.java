package Maths;

public class AppearanceThreeOne {
    public static void main(String[] args) {
        int[] arr = {2, 2, 5, 2, 7, 7, 8, 7, 8, 8};
        int unique = uniqueNumber(arr);
        System.out.println(unique);
    }

    static int uniqueNumber(int[] arr) {
        int[] binaryBits = new int[8];
        for (int i = 0; i < arr.length; i++) {
            int c = 0;
            while (arr[i] != 0){
                if ((arr[i] & 1) == 1) {
                    binaryBits[c]++;
                }

                c++;
                arr[i] >>>= 1;
            }
        }

        int number = 0;
        for (int i = 0; i < binaryBits.length; i++) {
            number += (binaryBits[i] % 3) * (int)Math.pow(2, i);
        }

        return number;
    }
}
