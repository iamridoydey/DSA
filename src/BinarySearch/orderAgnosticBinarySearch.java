package BinarySearch;

public class orderAgnosticBinarySearch {
    public static void main(String[] args) {
//        int[] nums = {1, 5, 7, 9, 12, 13, 18, 20, 21, 29};
        int[] nums = {29, 21, 20, 18, 13, 12, 9, 7, 5, 1};
        int ans = orderAgnosticBS(nums, 9);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        boolean isAsc = nums[start] < nums[end];
        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target){
                return mid;
            }

            // Check whether nums is in asc or in dec order
            if (isAsc){
                if (nums[mid] < target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else{
                // If nums is a desc order array then apply alter search
                if (nums[mid] < target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
