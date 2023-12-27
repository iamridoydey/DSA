package Maths;

import java.util.Arrays;

class MaximumXor {
    public static void main(String[] args) {
        int[] nums = {536870912, 0, 534710168, 330218644, 142254206};
        int[][] queries = {
                {558240772, 1000000000},
                {307628050, 1000000000},
                {3319300, 1000000000},
                {2751604, 683297522},
                {214004, 404207941}
        };
        int[] ans = maximizeXor(nums, queries);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];

        // Sort the nums array
        Arrays.sort(nums);

        for (int i = 4; i < queries.length; i++){
            // Select Xi
            int a = queries[i][0];

            // Select Mi
            int delimeter = queries[i][1];

            // Find the index of the number or immediate min number index
            int index = binarySearch(nums, delimeter);

            // But if the index is -1 then set the value of ans[i] == index and continue
            if (index == -1){
                ans[i] = -1;
                continue;
            }

            // Run a loop till this index
            for(int j = 0; j <= index; j++){
                int b = nums[j];

                // Get the xor of a and b
                int xor = a ^ b;

                // Check if the ans in ith index is less than xor or not? If it is then set the xor 
                // value as this value
                if (ans[i] < xor) ans[i] = xor;
            }

        }


        return ans;
        
    }


    // Binary Search 
    public static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        // If the number is smaller than the first number in array
        // then return -1 but if the number is bigger than the last element then return last index
        if (target < nums[0]){
            return -1;
        } if (target > nums[end]){
            return end;
        }

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target){
                return mid;

            } else if (nums[mid] < target){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        // If the index not found for the number I will return start. Because It contain imemdiate min 
        //number than the target.
        return end;
    }
}

// Not work well time limit exceeds