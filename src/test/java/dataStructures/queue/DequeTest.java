package dataStructures.queue;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import dataStructures.queue.Deque.Deque;

/**
 * This class implements tests for the deque.
 */
public class DequeTest {
    @Test
    public void testEmpty() {
        Deque<Integer> d = new Deque<>();
        Assert.assertTrue(d.isEmpty());
        Assert.assertEquals(0, d.getSize());
        Assert.assertNull(d.peekFirst());
        Assert.assertNull(d.peekLast());
    }

    @Test
    public void testInsertion() {
        Deque<Integer> d = new Deque<>();
        Assert.assertEquals("[]", d.toString());
        d.addElement(2);
        d.addElement(3);
        d.addFirst(1);
        Assert.assertEquals("[ 1  2  3 ]", d.toString());
        Assert.assertEquals(3, d.getSize());
    }

    @Test
    public void testPeek() {
        Deque<Integer> d = new Deque<>();
        Assert.assertNull(d.peekFirst());
        Assert.assertNull(d.peekLast());
        d.addElement(1);
        d.addElement(2);
        d.addElement(3);
        d.peekLast();
        Assert.assertEquals(3, d.getSize());
        Assert.assertEquals(Optional.of(1).get(), d.peekFirst());
        Assert.assertEquals(Optional.of(3).get(), d.peekLast());
    }

    @Test
    public void testPoll() {
        Deque<Integer> d = new Deque<>();
        Assert.assertNull(d.pollFirst());
        Assert.assertNull(d.pollLast());
        d.addElement(1);
        d.addElement(2);
        d.addElement(3);
        Assert.assertEquals(Optional.of(1).get(), d.pollFirst());
        Assert.assertEquals(Optional.of(3).get(), d.pollLast());
        Assert.assertEquals(1, d.getSize());
        Assert.assertEquals("[ 2 ]", d.toString());
        Assert.assertEquals(Optional.of(2).get(), d.pollLast());
        Assert.assertEquals(0, d.getSize());
    }
}