package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _501 {

    /*11ms
    Beats 11.23%of users with Java*/
    public int[] findMode(TreeNode root) {
        int[] freqs = new int[200_002];
        Set<Integer> set = new HashSet<>();
        bst(root, freqs);
        int max = 0;
        for (int i = 0; i < freqs.length; i++) {
            max = Math.max(max, freqs[i]);
        }
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] == max) {
                set.add(i-100_000);
            }
        }
        int[] res = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int pos = 0;
        while (iterator.hasNext()) {
            res[pos] = iterator.next();
            pos++;
        }
        return res;
    }

    void bst(TreeNode root, int[] freqs) {
        if (root!=null) {
            freqs[root.val+100_000]++;
            bst(root.left, freqs);
            bst(root.right, freqs);
        }
    }

    @Test
    public void test() {
//        assertArrayEquals(new int[]{2}, findMode())
    }

}
