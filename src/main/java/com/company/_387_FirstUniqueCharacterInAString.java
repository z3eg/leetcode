package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class _387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int [] pos = new int[26];
        Arrays.fill(pos, 10001);
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int curPos = chars[i] - 'a';
            if (pos[curPos]==10001)
                pos[curPos] = i;
            else
                pos[curPos] = 10002;
        }
        Arrays.sort(pos);
        return pos[0]<10001?pos[0]:-1;
    }

    @Test
    public void test() {
        assertEquals(8, firstUniqChar("dddccdbba"));
        assertEquals(0, firstUniqChar("leetcode"));
        assertEquals(2, firstUniqChar("loveleetcode"));
        assertEquals(-1, firstUniqChar("aabb"));
    }

   /* Example 1:

    Input: s = "leetcode"
    Output: 0
    Example 2:

    Input: s = "loveleetcode"
    Output: 2
    Example 3:

    Input: s = "aabb"
    Output: -1*/
}
