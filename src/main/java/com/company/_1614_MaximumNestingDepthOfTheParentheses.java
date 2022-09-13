package com.company;

import org.junit.Test;

public class _1614_MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int cur = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c=='(') {
                cur++;
                max = Math.max(max,cur);
            }
            if (c==')')
                cur--;
        }
        return max;
    }

    @Test
    public void test() {

    }
}
