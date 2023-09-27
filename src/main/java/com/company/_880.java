package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _880 {

    //inspired by VanAmsen solution, couldn't come up with it on my own
    public String decodeAtIndex(String s, int k) {
        int len = 0;
        int i = 0;
        while (len < k) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                len*=c-'0';
            }
            else {
                len++;
            }
            i++;
        }

        for (int j = i-1; j >= 0; j--) {
            char c = s.charAt(j);
            if (Character.isDigit(c)) {
                len/=c-'0';
                k%=len;
            }
            else {
                if (k==0 || k == len)
                    return ""+c;
                len--;
            }
        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("o", decodeAtIndex("leet2code3",10));
        assertEquals("h", decodeAtIndex("ha22",5));
        assertEquals("a", decodeAtIndex("a2345678999999999999999",1));

    }
}
