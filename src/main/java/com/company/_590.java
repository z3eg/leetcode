package com.company;

import java.util.LinkedList;
import java.util.List;

/*590. N-ary Tree Postorder Traversal
        https://leetcode.com/problems/n-ary-tree-postorder-traversal/*/
public class _590 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /*1ms
    Beats 63.62%of users with Java*/
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        traverse(root, list);
        return list;
    }

    private void traverse(Node root, List<Integer> list) {
        if (root!=null) {
            for (Node child : root.children) {
                traverse(child, list);
            }
            list.add(root.val);
        }
    }
}
