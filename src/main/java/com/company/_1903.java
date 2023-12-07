package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1903 {

    /*2
    ms
            Beats
30.08%
    of users with Java*/
    public String largestOddNumber(String num) {
        for (int i = num.length()-1; i >= 0; i--) {
            if (num.charAt(i)=='1' || num.charAt(i)=='3' || num.charAt(i)=='5' || num.charAt(i)=='7' || num.charAt(i)=='9')
                return num.substring(0,i+1);
        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("5", largestOddNumber("5"));
        assertEquals("5", largestOddNumber("52"));
        assertEquals("", largestOddNumber("4206"));
        assertEquals("35427", largestOddNumber("35427"));
    }
}
