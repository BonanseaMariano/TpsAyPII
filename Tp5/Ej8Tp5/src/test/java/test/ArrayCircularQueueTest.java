package test;

import arrayCircularQueue.ArrayCircularQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayCircularQueueTest {

    private ArrayCircularQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new ArrayCircularQueue<>(3);
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThrows(IllegalStateException.class, () -> {
            queue.enqueue(3);
        });

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        assertEquals(null, queue.dequeue());
    }

    @Test
    public void testRotate() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("\n--- Rotate ----");
        System.out.println(queue);

        queue.rotate();
        System.out.println(queue + "\n");

        assertEquals(2, queue.first());

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        System.out.println(queue);

        queue.rotate();
        System.out.println(queue + "\n");

        assertEquals(1, queue.first());
    }

    @Test
    public void testSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);

        assertFalse(queue.isEmpty());
    }

}
