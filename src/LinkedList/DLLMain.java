package LinkedList;

public class DLLMain {
    public static void main(String[] args) throws Exception{
        DLL list = new DLL();
        list.insertAtFirst(15);
        list.insertAtFirst(9);
        list.insertAtFirst(2);
        list.insertAtFirst(5);
        list.insertAtFirst(3);
        list.display();

        list.deleteItem(0);
        list.display();
    }
}
