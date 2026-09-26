package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _415 {

    /*Wrong Answer
156 / 317 testcases passed*/
    /*public String addStrings(String num1, String num2) {
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
    }*/

    /*Wrong Answer
213 / 317 testcases passed*/
    /*public String addStrings(String num1, String num2) {
        long n1 = 0;
        long n2 = 0;
        for (int i = 0; i < num1.length(); i++) {
            n1*=10;
            n1+=num1.charAt(i)-'0';
        }
        for (int i = 0; i < num2.length(); i++) {
            n2*=10;
            n2+=num2.charAt(i)-'0';
        }
        long res = n1+n2;
        if (res == 0)
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (res>=1) {
            stringBuilder.insert(0, res%10);
            res/=10;
        }
        return stringBuilder.toString();
    }*/

    public String addStrings(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        int lLen = Math.max(num1Len, num2.length());
        char[] a1 = num1.toCharArray();
        char[] a2 = num2.toCharArray();
        char[] res = new char[lLen];
        char c1;
        char c2;
        int pos1 = num1Len;
        int pos2 = num2Len;
        int curPos = lLen;
        boolean overflow = false;
        byte sum;
        while (curPos > 0) {
            char base = '0';
            sum = 0;
            curPos--;
            pos1--;
            pos2--;
            if (pos1<0)
                c1 = '0';
            else
                c1 = a1[pos1];
            if (pos2<0)
                c2 = '0';
            else
                c2 = a2[pos2];
            sum+=c1-'0';
            sum+=c2-'0';
            if (overflow) {
                sum+=1;
                overflow = false;
            }
            if (sum > 9)
                overflow = true;
            sum %= 10;
            for (int i = 0; i < sum; i++)
                base++;
            res[curPos]=base;
        }
        String s = new String(res);
        if (overflow)
            return "1"+s;
        return s;
    }

    @Test
    public void test() {
        assertEquals("100", addStrings("1", "99"));
        assertEquals("100", addStrings("99", "1"));
        assertEquals("0", addStrings("0", "0"));
        assertEquals("134", addStrings("11", "123"));
        assertEquals("533", addStrings("456", "77"));
    }
}
