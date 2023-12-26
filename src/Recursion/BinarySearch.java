package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 8, 10, 13, 14, 21, 29};
        int index = binarySearch(nums, 50, 0, nums.length - 1);
        System.out.println(index);
    }


    static int binarySearch(int[] nums, int target, int start, int end){
        int mid = start + (end - start) / 2;

        // If the array doesn't contain this value then return -1
        // Because then start become greater than end
        if (start > end){
            return -1;
        }

        if (nums[mid] == target){
            return mid;
        } else if (nums[mid] < target){
            return binarySearch(nums, target, mid + 1, end);
        }

        return binarySearch(nums, target, start, mid - 1);


    }
}
