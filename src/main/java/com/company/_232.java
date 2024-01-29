package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class _232 {

    class MyQueue {

        public MyQueue() {

        }

        public void push(int x) {

        }

        public int pop() {
            return 0;
        }

        public int peek() {
            return 0;
        }

        public boolean empty() {
            return true;
        }
    }

    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, myQueue.peek()); // return 1
        assertEquals(1,myQueue.pop()); // return 1, queue is [2]
        assertFalse(myQueue.empty()); // return false
    }

}
