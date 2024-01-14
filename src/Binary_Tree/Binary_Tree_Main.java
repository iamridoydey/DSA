package Binary_Tree;

import java.util.Scanner;

public class Binary_Tree_Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.populate(scanner);
        tree.display();
        tree.prettyDisplay();
    }
}
