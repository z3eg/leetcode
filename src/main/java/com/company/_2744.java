package com.company;

import org.junit.jupiter.api.Test;
import scala.util.parsing.combinator.testing.Str;

import static org.junit.Assert.*;

/*2744. Find Maximum Number of String Pairs
        https://leetcode.com/problems/find-maximum-number-of-string-pairs/*/
public class _2744 {

    /*1ms
    Beats 100.00%of users with Java*/
    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length && i!=j; j++) {
                if ((words[i].charAt(0) == words[j].charAt(1)) && (words[i].charAt(1) == words[j].charAt(0)))
                    res+=1;
            }
        }
        return res;
    }

    /*boolean reverse(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(s2.length()-1-i))
                return false;
        }
        return true;
    }*/

    /*@Test
    public void testReverse() {
        assertTrue(reverse("abdc", "cdba"));
        assertTrue(reverse("abda", "adba"));
        assertFalse(reverse("abcd", "cdba"));
        assertFalse(reverse("abc", "cdba"));
    }*/

    @Test
    public void test() {
        assertEquals(0, maximumNumberOfStringPairs(new String[]{"cd"}));
        assertEquals(2, maximumNumberOfStringPairs(new String[]{"cd","ac","dc","ca","zz"}));
        assertEquals(1, maximumNumberOfStringPairs(new String[]{"ab","ba","cc"}));
    }
}
