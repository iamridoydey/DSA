package Maths;

public class FindIthBit {
    public static void main(String[] args) {
        int bit = getBit2(21, 2);
        System.out.println(bit);
    }

    private static int getBit(int num, int ith) {
        return (num >> (ith - 1)) & 1;
    }

    private static int getBit2(int num, int ith) {
        return num & (1 << (ith - 1));
    }
}
