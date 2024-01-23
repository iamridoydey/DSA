package Heap;

public class HeapMain {
    public static void main(String[] args) {
        // By default, it contains the max item at the top
        Heap heap = new Heap(true);
        int N = 10;
        for (int i = 1; i <= N; i++) {
            heap.insert(i);
        }

        System.out.println(heap.peek());
        heap.delete();
        System.out.println(heap.peek());

        heap.insert(0);
        System.out.println(heap.peek());
    }
}
