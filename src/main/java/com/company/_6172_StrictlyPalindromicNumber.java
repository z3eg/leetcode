package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/contest/biweekly-contest-86/problems/strictly-palindromic-number/
public class _6172_StrictlyPalindromicNumber {

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n-1; i++) {
            if (!isPalindromicAtBase(n,i))
                return false;
        }
        return true;
    }

    private boolean isPalindromicAtBase(int n, int base) {
        String s = getRepresentationAtBase(n, base);
        int left = 0;
        int right = s.length()-1;
        while (left<=right) {
            if (s.charAt(left)!=s.charAt((right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private String getRepresentationAtBase(int n, int base) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n >=1) {
            stringBuilder.append(n % base);
            n /= base;
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        assertFalse(isStrictlyPalindromic(9));
        assertFalse(isStrictlyPalindromic(4));
    }

    @Test
    public void testIsPalindromicAtBase() {
        assertFalse(isPalindromicAtBase(4, 2));
        assertTrue(isPalindromicAtBase(9, 2));
        assertFalse(isPalindromicAtBase(9, 3));
        assertFalse(isPalindromicAtBase(9, 4));
        assertFalse(isPalindromicAtBase(9, 5));
        assertFalse(isPalindromicAtBase(9, 6));
        assertFalse(isPalindromicAtBase(9, 7));
    }

}
