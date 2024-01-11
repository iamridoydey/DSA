package Stack_Queues;

public class StackMain {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(5);
        stack.push(9);
        stack.push(21);
        stack.push(11);

        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
    }
}
