package Recursion.Level_2;

public class RBS {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int ans = binarySearch(arr, 3, 0, arr.length - 1);
        System.out.println(ans);
    }

    public static int binarySearch(int[] arr, int target, int s, int e){
        int m = s + (e - s) / 2;

        if (s > e){
            return -1;
        }

        if (arr[m] == target){
            return m;
        }

        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target < arr[m]) {
                return binarySearch(arr, target, s, m - 1);
            } else {
                return binarySearch(arr, target, m + 1, e);
            }

        }else if (arr[m] < target && target <= arr[e]){
            return binarySearch(arr, target, m + 1, e);
        }


        return binarySearch(arr, target, s, m - 1);
    }
}
