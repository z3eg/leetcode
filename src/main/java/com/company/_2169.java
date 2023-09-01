package com.company;

/*2169. Count Operations to Obtain Zero
        https://leetcode.com/problems/count-operations-to-obtain-zero/*/
public class _2169 {
    /*1ms
    Beats 94.33%of users with Java*/
    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1>0 && num2 >0) {
            if (num1>num2)
                num1 -= num2;
            else
                num2 -= num1;
            res++;
        }
        return res;
    }
}
