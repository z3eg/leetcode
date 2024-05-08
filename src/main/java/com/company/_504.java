package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _504 {

    /*Wrong Answer
138 / 241 testcases passed*/
    /*public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        while (Math.abs(num)>=7) {
            res.insert(0, num%7);
            num/=7;
        }
        res.insert(0, num%7);
        return res.toString();
    }*/

    /*2
    ms
            Beats
23.07%
    of users with Java*/
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        int abs = Math.abs(num);
        while (abs >=7) {
            res.insert(0, abs%7);
            abs/=7;
        }
        res.insert(0, abs%7);
        if (num < 0)
            res.insert(0,"-");
        return res.toString();
    }

    @Test
    public void test() {
        assertEquals("-11", convertToBase7(-8));
        assertEquals("202", convertToBase7(100));
        assertEquals("-10", convertToBase7(-7));
        assertEquals("-3", convertToBase7(-3));
        assertEquals("3", convertToBase7(3));
        assertEquals("0", convertToBase7(0));
        assertEquals("11", convertToBase7(8));
    }
}
