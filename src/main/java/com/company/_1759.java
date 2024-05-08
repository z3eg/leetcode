package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1759 {
    /*7ms
    Beats 96.40%of users with Java*/
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        long res = 0;
        long len = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]!=chars[i-1]) {
                res+=(len*(len+1))/2;
                len=1;
            }
            else {
                len++;
            }
        }
        res+=((len*(len+1))/2) % 1_000_000_007;
        return (int) (res % 1_000_000_007);
    }

    @Test
    public void test() {
        assertEquals(4, countHomogenous("akk"));
        assertEquals(4, countHomogenous("kka"));
        assertEquals(1, countHomogenous("k"));
        assertEquals(3, countHomogenous("kk"));
        assertEquals(13, countHomogenous("abbcccaa"));
        assertEquals(2, countHomogenous("xy"));
        assertEquals(15, countHomogenous("zzzzz"));
    }
}
