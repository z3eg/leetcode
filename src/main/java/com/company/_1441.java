package com.company;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class _1441 {
    /*0ms
    Beats 100.00%of users with Java*/
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new LinkedList<>();
        int cur = 1;
        int curPos = 0;
        while (cur <= target[target.length-1]) {
            res.add("Push");
            if (cur==target[curPos])
                curPos++;
            else
                res.add("Pop");
            cur++;
        }
        return res;
    }

    private void push(List<String> res) {
        res.add("Push");
    }

    private void pop(List<String> res) {
        res.add("Pop");
    }

    @Test
    public void test() {
        assertIterableEquals(Arrays.asList("Push","Push","Pop","Push"), buildArray(new int[]{1,3}, 3));
        assertIterableEquals(Arrays.asList("Push","Push","Push"), buildArray(new int[]{1,2,3}, 3));
        assertIterableEquals(Arrays.asList("Push","Push"), buildArray(new int[]{1,2}, 4));
        assertIterableEquals(Arrays.asList("Push"), buildArray(new int[]{1}, 4));
        assertIterableEquals(Arrays.asList("Push","Pop","Push","Pop","Push"), buildArray(new int[]{3}, 4));
    }
}
