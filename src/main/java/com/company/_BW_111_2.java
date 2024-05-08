package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

/*8014. Make String a Subsequence Using Cyclic Increments
        https://leetcode.com/contest/biweekly-contest-111/problems/make-string-a-subsequence-using-cyclic-increments/*/
public class _BW_111_2 {

    public boolean canMakeSubsequence(String str1, String str2) {
        char[] charr2 = str2.toCharArray();
        int r = str1.length()-1;
        outer: for (int i = charr2.length-1; i >= 0; i--) {
            for (int j = r; j >= 0; j--) {
                if (str1.charAt(j)==charr2[i] || derived(str1.charAt(j))==charr2[i]) {
                    r = j-1;
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }

    char derived(char a) {
        if (a=='z')
            return 'a';
        return ++a;
    }

    @Test
    public void test() {
        assertTrue(canMakeSubsequence("zc", "ad"));
        assertTrue(canMakeSubsequence("abc", "ad"));
//        assertFalse(canMakeSubsequence("ab", "d"));
    }
}
