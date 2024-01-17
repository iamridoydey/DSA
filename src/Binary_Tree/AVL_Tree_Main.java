package Binary_Tree;

public class AVL_Tree_Main {

    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 1; i <= 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}
