package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/interleaving-string/
public class _97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length())
            return false;
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
            return true;
        if (s1.isEmpty())
            return s2.equals(s3);
        if (s2.isEmpty())
            return s1.equals(s3);
        return check(s1,s2,s3,0,0,0);
    }


//105 / 106 testcases passed
    boolean check(String s1, String s2, String s3, int l1, int l2, int l3) {
        char c1 = '#';
        char c2 = '#';
        char c3 = s3.charAt(l3);
        if (l1 < s1.length())
            c1 = s1.charAt(l1);
        if (l2 < s2.length())
            c2 = s2.charAt(l2);
        if (l3 == s3.length()-1 && (c3==c1 || c3==c2))
            return true;
        boolean res = false;
        if (c3==c1) {
            res = check(s1,s2,s3,l1+1,l2,l3+1);
        }
        if (c3==c2) {
            res = res || check(s1,s2,s3,l1,l2+1,l3+1);
        }
        return res;
    }

    /*boolean check(String s1, String s2, String s3, int l1, int l2, int l3) {
        if (l3 == s3.length())
            return true;
        char c3 = s3.charAt(l3);
        char c1 = s1.charAt(l1);
        char c2 = s2.charAt(l2);
        //remove after debugging
        String sub1 = s1.substring(l1);
        String sub2 = s2.substring(l2);
        String sub3 = s3.substring(l3);
        System.out.println("=========");
        System.out.println(sub1);
        System.out.println(sub2);
        System.out.println(sub3);
        //
        if (c1 != c3 && c2 != c3)
            return false;
        if (c1 == c3 && c2 == c3) {
            return (l1+1<s1.length() && check(s1,s2,s3,l1+1,l2,l3+1)) ||
                    (l2+1<s2.length() && check(s1,s2,s3,l1,l2+1,l3+1));
        }
        if (c1 == c3 && l1+1<s1.length())
            return check(s1,s2,s3,l1+1,l2,l3+1);
        if (c2 == c3 && l2+1<s2.length()) {
            return check(s1,s2,s3,l1,l2+1,l3+1);
        }
        return false;
    }*/

    @Test
    public void test() {
        assertTrue(isInterleave("abcd", "e", "abcde"));
        assertTrue(isInterleave("abde", "c", "abcde"));
        assertTrue(isInterleave("b", "a", "ab"));
        assertTrue(isInterleave("a", "b", "ab"));
        assertTrue(isInterleave("a", "b", "ba"));
        assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertTrue(isInterleave("", "", ""));
    }
}
