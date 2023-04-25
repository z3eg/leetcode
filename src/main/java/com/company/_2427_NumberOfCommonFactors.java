package com.company;

public class _2427_NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int start = Math.min(a,b);
        int res = 0;
        for (int i = start; i > 0; i--) {
            if (a%i==0 && b%i==0)
                res++;
        }
        return res;
    }
}
