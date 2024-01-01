package Recursion.Level_3;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 11, 9, 0, 10, 8, 1, 3, 2, 4};
        sort(arr, 0,arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int max, int r, int c){
        if (r == 0){
            return;
        }

//        // Get the max element index;
//        int m = max(arr, 0, e, 0);
        int m = arr[max] < arr[c] ? c : max;

        // When r == c then we will get the max index
        if (r == c){
            // Swap the element with its correct index
            int temp = arr[m];
            arr[m] = arr[c];
            arr[c] = temp;

            // next pass
            sort(arr, 0, --r, 0);
        } else{
            sort(arr, m, r, ++c);
        }


    }


//    public static int max(int[] arr, int s, int e, int max){
//        if (s == e){
//            return max;
//        }
//
//        if(arr[max] < arr[s]){
//            max = s;
//        }
//
//        return max(arr, s + 1, e, max);
//    }
}

