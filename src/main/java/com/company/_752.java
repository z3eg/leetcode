package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _752 {


    public int openLock(String[] deadends, String target) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(6, openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        assertEquals(1, openLock(new String[]{"8888"}, "0009"));
        assertEquals(-1, openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }


}
