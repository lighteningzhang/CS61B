package es.datastructur.synthesizer;
import java.util.Iterator;
public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;
    private int cap;
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    private class ArrayRBIterator implements Iterator<T> {
        int fir;
        ArrayRBIterator() {
            fir = first;
        }

        public boolean hasNext() {
            return fir < last;
        }

        public T next() {
            if (fir >= last) {
                throw new RuntimeException("Ring Buffer overflow!");
            }
            fir = (fir + 1) % cap;
            return rb[fir];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayRBIterator();
    }

    public ArrayRingBuffer(int capacity) {
        cap = capacity;
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first = last = fillCount = 0;
        rb = (T[]) new Object[capacity];
    }
    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayRingBuffer obj = (ArrayRingBuffer) o;
        if (this.capacity() != obj.capacity()) {
            return false;
        }
        int f1;
        f1 = first;
        while(f1 != last) {
            if(rb[f1] != rb[f1]) {
                return false;
            }
            f1 = (f1 + 1) % this.cap;
        }
        return true;
    }

    @Override
    public int capacity() {
        return cap;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    protected int movLastP() {
        last = (last + 1) % cap;
        return last;
    }

    protected int movFirP() {
        first = (first + 1) % cap;
        return first;
    }

    public void print() {
        int f = first;
        int l = last;
        while (first != last) {

            System.out.print(rb[first]+" ");
            movFirP();
        }
        System.out.println();
    }

    public int getFirst() { return first;}

    public int getLast() { return last; }

    public T[] getArray() {return rb;}
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if(capacity() == fillCount()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = movLastP();
        fillCount++;
        return;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        if(this.isEmpty())
            throw new RuntimeException("Ring buffer underflow");
        T remItem = rb[first];
        first = movFirP();
        fillCount++;
        return remItem;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        return rb[first];
    }
}
