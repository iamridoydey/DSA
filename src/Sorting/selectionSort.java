package Sorting;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {5, 3, 2, 4, 1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            int end = nums.length - 1 - i;

            // Find the max element in range
            int maxIndex = max(nums, start, end);

            // Swap the value of the end position to the range with the current max
            swap(nums, maxIndex, end);
        }
    }

    static void swap(int[] nums, int maxIndex, int end) {
        int temp = nums[maxIndex];
        nums[maxIndex] = nums[end];
        nums[end] = temp;
    }

    static int max(int[] nums, int start, int end){
        int max = start;

        for (int i = start + 1; i <= end; i++) {
            if (nums[max] < nums[i]){
                max = i;
            }
        }

        return max;
    }

}
