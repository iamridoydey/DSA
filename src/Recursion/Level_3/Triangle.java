package Recursion.Level_3;

public class Triangle {
    public static void main(String[] args) {
        triangle2(4, 0);
    }

    public static void triangle(int r, int c){
        if (r == 0){
            return;
        }

        if (c < r){
            System.out.print("* ");
            triangle(r, ++c);
        } else {
            System.out.println();
            triangle(--r, 0);
        }
    }

    public static void triangle2(int r, int c){
        if (r == 0){
            return;
        }

        if (c < r){
            triangle2(r, ++c);
            System.out.print("* ");
        } else {
            triangle2(--r, 0);
            if (r != 0){
                System.out.println();
            }
        }
    }

}
