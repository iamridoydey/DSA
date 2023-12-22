package Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 1, 2};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void cyclicSort(int[] nums){
        int i = 0;
        while (i < nums.length){
            if (nums[i] != i + 1){
                // If the number at the i is not equal to i + 1 then swap it with correct index
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
    }
}
