package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1208 {

    /*Wrong Answer
10 / 37 testcases passed*/
    public int equalSubstring(String s, String t, int maxCost) {
        //populate the array of diffs and do a dynamic sliding window over it.
        int[] diffs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diffs[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int maxLen = 0;
        int curCost = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()-1) {
            while (curCost <= maxCost && r < s.length()-1) {
                curCost+=diffs[r];
                if (curCost <= maxCost)
                    maxLen = Math.max(maxLen, r-l+1);
                r++;
            }
            while (l < s.length()-1 && (l==r || (curCost > maxCost && l<r))) {
                l++;
                curCost-=diffs[l];
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        assertEquals(3, equalSubstring("abcd","bcdf",3));
        assertEquals(1, equalSubstring("abcd","cdef",3));
        assertEquals(1, equalSubstring("abcd","acde",0));
    }
}
