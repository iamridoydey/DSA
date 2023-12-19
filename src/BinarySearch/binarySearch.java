package BinarySearch;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 9, 12, 13, 18, 20, 21, 29};
        int ans = BS(nums, 9);
        System.out.println(ans);
    }

    static int BS(int[] nums, int target){
        // set the start and end first
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
