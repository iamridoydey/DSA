package LinkedList;

// Doubly Linked List
public class DLL {
    private Node head;
    private int size;

    public DLL(){
        this.size = 0;
    }

    // Insert At First
    public void insertAtFirst(int value){
        Node node = new Node(value);
        size++;
        if (head == null){
            head = node;
            node.previous = null;
            node.next = null;
            return;
        }

        node.next = head;
        head.previous = node;
        node.previous = null;
        head = node;

    }

    // Insert At Last
    public void insertAtLast(int value){
        if (head == null){
            insertAtFirst(value);
            return;
        }

        // Get the last node of the linked list
        Node prev = head;
        while (prev.next != null){
            prev = prev.next;
        }

        Node node = new Node(value);
        prev.next = node;
        node.previous = prev;
        node.next = null;
        size++;
    }

    // Insert at index
    public void insert(int value, int index) throws Exception {
        if (index > size){
            throw new Exception("Not a valid index!");
        }
        if (index == 0){
            insertAtFirst(value);
            return;
        }

        if (index == size){
            insertAtLast(value);
            return;
        }

        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(value);
        node.next = prev.next;
        node.previous = prev;
        prev.next.previous = node;
        prev.next = node;
        size++;
    }


    // Deletion
    public void deleteAtFirst(){
        if (head == null){
            return;
        }

        size--;
        if (size == 1){
            head = null;
            return;
        }

        head = head.next;
        head.previous = null;

    }

    // Delete At Last
    public void deleteAtLast(){
        if (size == 1 || head == null){
            deleteAtFirst();
            return;
        }

        Node prev = head;
        for (int i = 1; i < size - 1; i++) {
            prev = prev.next;
        }

        prev.next = null;
        size--;
    }

    // Delete at index
    public void delete(int index) throws Exception{
        if (index >= size){
            throw new Exception("Not a valid index!");
        }

        if (index == 0){
            deleteAtFirst();
            return;
        }

        if (index == size - 1){
            deleteAtLast();
            return;
        }

        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        if (prev.next.next != null){
            prev.next.next.previous = prev;
        }

        size--;
    }

    // Delete a particular number from list
    public void deleteItem(int value) throws Exception {
        int index = findIndex(value);
        if (index == -1){
            System.out.println("Number not found in the list!");
        }
        delete(index);
    }


    // FindIndex
    public int findIndex(int value){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if (temp.value == value){
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    // Display The linked list
    public void display(){
        if(head == null){
            System.out.println("Linked List Is Empty");
            return;
        }

        Node temp = head;
        while (temp.next != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print(temp.value + " -> ");
        System.out.println("END");


        // Reverse Display
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.previous;

        } while (temp != null);
        System.out.println("START");


    }
    private class Node{
        int value;
        Node next;
        Node previous;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next, Node previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
