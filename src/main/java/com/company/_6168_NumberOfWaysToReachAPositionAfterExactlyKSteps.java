package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/contest/weekly-contest-309/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
public class _6168_NumberOfWaysToReachAPositionAfterExactlyKSteps {

    private class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(endPos - startPos) == k)
            return 1;
        if (Math.abs(endPos - startPos) > k)
            return 0;
        Node node = new Node(0);
        countReaches(node, 0, startPos, endPos, k);
        return node.val;
    }

    private void countReaches(Node node, int step, int val, int endPos, int k) {
        if (step >= k) {
            if (val == endPos)
                node.val++;
        }
        else if (Math.abs(endPos - val) == Math.abs(k-step)) {
            node.val++;
        }
        else if (Math.abs(endPos - val) < Math.abs(k-step)) {
            countReaches(node, step+1, val+1, endPos, k);
            countReaches(node, step+1, val-1, endPos, k);
        }
    }

    @Test
    public void test() {
        assertEquals(68, numberOfWays(989,1000,99));
        assertEquals(68, numberOfWays(264,198,68));
        assertEquals(1, numberOfWays(1,1000,999));
        assertEquals(3, numberOfWays(1,2,3));
        assertEquals(0, numberOfWays(2,5,10));
    }
}
