package Stack_Queues;

public class Stack {
    private static final int DEFAULT_SIZE = 10;
    protected int[] data;
    private int index = -1;
    public Stack(){
        this(DEFAULT_SIZE);
    }

    public Stack(int size){
        this.data = new int[size];
    }

    public void push(int value){
        if (isFull()){
            int[] temp = new int[data.length * 2];
            // Copy all the element from data to temp
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }

        // Add the element to the array
        data[++index] = value;
    }


    // Pop
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Can't pop out from empty stack!");
        }

        int val = data[index];
        index--;
        return val;
    }

    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Can't return peek from empty stack!");
        }

        return data[index];
    }

    // Display
    public void display(){
        for (int i = 0; i <= index; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    private boolean isFull() {
        return index == data.length - 1;
    }

    private boolean isEmpty(){
        return index == -1;
    }

}
