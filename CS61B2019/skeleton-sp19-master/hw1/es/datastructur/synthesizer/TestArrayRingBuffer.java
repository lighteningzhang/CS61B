package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Lightening zhang
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount());
        arb.enqueue(4);
        assertEquals(4, arb.peek());
        arb.enqueue(5);
        assertEquals(4, arb.dequeue());
    }
}
