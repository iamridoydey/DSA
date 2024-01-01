package Recursion.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        int[] ans = sort(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] sort(int[] arr){
        // Base condition
        if (arr.length == 1){
            return arr;
        }

        int s = 0;
        int e = arr.length;
        int m = s + (e - s) / 2;

        // Sort the left part of the array
        int[] left = sort(Arrays.copyOfRange(arr, s, m));
        int[] right = sort(Arrays.copyOfRange(arr, m, e));

        // merge this two array
        return merged(left, right);
    }

    private static int[] merged(int[] left, int[] right) {
        int leftN = left.length;
        int rightN = right.length;
        int[] ans = new int[leftN + rightN];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftN && j < rightN){
            if (left[i] <= right[j]){
                ans[k++] = left[i++];
            } else {
                ans[k++] = right[j++];
            }
        }

        // Remaining from one of those will be included
        while (i < leftN){
            ans[k++] = left[i++];
        }

        while(j < rightN){
            ans[k++] = right[j++];
        }

        return ans;
    }
}
