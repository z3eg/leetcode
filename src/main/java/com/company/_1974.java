package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1974 {
    /*1ms
    Beats 67.10%of users with Java*/
    public int minTimeToType(String word) {
        int res = 0;
        res+=dist('a', word.charAt(0));
        res++;
        for (int i = 0; i < word.length() - 1; i++) {
            res+=dist(word.charAt(i), word.charAt(i+1));
            res++;
        }
        return res;
    }

    int dist(char a, char b) {
        return Math.min(Math.abs(a-b), Math.min((('z'-a)+1+(b-'a')), (('z'-b)+1+(a-'a'))));
    }

    @Test
    public void testDist() {
        assertEquals(1, dist('a','b'));
        assertEquals(1, dist('b','a'));
        assertEquals(3, dist('b','y'));
        assertEquals(3, dist('y','b'));
        assertEquals(2, dist('m','o'));
        assertEquals(2, dist('o','m'));
    }

    @Test
    public void test() {
        assertEquals(1, minTimeToType("a"));
        assertEquals(2, minTimeToType("b"));
        assertEquals(2, minTimeToType("z"));
        assertEquals(8, minTimeToType("zaza"));
        assertEquals(5, minTimeToType("abc"));
        assertEquals(7, minTimeToType("bza"));
        assertEquals(34, minTimeToType("zjpc"));
    }
}
