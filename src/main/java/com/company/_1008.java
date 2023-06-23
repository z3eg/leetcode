package com.company;

/*https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
1008. Construct Binary Search Tree from Preorder Traversal*/

import com.company.util.tree.BSTNode;

public class _1008 {
    public BSTNode bstFromPreorder(int[] preorder) {
        BSTNode root = new BSTNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            addNode(preorder[i], root);
        }
        return root;
    }

    private void addNode(int val, BSTNode root) {
        if (root!=null) {
            if (root.val > val) {
                if (root.left!=null)
                    addNode(val, root.left);
                else
                    root.left = new BSTNode(val);
            }
            else {
                if (root.right!=null)
                    addNode(val, root.right);
                else
                    root.right = new BSTNode(val);
            }
        }
    }
}
