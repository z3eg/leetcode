package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class _257 {

    /*156
    ms
            Beats
7.84%
    of users with Java*/
    /*public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        binaryTreePaths(root, new LinkedList<>(), res);
        return res;
    }

    public void binaryTreePaths(TreeNode root, List<Integer> cur, List<String> res) {
        if (root!=null) {
            cur.add(root.val);
            if (root.left==null && root.right==null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < cur.size()-1; i++) {
                    stringBuilder.append(cur.get(i));
                    stringBuilder.append("->");
                }
                stringBuilder.append(cur.get(cur.size()-1));
                res.add(stringBuilder.toString());
            }
            binaryTreePaths(root.left, cur, res);
            binaryTreePaths(root.right, cur, res);
            cur.remove(cur.size()-1);
        }
    }*/


    /*Wrong Answer
206 / 208 testcases passed*/
    /*public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        binaryTreePaths(root, new StringBuilder(), res);
        return res;
    }

    public void binaryTreePaths(TreeNode root, StringBuilder sb, List<String> res) {
        if (root!=null) {
            if (sb.length()>0)
                sb.append("->");
            sb.append(root.val);
            if (root.left==null && root.right==null) {
                res.add(sb.toString());
            }
            binaryTreePaths(root.left, sb, res);
            binaryTreePaths(root.right, sb, res);
            if (sb.length()>2)
                sb.delete(sb.length()-3, sb.length());
        }
    }*/

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        binaryTreePaths(root, new StringBuilder(), res);
        return res;
    }

    /*1
    ms
            Beats
99.90%
    of users with Java*/
    public void binaryTreePaths(TreeNode root, StringBuilder sb, List<String> res) {
        if (root!=null) {
            int curLen = sb.length();
            if (sb.length()>0)
                sb.append("->");
            sb.append(root.val);
            if (root.left==null && root.right==null) {
                res.add(sb.toString());
            }
            binaryTreePaths(root.left, sb, res);
            binaryTreePaths(root.right, sb, res);
            if (sb.length()>2)
                sb.delete(curLen, sb.length());
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> strings = binaryTreePaths(root);
    }
}
