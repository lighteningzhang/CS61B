package es.datastructur.synthesizer;
import java.util.*;
import java.util.function.DoubleBinaryOperator;

//Note: This file will not compile until you complete task 1 (BoundedQueue).
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;
    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int capacity = (int) Math.round(SR/frequency);
        buffer = new ArrayRingBuffer<Double>(capacity);
        while(!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each
        //       other.
        int cnt = buffer.fillCount();
        while(buffer.isEmpty() == false){
            buffer.dequeue();
        }

        for(int i = 0; i < buffer.capacity() ;i++) {
            double r = Math.random()-0.5;
            buffer.enqueue(r);
        }

    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double val = buffer.dequeue();
        double newDouble = DECAY*(val+buffer.peek())/2;
        buffer.enqueue(newDouble);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }

    public void print() {
        ((ArrayRingBuffer<Double>) buffer).print();
    }

}
