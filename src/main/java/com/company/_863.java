package com.company;

import com.company.util.tree.TreeBuilder;
import com.company.util.tree.TreeVisualizer;
import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*863. All Nodes Distance K in Binary Tree
        https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/*/
public class _863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        if (k==0) {
            res.add(target.val);
            return res;
        }
        //find the node and its depth using DFS
        int targetLvl;
        List<Integer> nodePath = getNodePath(root, target.val, new LinkedList<>());
        if (nodePath ==null)
            return res;
        targetLvl = nodePath.size();
        //calculate depths of nodes that are k away from the target
        int bottomLvl = targetLvl+k;
        int topLvl = Math.abs(targetLvl-k);
        //use DFS to get all the nodes of specified depths and add them to the list
        addNodes(root, bottomLvl, 0, res);
        addNodes(root, topLvl, 0, res);
        //return the list
        if (k > targetLvl) {
            res.removeAll(nodePath);
        }
        res.remove(Integer.valueOf(target.val));
        return res;
    }

    //THIS IS NOT A BST TREE EVEN THOUGH IT LOOKS LIKE ONE AT THE FIRST GLANCE
    private List<Integer> getNodePath(TreeNode root, int target, List<Integer> curPath) {
        if (root == null)
            return null;
        if (root.val == target) {
            return curPath;
        }
        if (root.left == null && root.right == null)
            return null;
        List<Integer> newPath = new LinkedList<>(curPath);
        newPath.add(root.val);
        List<Integer> leftPath = getNodePath(root.right, target, newPath);
        return leftPath==null ? getNodePath(root.left, target, newPath): leftPath;
    }

    private void addNodes(TreeNode root, int targetDepth, int curDepth, List<Integer> list) {
        if (curDepth == targetDepth)
            list.add(root.val);
        else {
            if (root.left!=null)
                addNodes(root.left, targetDepth, curDepth+1, list);
            if (root.right!=null)
                addNodes(root.right, targetDepth, curDepth+1, list);
        }
    }

    @Test
    public void test() throws InterruptedException {
//        TreeNode root = TreeBuilder.convert("3,5,1,6,2,0,8,null,null,7,4");
//        assertEquals(1, getNodePath(root,5, new LinkedList<>()));
        /*TreeNode root1 = TreeBuilder.convert("0,2,1,null,null,3");
        TreeVisualizer.draw(root1);*/
//        26 / 57 testcases passed
        TreeNode root1 = TreeBuilder.convert("0,2,1,null,null,3,null,4");
        TreeVisualizer.draw(root1);
    }
}
