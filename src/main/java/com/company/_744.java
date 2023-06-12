package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*744. Find Smallest Letter Greater Than Target
        https://leetcode.com/problems/find-smallest-letter-greater-than-target/*/
public class _744 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target)
                return c;
        }
        return letters[0];
    }

    @Test
    public void test() {
        assertEquals('c', nextGreatestLetter(new char[]{'c','f','j'},'a'));
        assertEquals('f', nextGreatestLetter(new char[]{'c','f','j'},'c'));
        assertEquals('x', nextGreatestLetter(new char[]{'x','x','y','y'},'z'));
    }
}
