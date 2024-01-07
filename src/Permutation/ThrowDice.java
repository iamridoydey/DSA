package Permutation;

import java.util.ArrayList;
import java.util.List;

public class ThrowDice {
    public static void main(String[] args) {
        List<String> list = diceInnerList("", 4);
        System.out.println(list);
        System.out.println(diceCount("", 4));
    }

    public static void dicePrint(String p, int up){
        if (up == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= up; i++) {
            dicePrint(p + String.valueOf(i), up - i);
        }
    }

    public static List<String> diceList(String p, int up, List<String> list){
        if (up == 0){
            list.add(p);
            return list;
        }

        for (int i = 1; i <= up; i++) {
            diceList(p + String.valueOf(i), up - i, list);
        }


        return list;
    }


    public static List<String> diceInnerList(String p, int up){
        if (up == 0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= up; i++) {
            list.addAll(diceInnerList(p + String.valueOf(i), up - i));
        }


        return list;
    }


    public static int diceCount(String p, int up){
        if (up == 0){
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= up; i++) {
            count += diceCount(p + String.valueOf(i), up - i);
        }

        return count;
    }
}
