package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*6925. Faulty Keyboard
        https://leetcode.com/contest/weekly-contest-357/problems/faulty-keyboard/*/
public class _W_357_1 {

    public String finalString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='i')
                res+=s.charAt(i);
            else
                res = swap(res);
        }
        return res;
    }

    String swap(String torev) {
        StringBuilder sb = new StringBuilder();
        for (int j = torev.length()-1; j >= 0; j--) {
            sb.append(torev.charAt(j));
        }
        return sb.toString();
    }

    @Test
    public void testSwap() {
        assertEquals("nettor", swap("rotten"));
    }

    @Test
    public void test() {
        assertEquals("rtsng", finalString("string"));
        assertEquals("ponter", finalString("poiinter"));
    }

}
