package Permutation;

import java.util.ArrayList;

public class StringPermutation {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> ans = permutation(new ArrayList<>(), "", str);
        System.out.println(ans);
    }

    public static ArrayList<String> permutation(ArrayList<String> list, String p, String up){
        if (up.length() == 0){
            list.add(p);
            return list;
        }

        int N = p.length() + 1;
        for (int i = 0; i < N; i++) {
            String processed = p.substring(0, i) + up.charAt(0) + p.substring(i);
            String unProcessed = up.substring(1);
            permutation(list, processed, unProcessed);
        }
        return list;
    }
}
