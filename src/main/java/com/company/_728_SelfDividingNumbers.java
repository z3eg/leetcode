package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/problems/self-dividing-numbers/
public class _728_SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i))
                res.add(i);
        }
        return res;
    }

    private boolean isSelfDividing(int n) {
        if (n<1)
            return false;
        int c = n;
        while (n>=1) {
            int dig = n%10;
            if (dig==0)
                return false;
            if (c%dig!=0)
                return false;
            n/=10;
        }
        return true;
    }

    @Test
    public void testIsSelfDividing() {
        assertTrue(isSelfDividing(128));
        assertFalse(isSelfDividing(27));
    }

}
