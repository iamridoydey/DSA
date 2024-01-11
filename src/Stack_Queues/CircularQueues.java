package Stack_Queues;

public class CircularQueues {
    private static final int DEFAULT_SIZE = 10;
    protected int[] data;
    private int start = 0;
    private int end = 0;

    public CircularQueues(){
        this(DEFAULT_SIZE);
    }

    public CircularQueues(int size){
        this.data = new int[size];
    }

    public void push(int value){
        if (isFull()){
            int[] temp = new int[data.length * 2];
            // Copy all the element from data to temp
            for (int i = start; i < end; i++) {
                temp[i] = data[i % data.length];
            }

            data = temp;
        }

        // Add the element to the array
        data[end % data.length] = value;
        end++;
    }


    // Pop
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Can't pop out from empty queues!");
        }

        int val = data[start % data.length];
        start++;
        return val;
    }

    // Front element
    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }

        return data[start % data.length];
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }

        return data[end % data.length - 1];
    }

    // Display
    public void display(){
        for (int i = start; i < end; i++) {
            System.out.print(data[i % data.length] + " ");
        }

        System.out.println();
    }

    private boolean isFull() {
        return end - start == data.length;
    }

    private boolean isEmpty(){
        return end - start == 0;
    }

}
