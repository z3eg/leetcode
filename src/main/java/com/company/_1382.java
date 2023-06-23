package com.company;

import com.company.util.tree.TreeBuilder;
import com.company.util.tree.BSTNode;
import com.company.util.tree.TreeVisualizer;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*1382. Balance a Binary Search Tree
https://leetcode.com/problems/balance-a-binary-search-tree/*/
public class _1382 {

    public BSTNode balanceBST(BSTNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        fillSet(set, root);
        int i = set.size() / 2;
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (index < i) {
            iterator.next();
            index++;
        }
        BSTNode newRoot = new BSTNode(iterator.next());
        while (iterator.hasNext()) {
            addNode(newRoot, iterator.next());
        }
        iterator = set.iterator();
        index = 0;
        while (index < i) {
            addNode(newRoot, iterator.next());
            index++;
        }
        return newRoot;
    }

    private void fillSet(Set set, BSTNode root) {
        if (root != null) {
            set.add(root.val);
        }
        else {
            fillSet(set, root.right);
            fillSet(set, root.left);
        }
    }

    private void addNode(BSTNode root, int val) {
        if (root.val > val) {
            if (root.left == null)
                root.left = new BSTNode(val);
            else
                addNode(root.left, val);
        }
        else {
            if (root.right == null)
                root.right = new BSTNode(val);
            else
                addNode(root.right, val);
        }
    }

    @Test
    public void test() throws InterruptedException {
        TreeVisualizer.draw(TreeBuilder.convert("[1,null,2,null,3,null,4]"));
//        TreeVisualizer.draw(TreeBuilder.buildTreeFromArray(StringToArrayConverter.convert("[1,null,2,null,3,null,4]"),0));
    }
}
