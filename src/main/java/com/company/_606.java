package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

public class _606 {

    /*1
    ms
            Beats
100.00%
    of users with Java*/
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        res.delete(res.length()-1,res.length());
        return res.toString();
    }

    private void dfs(TreeNode root, StringBuilder res) {
        if (root!=null) {
            if (res.length()>0)
                res.append("(");
            res.append(root.val);
            if (root.left==null && root.right!=null)
                res.append("()");
            else {
                dfs(root.left, res);
            }
            dfs(root.right, res);
                res.append(")");
        }
    }

    @Test
    public void test() {
//        assertEquals("1(2(4))(3)", )
    }
}
