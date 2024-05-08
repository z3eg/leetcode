package com.company;

import java.util.LinkedList;
import java.util.List;

public class _589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /*1ms
    Beats 86.49%of users with Java*/
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        add(root, res);
        return res;
    }

    void add(Node root, List<Integer> res) {
        if (root!=null) {
            res.add(root.val);
            for (Node child : root.children) {
                add(child, res);
            }
        }
    }
}
