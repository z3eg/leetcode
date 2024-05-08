package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _680 {

    /*Wrong Answer
377 / 471 testcases passed*/
    /*public boolean validPalindrome(String s) {
        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)-'a']++;
        }
        int odds = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i]%2!=0)
                odds++;
        }
        return odds<=2;
    }*/

    /*Time Limit Exceeded
423 / 471 testcases passed*/
    /*public boolean validPalindrome(String s) {
        if (isPalindrome(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            String concat = s.substring(0, i).concat(s.substring(i+1));
            if (isPalindrome(concat))
                return true;
        }
        return false;
    }

    boolean isPalindrome(String s) {
        int r = s.length()-1;
        int l = 0;
        while (l<r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }*/

    /*Time Limit Exceeded
427 / 471 testcases passed*/
    /*public boolean validPalindrome(String s) {
        if (isPalindrome(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i))
                return true;
        }
        return false;
    }

    boolean isPalindrome(String s) {
        int r = s.length()-1;
        int l = 0;
        while (l<r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    boolean isPalindrome(String s, int ignore) {
        int r = s.length()-1;
        int l = 0;
        while (l<r) {
            if (l==ignore)
                l++;
            else  if (r==ignore)
                r--;
            else if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }*/


    /*4
    ms
            Beats
99.76%
    of users with Java*/
    public boolean validPalindrome(String s) {
        return isPalindrome(s, false);
    }

    boolean isPalindrome(String s, boolean isInner) {
        int r = s.length()-1;
        int l = 0;
        while (l<r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return isInner?false:(isPalindrome(s.substring(l,r),true) || isPalindrome(s.substring(l+1,r+1),true));
            }
        }
        return true;
    }

   /* @Test
    public void testIsPalindrome() {
        assertTrue(isPalindrome("aba"));
        assertTrue(isPalindrome("abba"));
        assertTrue(isPalindrome("abcccba"));
        assertFalse(isPalindrome("abca"));
        assertFalse(isPalindrome("abc"));
    }*/

    @Test
    public void test() {
        assertTrue(validPalindrome("abca"));
        assertTrue(validPalindrome("aba"));
        assertFalse(validPalindrome("abc"));
    }
}
