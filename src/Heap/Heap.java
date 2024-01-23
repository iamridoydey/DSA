package Heap;

public class Heap {
    private final int DEFAULT_SIZE = 10;
    private boolean isMinHeap;

    // Creating an array of heap.
    private int[] arr = new int[DEFAULT_SIZE];

    // Maintaining the original size of the array.
    private int size = 0;

    public Heap(){

    }

    public Heap(boolean isMinHeap){
        this.isMinHeap = isMinHeap;
    }

    public Heap(int size, boolean isMinHeap){
        this.arr = new int[size];
        this.isMinHeap = isMinHeap;
    }

    public Heap(int[] arr, boolean isMinHeap){
        this.isMinHeap = isMinHeap;
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    /*
    * Properties: (root = 1) if parent is equal to i, then left child should be 2 * i and right child should be 2 * i + 1
    * (root = 0) if the parent is equal to i, then left child should be 2 * i + 1 and right child should be 2 * i + 2
    */

    // Get top element
    public int peek(){
        if (size == 0){
            return -1;
        }

        return arr[0];
    }

    // Get the size of the heap
    public int len(){
        return size;
    }

    // Insert item
    public void insert (int num){
        if (size == 0){
            arr[size++] = num;
            return;
        }

        // Check whether array is full or not
        if (size == arr.length){
            // Create an array of double of the current size
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }

            arr = temp;
        }

        arr[size++] = num;

        // Check if it is the right position for this number of not
        if (isMinHeap) {
            restructureUpMin(size - 1);
        } else {
            restructureUpMax(size - 1);
        }

    }


    // Delete
    public int delete(){
        if (size == 0){
            return -1;
        }

        int val = arr[0];

        // get the last item to put it in the top
        int last = arr[size - 1];

        // Put the last index at the top
        arr[0] = last;
        // decrease the size
        size--;

        // restructure it again
        if (isMinHeap){
            restructureDownMin(0);
        } else {
            restructureDownMax(0);
        }
        return val;
    }

    private void restructureDownMin(int index) {
        // base condition
        if (index == size){
            return;
        }

        // Get the left and right child position
        int lChild = (2 * index) + 1;
        int rChild = (2 * index) + 2;

        // Check whether the lChild and rChild index not going to out of bound
        int min = -1;
        if (lChild < size && rChild < size){
            min = arr[lChild] < arr[rChild] ? lChild : rChild;
        } else if (lChild < size){
            min = lChild;
        } else if (rChild < size){
            min = rChild;
        }
        // Get the child which hold max value of these


        if (min == -1){
            return;
        }

        swap(index, min);

        restructureDownMin(min);
    }

    private void restructureDownMax(int index) {
        // base condition
        if (index == size){
            return;
        }

        // Get the left and right child position
        int lChild = (2 * index) + 1;
        int rChild = (2 * index) + 2;

        // Check whether the lChild and rChild index not going to out of bound
        int max = -1;
        if (lChild < size && rChild < size){
            max = arr[lChild] > arr[rChild] ? lChild : rChild;
        } else if (lChild < size){
            max = lChild;
        } else if (rChild < size){
            max = rChild;
        }
        // Get the child which hold max value of these


        if (max == -1){
            return;
        }

        swap(index, max);
        restructureDownMax(max);
    }

    private void restructureUpMin(int index) {
        // base condition
        if (index == 0){
            return;
        }

        // Get the parent position
        int p = (index - 1) / 2;

        if (arr[p] > arr[index]){
            // swap the element
            swap(p, index);
        }

        restructureUpMin(p);
    }

    private void restructureUpMax(int index) {
        // base condition
        if (index == 0){
            return;
        }

        // Get the parent position
        int p = (index - 1) / 2;

        if (arr[p] < arr[index]){
            // swap the element
            swap(p, index);
        }

        restructureUpMax(p);
    }

    private void swap(int pIndex, int cIndex){
        int temp = arr[pIndex];
        arr[pIndex] = arr[cIndex];
        arr[cIndex] = temp;
    }


}
