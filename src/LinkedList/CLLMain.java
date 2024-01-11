package LinkedList;

public class CLLMain {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(5);
        list.insert(2);
        list.insert(9);
        list.insert(7);
        list.insert(11);

        list.display();

        list.delete(9);
        list.display();
    }
}
