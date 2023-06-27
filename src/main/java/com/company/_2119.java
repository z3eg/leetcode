package com.company;

/*2119. A Number After a Double Reversal
        https://leetcode.com/problems/a-number-after-a-double-reversal/description/*/
public class _2119 {
    /*Runtime
    0 ms
    Beats
    100%*/
    public boolean isSameAfterReversals(int num) {
        if (num==0)
            return true;
        return num % 10 != 0;
    }
}
