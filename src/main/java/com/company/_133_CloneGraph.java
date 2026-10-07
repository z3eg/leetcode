package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*23
ms
Beats
95.25%
*/

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer,Node> exNodes = new HashMap<>();
        return cloneNode(node, exNodes);
    }

    public Node cloneNode(Node node, Map<Integer,Node> clonedNodes) {
        if (clonedNodes.containsKey(node.val))
            return clonedNodes.get(node.val);
        Node clone = new Node(node.val);
        clonedNodes.put(node.val, clone);
        List<Node> oldNeighbors = node.neighbors;
        ArrayList<Node> newNeighbors = new ArrayList<>();
        for (Node n : oldNeighbors) {
            newNeighbors.add(cloneNode(n, clonedNodes));
        }
        clone.neighbors = newNeighbors;
        return clone;
    }
}
