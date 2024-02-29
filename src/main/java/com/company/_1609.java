package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _1609 {


    /*15
    ms
            Beats
38.87%
    of users with Java*/
    class NodeWrapper {
        TreeNode node;
        int depth;

        public NodeWrapper(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<NodeWrapper> q = new LinkedList<>();
        NodeWrapper last = null;
        q.add(new NodeWrapper(root,0));
        while (!q.isEmpty()) {
            NodeWrapper cur = q.poll();
            if (cur.depth%2==cur.node.val%2)
                return false;
            if (last!=null && (cur.depth==last.depth)) {
                    if (cur.depth%2==0 && cur.node.val <= last.node.val)
                        return false;
                    if (cur.depth%2==1 && cur.node.val >= last.node.val)
                        return false;

            }
            if (cur.node.left!=null)
                q.add(new NodeWrapper(cur.node.left, cur.depth+1));
            if (cur.node.right!=null)
                q.add(new NodeWrapper(cur.node.right, cur.depth+1));
            last = cur;
        }
        return true;
    }
}
