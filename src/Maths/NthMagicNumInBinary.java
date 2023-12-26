package Maths;
// Formula for it :
// if the number is 100 then the ans should be 0*5^1 + 0*5^2 + 1^5^3
public class NthMagicNumInBinary {
    public static void main(String[] args) {
        int ans = magicNumber(3);
        System.out.println(ans);
    }

    static int magicNumber(int number) {
        int i = 1;
        int magicNum = 0;
        while (number != 0){
            magicNum += (number & 1) * (int) Math.pow(5, i);
            i++;
            number >>>= 1;
        }

        return magicNum;
    }
}
