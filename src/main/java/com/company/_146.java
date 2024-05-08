package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _146 {
    class LRUCache {

        Map<Integer, Node> map;
        int size;
        int capacity;
        Node head;
        Node tail;

        class Node {
            int key;
            int val;
            Node next;
            Node prev;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        void add (Node node) {
            Node oldNode = head.next;
            node.next = oldNode;
            oldNode.prev = node;
            node.prev = head;
            head.next = node;
        }

        void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void deleteLast () {
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;
            map.remove(last.key);
        }

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            this.size = 0;
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                delete(node);
                add(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node oldNode = map.get(key);
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            add(newNode);
            if (oldNode == null) {
                size++;
                if (size > capacity)
                    deleteLast();
            }
            else {
                delete(oldNode);
            }
        }
    }

    @Test
    public void test() {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    @Test
    public void test3() {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
    }

    @Test
    public void test12() {
        //["LRUCache","put","put","get","put","put","get"]
        //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        assertEquals(2, lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        assertEquals(-1, lruCache.get(2));

    }
}
