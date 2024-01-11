package Stack_Queues;

public class Queues_Main {
    public static void main(String[] args) throws Exception {
        Queues queues = new Queues(5);
        queues.push(2);
        queues.push(5);
        queues.push(7);
        queues.push(11);
        queues.push(8);
        queues.push(15);
        queues.display();
        queues.pop();
        queues.display();
        System.out.println(queues.peek());
        System.out.println(queues.front());
    }
}
