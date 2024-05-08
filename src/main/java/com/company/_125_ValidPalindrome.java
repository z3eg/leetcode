package com.company;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

//https://leetcode.com/problems/valid-palindrome/
public class _125_ValidPalindrome {

    /*3ms
    Beats 92.09%of users with Java*/
    /*public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left<right) {
//        while (left<right) {
            while (left<s.length() && (s.charAt(left)<48 || (s.charAt(left)>57 && s.charAt(left)<97)
                || s.charAt(left)> 122)) {
                left++;
            }
            while (right>=0 && (s.charAt(right)<48 || (s.charAt(right)>57 && s.charAt(right)<97)
                    || s.charAt(right)> 122)) {
                right--;
            }
            if (left<s.length() && right>=0 && s.charAt(left)!=s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }*/

    /*2ms
    Beats 99.67%of users with Java*/
    public boolean isPalindrome(String s) {
        String lc = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        char[] cA = lc.toCharArray();
        while (l < r && l < cA.length && r >= 0) {
            while (!((cA[l]<=122 && cA[l] >= 97) || (cA[l]<=57 && cA[l] >= 48))) {
                l++;
                if (l >= r)
                    return true;
            }
            while (!((cA[r]<=122 && cA[r] >= 97) || (cA[r]<=57 && cA[r] >= 48))) {
                r--;
                if (r <= l)
                    return true;
            }
            if (cA[l]!=cA[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse(isPalindrome("0P"));
        assertTrue(isPalindrome(",."));
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(isPalindrome(" "));
        assertFalse(isPalindrome("race a car"));
    }
}
