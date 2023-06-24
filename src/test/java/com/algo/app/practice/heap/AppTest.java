package com.algo.app.practice.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    @BeforeEach
    public void setup() {
    }

    @Test
    public void test_minheap_peek(){
        MinHeap minHeap = new MinHeap(10);

        minHeap.add(8);
        minHeap.add(6);
        minHeap.add(9);

        int expected = 6;
        int actual = minHeap.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void test_minheap_pop(){
        MinHeap minHeap = new MinHeap(10);

        int firstElement = 8;
        int secondElement = 6;
        int thirdElement = 9;

        minHeap.add(firstElement);
        minHeap.add(secondElement);
        minHeap.add(thirdElement);

        int expected = 6;
        int actual = minHeap.pop();

        assertEquals(expected, actual);
        assertEquals(firstElement, minHeap.peek());
    }

    @Test
    public void test_minheap_pop_all_elements(){
        MinHeap minHeap = new MinHeap(10);

        int firstElement = 8;
        int secondElement = 6;
        int thirdElement = 9;

        minHeap.add(firstElement);
        minHeap.add(secondElement);
        minHeap.add(thirdElement);

        int expected = 6;
        int actual = minHeap.pop();
        assertEquals(expected, actual);
        assertEquals(firstElement, minHeap.peek());

        actual = minHeap.pop();
        assertEquals(firstElement, actual);
        assertEquals(thirdElement, minHeap.peek());

        actual = minHeap.pop();
        assertEquals(thirdElement, actual);
        assertEquals(0, minHeap.peek());
    }

    @Test
    public void test_maxheap_peek(){
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.add(8);
        maxHeap.add(6);
        maxHeap.add(9);

        int expected = 9;
        int actual = maxHeap.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void test_maxheap_pop(){
        MaxHeap maxHeap = new MaxHeap(10);

        int firstElement = 8;
        int secondElement = 6;
        int thirdElement = 9;

        maxHeap.add(firstElement);
        maxHeap.add(secondElement);
        maxHeap.add(thirdElement);

        int expected = 9;
        int actual = maxHeap.pop();

        assertEquals(expected, actual);
        assertEquals(firstElement, maxHeap.peek());
    }

    @Test
    public void test_maxheap_pop_all_elements(){
        MaxHeap maxHeap = new MaxHeap(10);

        int firstElement = 8;
        int secondElement = 6;
        int thirdElement = 9;

        maxHeap.add(firstElement);
        maxHeap.add(secondElement);
        maxHeap.add(thirdElement);

        int expected = 9;
        int actual = maxHeap.pop();
        assertEquals(expected, actual);
        assertEquals(firstElement, maxHeap.peek());

        actual = maxHeap.pop();
        assertEquals(firstElement, actual);
        assertEquals(secondElement, maxHeap.peek());

        actual = maxHeap.pop();
        assertEquals(secondElement, actual);
        assertEquals(0, maxHeap.peek());
    }
}
