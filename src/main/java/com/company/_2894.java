package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _2894 {

    /*1ms
    Beats 93.83%of users with Java*/
    public int differenceOfSums(int n, int m) {
        int num1=0;
        int num2=0;
        for (int i = 0; i <= n; i++) {
            if (i%m==0) {
                num1+=i;
            }
            else {
                num2+=i;
            }
        }
        return num2-num1;
    }

    @Test
    public void test() {
        assertEquals(19, differenceOfSums(10, 3));
        assertEquals(15, differenceOfSums(5, 6));
        assertEquals(-15, differenceOfSums(5, 1));
    }
}
