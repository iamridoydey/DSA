package LinkedList;

public class CLL {
    Node head;
    Node tail;
    int size;

    // Insertion
    public void insert(int value){
        Node node = new Node(value);
        size++;
        if (head == null){
            head = node;
            tail = node;
            head.next =tail;

            return;
        }

        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void delete(int value){
        if (head == null){
            System.out.println("Item doesn't exist!");
            return;
        }

        Node temp = head;
        int index = -1;
        do {
            index++;
            if (temp.value == value){
                break;
            }
            temp = temp.next;

        } while (temp != head);

        // When the value doesn't exist then the size of the array
        // and the length will be same but temp doesn't contain the value
        // or index will be -1
        if (temp.value != value || index == -1){
            System.out.println("Item doesn't exist!");
            return;
        }

        // But if the index is equal to 0 then move the head one step further
        if (index == 0){
            head = head.next;
            tail = head;
        }

        // Find the previous node
        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }


        prev.next = prev.next.next;
        if (prev.next == tail){
            tail = prev;
        }


    }

    // Display
    public void display(){
        if (size == 0){
            System.out.println("No element exist!");
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("END");

    }
    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
