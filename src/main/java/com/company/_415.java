package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _415 {

    /*Wrong Answer
156 / 317 testcases passed*/
    public String addStrings(String num1, String num2) {
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < num1.length(); i++) {
            n1*=10;
            n1+=num1.charAt(i)-'0';
        }
        for (int i = 0; i < num2.length(); i++) {
            n2*=10;
            n2+=num2.charAt(i)-'0';
        }
        int res = n1+n2;
        if (res == 0)
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (res>=1) {
            stringBuilder.insert(0, res%10);
            res/=10;
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        assertEquals("0", addStrings("0", "0"));
        assertEquals("134", addStrings("11", "123"));
        assertEquals("533", addStrings("456", "77"));
    }
}
