package com.company;

import java.util.LinkedList;
import java.util.Queue;

/*225. Implement Stack using Queues
        https://leetcode.com/problems/implement-stack-using-queues/*/
public class _225 {

    class MyStack {

        Queue<Integer> list;

        public MyStack() {
            list = new LinkedList();
        }

        public void push(int x) {
            list.add(x);
            for (int i = 0; i < list.size(); i++) {
                list.add(list.remove());
            }
        }

        public int pop() {
            return list.remove();
        }

        public int top() {
            return list.peek();
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }

}
