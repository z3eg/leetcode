package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

public class _405 {

    public String toHex(int num) {
        if (num==0)
            return "0";
        long unsigned = num & 0xFFFFFFFFL;
        LinkedList<Character> chars = new LinkedList<>();
        while (unsigned>0) {
            char curchar;
            int curPart = (int) unsigned % 16;
            if (curPart == -1)
                curchar = 'f';
            else
                curchar = (char) ((curPart<=9) ? ('0' + curPart) : ('a' + curPart-10));
            chars.addFirst(curchar);
            unsigned/=16;
        }
        char[] chArr = new char[chars.size()];
        for (int i = 0; i < chars.size(); i++) {
            chArr[i] = chars.get(i);
        }
        return new String(chArr);
    }

    @Test
    public void test() {
        assertEquals("fffffffe", toHex(-2));
        assertEquals("ffffffff", toHex(-1));
        assertEquals("0", toHex(0));
        assertEquals("1a", toHex(26));
    }
}
