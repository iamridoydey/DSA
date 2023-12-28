package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FactorsOfNumber {
    public static void main(String[] args) {
        int[] ans = factors(36);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] factors(int n){
        ArrayList<Integer> ans = new ArrayList();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0){
                ans.add(i);
                if (i != n / i){
                    ans.add(n / i);
                }

            }
        }

        Collections.sort(ans);

        int[] all_factors = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            all_factors[i] = ans.get(i);
        }

        return all_factors;
    }
}
