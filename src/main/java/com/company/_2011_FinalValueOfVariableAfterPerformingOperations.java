package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class _2011_FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String s : operations) {
            switch (s) {
                case "++X", "X++" -> res++;
                case "--X", "X--" -> res--;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(3, finalValueAfterOperations(new String[]{"++X","++X","X++"}));
        assertEquals(0, finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}));
    }

    /*Example 2:

    Input: operations = ["++X","++X","X++"]
    Output: 3
    Explanation: The operations are performed as follows:
    Initially, X = 0.
            ++X: X is incremented by 1, X = 0 + 1 = 1.
            ++X: X is incremented by 1, X = 1 + 1 = 2.
    X++: X is incremented by 1, X = 2 + 1 = 3.
    Example 3:

    Input: operations = ["X++","++X","--X","X--"]
    Output: 0
    Explanation: The operations are performed as follows:
    Initially, X = 0.
    X++: X is incremented by 1, X = 0 + 1 = 1.
            ++X: X is incremented by 1, X = 1 + 1 = 2.
            --X: X is decremented by 1, X = 2 - 1 = 1.
    X--: X is decremented by 1, X = 1 - 1 = 0.*/
}
