package es.datastructur.synthesizer;

public interface BoundQueue<T> {
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return capacity() == fillCount();
    }
}
