package com.company;

import java.util.List;

public class _559 {

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

    /*Wrong Answer
37 / 38 testcases passed*/
    /*public int maxDepth(Node root) {
        return maxDep(root, 1, 1);
    }

    int maxDep(Node root, int curDepth, int curMaxDepth) {
        if (root!=null) {
            if (root.children==null || root.children.isEmpty()) {
                return Math.max(curDepth, curMaxDepth);
            }
            else {
                for (Node child : root.children) {
                    curMaxDepth = maxDep(child, curDepth+1, curMaxDepth);
                }
                return curMaxDepth;
            }
        }
        return curDepth;
    }*/

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        return maxDep(root, 1, 1);
    }

    int maxDep(Node root, int curDepth, int curMaxDepth) {
        if (root!=null) {
            if (root.children==null || root.children.isEmpty()) {
                return Math.max(curDepth, curMaxDepth);
            }
            else {
                for (Node child : root.children) {
                    curMaxDepth = maxDep(child, curDepth+1, curMaxDepth);
                }
                return curMaxDepth;
            }
        }
        return curDepth;
    }
}
