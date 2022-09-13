package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/replace-all-digits-with-characters/
public class _1844_ReplaceAllDigitsWithCharacters {
    
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        int border = chars.length - 1;
        for (int i = 0; i < border; i+=2)
            chars[i+1] = (char) (chars[i]+chars[i+1]-'0');
        return new String(chars);
    }

    @Test
    public void test() {
        assertEquals("abcdef", replaceDigits("a1c1e1"));
        assertEquals("abbdcfdhe", replaceDigits("a1b2c3d4e"));
    }

    /*Example 1:

Input: s = "a1c1e1"
Output: "abcdef"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('c',1) = 'd'
- s[5] -> shift('e',1) = 'f'
Example 2:

Input: s = "a1b2c3d4e"
Output: "abbdcfdhe"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('b',2) = 'd'
- s[5] -> shift('c',3) = 'f'
- s[7] -> shift('d',4) = 'h'*/
}
