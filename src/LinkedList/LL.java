package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    int size;
    public LL(){
        this.size = 0;
    }

    public int findIndex(int val){
        Node temp = head;
        int i = 0;
        while (temp != null){
            if (temp.value == val){
                return i;
            }

            temp = temp.next;
            i++;
        }

        return -1;
    }
    // Insert at first
    public void insertAtFirst(int value){
        Node node = new Node(value);
        if (head == null){
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head = node;
        size++;
    }

    // Insert At Last
    public void insertAtLast(int value){
        if (tail == null){
            insertAtFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int index, int value) throws Exception {
        if (index == 0){
            insertAtFirst(value);
            return;
        }

        if (index == size){
            insertAtLast(value);
            return;
        }

        if (index > size){
            throw new Exception("Not a valid index!");
        }

        Node node = new Node(value);
        Node prev = head;
        // get to the previous index where the node should be inserted
        for (int i = 1; i < 3; i++) {
            prev = prev.next;
        }

        node.next = prev.next;
        prev.next = node;
        size++;
    }


    // Display The Linked List
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("END");
        System.out.println();
    }

    // DELETE
    // Delete at first
    public int deleteAtFirst(){
        if (head != null){
            int val = head.value;
            head = head.next;
            return val;
        }

        return -1;
    }

    // Delete at first
    public int deleteAtLast(){
        if (tail == null){
            return -1;
        }

        if (head == tail){
            int val = head.value;
            head = null;
            tail = null;
            return val;
        }

        Node prev = head;
        while(prev.next.next != null){
            prev = prev.next;
        }

        int val = prev.next.value;
        prev.next = null;
        tail = prev;

        return val;
    }

    // Delete At Index
    public int deleteAtIndex(int index){
        if (head == null){
            return -1;
        }

        if (index == 0){
            int val = head.value;
            deleteAtFirst();
            return val;
        }

        if (index == size - 1){
            int val = tail.value;
            deleteAtLast();
            return val;
        }


        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }
}
