package Sorting;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void bubbleSort(int[] nums){

        for (int i = 0; i < nums.length; i++) {
            // Let's assume that it is sorted
            boolean isSorted = true;
            // After the end of this loop as pass max element for this
            // range will take place in the end of array
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j-1]){
                    // swap the value if the nums at j is smaller than nums at j-1
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    // If swap happen at least one time for this pass that means is not sorted
                    isSorted = false;
                }
            }

            // If it is sorted then just break the loop. Because it is already sorted
            if (isSorted){
                break;
            }
        }
    }
}
