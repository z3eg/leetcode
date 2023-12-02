package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _202 {


    /*Wrong Answer
    417 / 420 testcases passed*/
    public boolean isHappy(int n) {
        if (n==1)
            return true;
        if (n<10)
            return false;
        int sum = 0;
        while (n>=1) {
            int dig = n % 10;
            sum+= dig*dig;
            n/=10;
        }
        return isHappy(sum);
    }

    @Test
    public void test() {
        assertTrue(isHappy(19));
        assertFalse(isHappy(2));
    }
}
