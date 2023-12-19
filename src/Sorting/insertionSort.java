package Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {5, 3, 2, 4, 1};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    static void insertionSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            // Inner loop
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]){
                    // If the j th num is smaller than j-1 th num then swap them
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                } else {
                    // If the previous element is smaller than the current
                    // that mean that part of array is sorted. So break the loop.
                    break;
                }
            }
        }
    }
}
