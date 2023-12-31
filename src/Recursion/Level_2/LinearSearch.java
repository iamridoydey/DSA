package Recursion.Level_2;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 2, 5, 9, 21, 18, 15};
        ArrayList<Integer> ans = findAllIndex(arr, 9, 0);
        System.out.println(ans);
    }

    public static int findIndex(int[] arr, int i, int target){
        if (i == arr.length){
            return -1;
        }

        if (arr[i] == target){
            return i;
        }

        return findIndex(arr, i + 1, target);
    }

    public static ArrayList<Integer> FindAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        if (arr.length == index){
            return list;
        }

        if (arr[index] == target){
            list.add(index);
        }

        return FindAllIndex(arr, target, index + 1, list);
    }


    public static ArrayList<Integer> findAllIndex(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length){
            return list;
        }

        if (target == arr[index]){
            list.add(index);
        }

        ArrayList<Integer> aboveAns = findAllIndex(arr, target, index + 1);
        list.addAll(aboveAns);
        return list;
    }
}
