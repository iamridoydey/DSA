package Recursion.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {11, 2, 3, 9, 15, 21, 8, 5, 10}; // 2, 3, 5, 8, 9, 10, 11, 15, 21
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[]arr, int low, int high){
        // Base Condition
        if (low >= high){
            return;
        }
        int s = low;
        int e = high;
        // Calculate the mid
        int m = s + (e - s) / 2;
        // Pivot
        int p = arr[m];

        while (s < e){
            while (arr[s] < p){
                s++;
            }

            while (arr[e] > p){
                e--;
            }

            if (s != e){
                // swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
            }
        }

        sort(arr, low, e - 1);
        sort(arr, e + 1, high);

    }
}
