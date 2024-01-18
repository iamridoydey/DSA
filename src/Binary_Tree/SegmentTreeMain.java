package Binary_Tree;

public class SegmentTreeMain {
    public static void main(String[] args) {
        int[] arr = {8, 3, 2, 5, -3, 1, 7, -9};
        SegmentTree tree = new SegmentTree(arr);
//        tree.display();
        tree.update(5, 2);
        System.out.println(tree.query(0, arr.length - 1));
    }
}
