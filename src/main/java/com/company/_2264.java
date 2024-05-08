package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _2264 {

    /*Wrong Answer
126 / 141 testcases passed*/
    /*public String largestGoodInteger(String num) {
        boolean found000 = false;
        int maxInt = 0;
        for (int i = 0; i < num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            if (sub.equals("000"))
                found000 = true;
            if (sub.charAt(0)==sub.charAt(1) && sub.charAt(1)==sub.charAt(2))
                maxInt = Math.max(maxInt, Integer.parseInt(sub));
        }
        return maxInt==0?(found000?"000":""):String.valueOf(maxInt);
    }*/

    /*4
    ms
            Beats
44.87%
    of users with Java*/
    /*public String largestGoodInteger(String num) {
        boolean found000 = false;
        int maxInt = 0;
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3);
            if (sub.equals("000"))
                found000 = true;
            if (sub.charAt(0)==sub.charAt(1) && sub.charAt(1)==sub.charAt(2))
                maxInt = Math.max(maxInt, Integer.parseInt(sub));
        }
        return maxInt==0?(found000?"000":""):String.valueOf(maxInt);
    }*/

    /*1
    ms
            Beats
91.57%
    of users with Java*/
    public String largestGoodInteger(String num) {
        boolean found000 = false;
        int maxInt = 0;
        char[] chars = num.toCharArray();
        for (int i = 0; i <= num.length() - 3; i++) {
            if (chars[i]=='0' && chars[i+1]=='0' && chars[i+2]=='0')
                found000 = true;
            if (chars[i]==chars[i+1] && chars[i+2]==chars[i+1]) {
                int digit = chars[i] - '0';
                maxInt = Math.max(maxInt, digit *100+ digit *10+ digit);
            }
        }
        return maxInt==0?(found000?"000":""):String.valueOf(maxInt);
    }

    @Test
    public void test() {
        assertEquals("222", largestGoodInteger("222"));
        assertEquals("777", largestGoodInteger("6777133339"));
        assertEquals("000", largestGoodInteger("2300019"));
        assertEquals("", largestGoodInteger("42352338"));
    }
}
