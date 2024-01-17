package Binary_Tree;

public class AVL {
    private Node root;
    public AVL(){

    }


    // get the height of the root
    public int height(){
        return getHeight(root);
    }

    // Populate the tree
    public void populate(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    // Populate method for sorted array
    public void sortedPopulate(int[] arr){
        sortedPopulate(arr, 0, arr.length - 1);
    }

    public void sortedPopulate(int[] arr, int start, int end){
        if (start > end){
            return;
        }

        int mid = start + (end - start) / 2;

        insert(arr[mid]);

        // Left elements insertion
        sortedPopulate(arr, start, mid - 1);

        // Right elements insertion
        sortedPopulate(arr, mid + 1, end);

    }

    public void insert(int value){
        root = insert(value, root);
    }
    private Node insert(int value, Node root){
        if (root == null){
            Node node = new Node(value);
            return node;
        }

        if (root.value > value){
            root.left = insert(value, root.left);
        }

        if (root.value < value){
            root.right = insert(value, root.right);
        }


        // Set the height of node
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        return rotate(root);
    }

    public Node rotate(Node node){
        // If the height of the left tree greater than right tree then it is (LL or LR case)
        if (getHeight(node.left) - getHeight(node.right) > 1){
            // If it is left-left case then the height of grandchild node of the left should be greater
            // than the right grandchild node's height
            if (getHeight(node.left.left ) > getHeight(node.left.right)){
                return rightRotate(node);
            }

            // If it is left-right case then the height of grandchild node of the right should be greater
            // than the left grandchild node's height
            if (getHeight(node.left.left) < getHeight(node.left.right)){
                leftRotate(node.left);
                return rightRotate(node);
            }

        }

        // If the height of the right tree greater than left tree then it is (RR or RL case)
        if (getHeight(node.right) - getHeight(node.left ) > 1){
            // If it is right-right case then the height grandchild node of the right should be greater
            // than the left grandchild node's height
            if (getHeight(node.right.right) > getHeight(node.right.left)){
                return leftRotate(node);
            }

            // If it is right-left case then the height of grandchild node of the left should be greater
            // than the right grandchild node's height
            if (getHeight(node.right.right) < getHeight(node.right.left)){
                rightRotate(node.right);
                return leftRotate(node);
            }

        }

        return node;
    }

    private Node rightRotate(Node node) {
        Node c = node.left;
        Node t = c.right;
        c.right = node;
        node.left = t;

        // Change the height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return c;
    }

    private Node leftRotate(Node node) {
        Node p = node.right;
        Node t = p.left;
        p.left = node;
        node.right = t;

        // Change the height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;

        return p;
    }


    public void display(){
        display(root, "Root Node: ");
    }

    public void display(Node root, String message){
        if (root == null){
            return;
        }

        // Print the root first
        System.out.println(message + root.value);

        // Print the left node
        display(root.left, "Left Node Of " + root.value + " is ");

        // Print the right node
        display(root.right, "Right Node Of " + root.value + " is ");
    }

    // TRAVERSAL METHOD
    // Pre-Order Traversal
    public void preOrderTraversal(){
        preOrderTraversal(root, "Root Node: ");
    }

    private void preOrderTraversal(Node root, String msg) {
        if (root == null){
            return;
        }

        System.out.println(msg + root.value);
        preOrderTraversal(root.left, "Left Node Of " + root.value + " is : ");
        preOrderTraversal(root.right, "Right Node Of " + root.value + " is : ");
    }

    // In-Order Traversal
    public void inOrderTraversal(){
        inOrderTraversal(root, "Root Node: ");
    }

    private void inOrderTraversal(Node root, String msg) {
        if (root == null){
            return;
        }

        inOrderTraversal(root.left, "Left Node Of " + root.value + " is : ");
        System.out.println(msg + root.value);
        inOrderTraversal(root.right, "Right Node Of " + root.value + " is : ");
    }

    // Post-Order Traversal
    public void postOrderTraversal(){
        postOrderTraversal(root, "Root Node: ");
    }

    private void postOrderTraversal(Node root, String msg) {
        if (root == null){
            return;
        }

        postOrderTraversal(root.left, "Left Node Of " + root.value + " is : ");
        postOrderTraversal(root.right, "Right Node Of " + root.value + " is : ");
        System.out.println(msg + root.value);
    }

    private int getHeight(Node node){
        if (node == null){
            return -1;
        }

        return node.height;
    }

    // Is the tree balanced or not
    public boolean isBalanced(){
        return isBalanced(root);
    }

    public boolean isBalanced(Node root){
        if (root == null){
            return true;
        }

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // Is the tree empty?
    public boolean isEmpty(){
        return root == null;
    }

    private class Node{
        int value;
        Node left;
        Node right;
        int  height;

        private Node(int value){
            this.value = value;
        }
    }
}
