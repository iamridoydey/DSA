package Binary_Tree;

public class BST {
    private Node root;
    public BST(){

    }

    public void insert(int value){
        root = insert(value, root);
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

        return root;
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
