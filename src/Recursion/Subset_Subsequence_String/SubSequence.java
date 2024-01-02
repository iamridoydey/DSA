package Recursion.Subset_Subsequence_String;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
//        set("", "abc");
        ArrayList<String> ans = subsequence(new ArrayList<>(), "", "abc");
        System.out.println(ans);
    }

    public static void set(String p, String up){
        if (up.length() == 0){
            System.out.print(p + " ");
            return;
        }

        set(p + up.charAt(0), up.substring(1));
        set(p, up.substring(1));
    }

    public static ArrayList<String> subsequence(ArrayList<String> list, String p, String up){
        if (up.length() == 0){
            list.add(p);
            return list;
        }

        subsequence(list, p + up.charAt(0), up.substring(1));
        subsequence(list, p, up.substring(1));

        return list;
    }
}
