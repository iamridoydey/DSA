package Maths;

public class FindRightMostSetBit {
    public static void main(String[] args) {
        // Find it for 50 = (110010)2, 200 = (11001000)2
        int ans = FindRightSetBit(200);
        System.out.println(ans);
    }



    static int FindRightSetBit(int num) {
        int i = 0;
        while (num != 0){
            if ((num & 1) == 1){
                return i;
            }

            i++;
            num >>= 1;
        }

        return i;
    }
}
