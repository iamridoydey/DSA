package Recursion.Level_2;

import java.util.Arrays;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5};
        boolean ans = isSorted(arr, 0);
        System.out.println(ans);
    }

    public static boolean isSorted(int[] arr, int i){
        if (i == arr.length - 1){
            return true;
        }

        return arr[i] < arr[i + 1] && isSorted(arr, i + 1);
    }
}
