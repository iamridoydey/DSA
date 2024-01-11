package Stack_Queues;

public class CQMain {
    public static void main(String[] args) throws Exception {
        CircularQueues queues = new CircularQueues();
        queues.push(2);
        queues.push(5);
        queues.push(7);
        queues.push(11);
        queues.push(8);
        queues.display();
        queues.pop();
        queues.push(13);
        queues.display();
        System.out.println(queues.peek());
        System.out.println(queues.front());
    }
}
