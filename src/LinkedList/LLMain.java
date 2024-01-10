package LinkedList;

public class LLMain {
    public static void main(String[] args) throws Exception {
        LL list = new LL();
        list.insertAtFirst(3);
        list.insertAtFirst(2);
        list.insertAtFirst(5);
        list.insertAtFirst(21);
        list.insertAtFirst(9);
        list.insertAtFirst(15);
        list.display();
        System.out.println(list.findIndex(3));
    }
}
