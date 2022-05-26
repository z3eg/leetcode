package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/clone-graph/
public class _133_CloneGraph {

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node startNode = new Node(node.val);
        if (node.neighbors.size() == 0) {
            return startNode;
        }
        Node curNode = node.neighbors.get(0);
        while (curNode!=node) {
            Node neighbour = new Node(curNode.val);
            neighbour.neighbors.add(startNode);
            startNode.neighbors.add(neighbour);
            curNode = curNode.neighbors.get(0);
        }
        return startNode;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private String strOfLen(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) getRandomNumber(65,90);
        }
        return new String(chars);
    }

    @Test
    public void testStrOfLen() {
        System.out.println(strOfLen(100));
    }
}
