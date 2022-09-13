package com.company;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

//https://leetcode.com/problems/valid-palindrome/
public class _125_ValidPalindrome {

    public boolean isPalindrome(String s) {
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
    }

    /*Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.*/

    @Test
    public void test() {
        assertTrue(isPalindrome(",."));
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(isPalindrome(" "));
        assertFalse(isPalindrome("race a car"));
    }
}
