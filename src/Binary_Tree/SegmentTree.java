package Binary_Tree;

public class SegmentTree {
    private Node root;
    public SegmentTree(int[] arr){
        this.construct(arr);
    }

    public void construct(int[] arr){
        root = construct(arr, 0, arr.length - 1);
    }

    // sI = startInterval, eI = endInterval
    public Node construct(int[] arr, int sI, int eI){
        if (sI == eI){
            // Create leaf node
            Node node = new Node(arr[sI], sI, eI);
            return node;
        }

        // Create parent node for each call
        Node node = new Node(sI, eI);

        int mid = sI + (eI - sI) / 2;
        // Call the left node for the value
        node.left = construct(arr, sI, mid);

        // Call the right node for the value
        node.right = construct(arr, mid + 1, eI);

        node.value = node.left.value + node.right.value;

        return node;
    }

    // Update any value
    public void update(int index, int value){
        root.value = update(root, index, value);
    }

    private int update(Node node, int index, int value){
        if (index >= node.startInterval && index <= node.endInterval){

            if (node.startInterval == index && node.endInterval == index){
                node.value = value;
                return value;

            } else {
                return update(node.left, index, value) + update(node.right, index, value);
            }

        }

        return node.value;
    }


    public int query (int sq, int eq){
        return query(root, sq, eq);
    }

    // sq = start query, eq = end query
    private int query (Node node, int sq, int eq){
        // When the start and end query perfectly fall into the range of start and end interval
        if (node.startInterval >= sq && node.endInterval <= eq){
            // Completely overlapping
            return node.value;
        }else if (node.endInterval < sq || node.startInterval > eq){
            // Totally outside
            return 0;
        } else {
            return query(node.left, sq, eq) + query(node.right, sq, eq);
        }

    }


    public void display(){
        display(root);
    }

    private void display(Node node){
        if (node == null){
            return;
        }

        String str = "";
        // Print the left node's value and intervals
        if (node.left != null){
            str += "( Left Intervals : [" + node.left.startInterval + ", " + node.left.endInterval + "]" + " & value: " + node.left.value + " )";
        } else {
            str += "Don't have left node !";
        }

        str += " <= ( Root Intervals : [" + node.startInterval + ", " + node.endInterval + "]" + " & value: " + node.value + " ) => ";

        // Print the right node's value and intervals
        if (node.right != null){
            str += "( Right Intervals : [" + node.right.startInterval + ", " + node.right.endInterval + "]" + " & value: " + node.right.value + " )";
        } else {
            str += "Don't have right node !";
        }

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    private class Node{
        int value;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
        public Node(int value, int startInterval, int endInterval){
            this.value = value;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
}
