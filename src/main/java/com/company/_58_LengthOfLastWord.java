package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/length-of-last-word/
public class _58_LengthOfLastWord {

    //now this is what i call optimal
    public int lengthOfLastWord(String s) {
        boolean wordReached = false;
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)==' ' && wordReached) {
                return count;
            }
            if (s.charAt(i)!=' ') {
                wordReached = true;
                count++;
            }
        }
        return count;
    }

    //poor runtime
    /*public int lengthOfLastWord(String s) {
        String[] split = s.split("\s+");
        return split[split.length-1].length();
    }*/


    /*Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.*/

    @Test
    public void test() {
        assertEquals(1, lengthOfLastWord("a"));
        assertEquals(5, lengthOfLastWord("Hello World"));
        assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
    }
}
