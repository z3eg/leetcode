package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1624 {

    /*1
    ms
            Beats
86.22%
    of users with Java*/
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i< chars.length; i++) {
            char c = chars[i];
            if (l[c-'a']==-1)
                l[c-'a'] = i;
        }
        for (int i = chars.length-1; i > -1; i--) {
            char c = chars[i];
            if (r[c-'a']==-1)
                r[c-'a'] = i;
        }
        int max = -1;
        for (int i = 0; i < l.length; i++) {
            if (l[i]!=-1 && r[i]!=-1)
                max = Math.max(max, r[i]-l[i]-1);
        }
        return max;
    }


    @Test
    public void test() {
        assertEquals(0, maxLengthBetweenEqualCharacters("abccxz"));
        assertEquals(1, maxLengthBetweenEqualCharacters("abcccxz"));
        assertEquals(5, maxLengthBetweenEqualCharacters("abccccab"));
        assertEquals(2, maxLengthBetweenEqualCharacters("fbaabg"));
        assertEquals(4, maxLengthBetweenEqualCharacters("fbaabf"));
        assertEquals(4, maxLengthBetweenEqualCharacters("zbaabz"));
        assertEquals(4, maxLengthBetweenEqualCharacters("abaaba"));
        assertEquals(3, maxLengthBetweenEqualCharacters("abaca"));
        assertEquals(-1, maxLengthBetweenEqualCharacters("a"));
        assertEquals(0, maxLengthBetweenEqualCharacters("aa"));
        assertEquals(2, maxLengthBetweenEqualCharacters("abca"));
        assertEquals(-1, maxLengthBetweenEqualCharacters("cbzxy"));
    }
}
