package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/palindrome-number/
public class _9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        List<Integer> digits = getDigits(x);
        int lp = 0;
        int rp = digits.size()-1;
        while (rp>=lp) {
            if (digits.get(lp) != digits.get(rp)) {
                return false;
            }
            lp++;
            rp--;
        }
        return true;
    }

    public List<Integer> getDigits(int x) {
        List<Integer> digits = new LinkedList<>();
        do {
            digits.add(x%10);
            x/=10;
        }
        while (x>=1);
        return digits;
    }


    /*Example 1:

    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.
    Example 2:

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.*/

    @Test
    public void test() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(10));
    }

}
