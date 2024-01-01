package Recursion.Sorting;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        // Base condition
        if (end == start){
            return;
        }

        int mid = start + (end - start) / 2;

        // left side
        sort(arr, start, mid);

        //right side
        sort(arr, mid + 1, end);

        // merge this two array
        merged(arr, start, mid, mid + 1, end);
    }

    private static void merged(int[] arr, int lS, int lE, int rS, int rE) {
        int[] ans = new int[lE - lS + rE - rS + 2];
        int i = lS;
        int j = rS;
        int k = 0;
        while (i <= lE && j <= rE){
            if (arr[i] <= arr[j]){
                ans[k++] = arr[i++];
            } else {
                ans[k++] = arr[j++];
            }
        }

        // Remaining from one of those will be included
        while (i <= lE){
            ans[k++] = arr[i++];
        }

        while(j <= rE){
            ans[k++] = arr[j++];
        }

        // now place the ans array to the original array which need to be sort
        for (int l = 0; l < k; l++) {
            arr[lS + l] = ans[l];
        }
    }

}
