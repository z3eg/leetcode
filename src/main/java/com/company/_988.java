package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _988 {

    /*Wrong Answer
35 / 70 testcases passed*/
    class Wrapper {
        TreeNode node;
        String word;

        public Wrapper(TreeNode node, String word) {
            this.node = node;
            this.word = word;
        }
    }
    public String smallestFromLeaf(TreeNode root) {
        //bfs
        Queue<Wrapper> q = new LinkedList<>();
        int shortest = -1;
        Set<String> answers = new TreeSet<>();
        char c = 'a';
        c+=root.val;
        q.add(new Wrapper(root, String.valueOf(c)));
        while (!q.isEmpty()) {
            Wrapper poll = q.poll();
            String word = poll.word;
            int curLen = word.length();
            if (shortest != -1 && curLen > shortest) {
                break;
            }
            TreeNode curNode = poll.node;
            char curC = 'a';
            curC+=curNode.val;
            word = curC+word;
            if (curNode.left == null && curNode.right == null) {
                if (shortest == -1)
                    shortest = curLen;
                answers.add(word);
            }
            else {
                if (curNode.left!=null) {
                    q.add(new Wrapper(curNode.left, word));
                }
                if (curNode.right!=null) {
                    q.add(new Wrapper(curNode.right, word));
                }
            }
        }
        String ans = answers.iterator().next();
        return ans.substring(0,ans.length()-1);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        assertEquals("dba", smallestFromLeaf(root));
    }
}
