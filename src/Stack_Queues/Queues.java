package Stack_Queues;

public class Queues {
    private static final int DEFAULT_SIZE = 10;
    protected int[] data;
    private int start = 0;
    private int end = 0;

    public Queues(){
        this(DEFAULT_SIZE);
    }

    public Queues(int size){
        this.data = new int[size];
    }

    public void push(int value){
        if (isFull()){
            int[] temp = new int[data.length * 2];
            // Copy all the element from data to temp
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i + start];
            }

            data = temp;
        }

        // Add the element to the array
        data[end++] = value;
    }


    // Pop
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Can't pop out from empty queues!");
        }

        int val = data[start++];
        return val;
    }

    // Front element
    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }

        return data[start];
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }

        return data[end - 1];
    }

    // Display
    public void display(){
        for (int i = start; i < end; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    private boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty(){
        return end - start == 0;
    }
}
