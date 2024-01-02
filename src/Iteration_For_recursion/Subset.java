package Iteration_For_recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = sets(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
        }

        System.out.println();
    }

    public static List<List<Integer>> sets(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num: arr) {
            int n = ans.size();

            for (int i = 0; i < n; i++) {
                // Create a copy of the list of ans
                List<Integer> copy = new ArrayList<>(ans.get(i));
                copy.add(num);
                ans.add(copy);
            }
        }

        return ans;
    }
}
