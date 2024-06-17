package com.company;

public class _633 {
    /*Time Limit Exceeded
    26 / 127 testcases passed*/
    public boolean judgeSquareSum(int c) {
        for (int i = 1; i < c; i++) {
            if (Math.sqrt((double)c-i*i)%1==0)
                return true;
        }
        return false;
    }
}
