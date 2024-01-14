package Binary_Tree;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    public BinaryTree(){
    }

    // Insert on binary tree
    public void populate(Scanner scanner){
        System.out.print("What's the root ?" );
        int userInput = scanner.nextInt();
        // Create the root node
        Node node = new Node(userInput);
        root = node;
        populate(node, scanner);
    }

    public void populate(Node root, Scanner scanner){
        System.out.print("Would you like to add a node on the left side of " + root.value + " ? ");
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.print("Enter the value of " + root.value + " left: ");
            int value = scanner.nextInt();
            // Create the left node
            root.left = new Node(value);
            populate(root.left, scanner);
        }


        System.out.print("Would you like to add a node on the right side of " + root.value + " ? ");
        boolean right = scanner.nextBoolean();
        if (right){
            System.out.print("Enter the value of " + root.value + " right: ");
            int value = scanner.nextInt();
            // Create the right node
            root.right = new Node(value);
            populate(root.right, scanner);
        }
    }

    // Display
    public void display(){
        display(this.root, "");
    }

    public void display(Node root, String indent){
        if (root == null){
            return;
        }
        System.out.println(indent + root.value);
        display(root.left, indent + "\t");
        display(root.right, indent + "\t");
    }

    // Pretty Display
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    public void prettyDisplay(Node root, int level){
        if (root == null){
            return;
        }

        // Print right value of the node
        prettyDisplay(root.right, level + 1);

        if (level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t\t");
            }

            System.out.println("|---------->" + root.value);
        } else {
            System.out.println(root.value);
        }

        // Print right value of the node
        prettyDisplay(root.left, level + 1);
    }

    private class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
}
