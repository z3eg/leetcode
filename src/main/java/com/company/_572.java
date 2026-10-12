package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class _572 {

    /*3
ms
Beats
64.15%
*/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        LinkedList<TreeNode> subRoots = new LinkedList<>();
        findSubroots(root, subRoot, subRoots);
        if (subRoots.isEmpty())
            return false;
        for (TreeNode subroot : subRoots) {
            if (areEqual(subroot, subRoot))
                return true;
        }
        return false;
    }

    void findSubroots(TreeNode root, TreeNode subRoot, List<TreeNode> subRoots) {
        if (root == null)
            return;
        if (subRoot == null)
            return;
        if (root.val == subRoot.val)
            subRoots.add(root);
        findSubroots(root.left, subRoot,subRoots);
        findSubroots(root.right, subRoot,subRoots);
    }

    boolean areEqual(TreeNode root, TreeNode root2) {
        if (root == null && root2 == null)
            return true;
        if (root != null && root2 == null)
            return false;
        if (root == null && root2 != null)
            return false;
        if (root.val!=root2.val)
            return false;
        return areEqual(root.left, root2.left) && areEqual(root.right, root2.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        TreeNode subroot = new TreeNode(1);
        assertTrue(isSubtree(root,subroot));
    }

}
