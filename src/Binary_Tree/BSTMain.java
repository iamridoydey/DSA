package Binary_Tree;

public class BSTMain {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {9, 7, 12, 3, 8, 11, 15};
        int[] sortedArr = {3, 5, 9, 12, 21, 29};
        tree.populate(arr);
//        tree.sortedPopulate(sortedArr);
//        tree.display();
        tree.postOrderTraversal();
    }
}
