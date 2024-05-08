package com.company;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class _232 {

    /*Wrong Answer
17 / 22 testcases passed*/
    /*class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            if (!stack2.isEmpty())
                stack1.push(stack2.pop());
            stack2.push(x);
            if (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        public int pop() {
            return stack2.pop();
        }

        public int peek() {
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.empty();
        }
    }*/

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
            stack2.push(x);
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        public int pop() {
            return stack2.pop();
        }

        public int peek() {
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.empty();
        }
    }

    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        /*myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, myQueue.peek()); // return 1
        assertEquals(1,myQueue.pop()); // return 1, queue is [2]
        assertFalse(myQueue.empty()); // return false*/


        myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(4); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, myQueue.pop()); // return 1
        myQueue.push(5); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(2,myQueue.pop()); // return 1, queue is [2]
        assertEquals(3,myQueue.pop()); // return 1, queue is [2]
        assertEquals(4,myQueue.pop()); // return 1, queue is [2]
        assertEquals(5,myQueue.pop()); // return 1, queue is [2]
    }

}
