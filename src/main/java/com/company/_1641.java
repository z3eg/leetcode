package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*1641. Count Sorted Vowel Strings
        https://leetcode.com/problems/count-sorted-vowel-strings/*/
public class _1641 {
    /*1325ms
    Beats 5.04%of users with Java*/
    /*public int countVowelStrings(int n) {
        HashSet<String> set = new HashSet<>();
        char[] lets = new char[]{'a','e','i','o','u'};
        add("",lets,set,n);
        return set.size();
    }

    void add(String s, char[] lets, Set<String> set, int limit) {
        if (s.length()==limit)
            set.add(s);
        if (s.length()<limit) {
            for (char c : lets) {
                if (s.isEmpty() || c >= s.charAt(s.length()-1)) {
                    add(s+c,lets, set, limit);
                }
            }
        }
    }*/

    /*1027ms
    Beats 5.04%of users with Java*/
    /*public int countVowelStrings(int n) {
        char[] lets = new char[]{'a','e','i','o','u'};
        return add("",lets,0,n);
    }

    int add(String s, char[] lets, int counter, int limit) {
        if (s.length()==limit) {
            counter++;
            return counter;
        }
        if (s.length()<limit) {
            for (char c : lets) {
                if (s.isEmpty() || c >= s.charAt(s.length()-1)) {
                    counter = add(s+c,lets, counter, limit);
                }
            }
        }
        return counter;
    }*/

    /*188ms
    Beats 7.69%of users with Java*/


    /*62ms
    Beats 15.83%of users with Java*/
    /*public int countVowelStrings(int n) {
        return add(0, 0,0,n);
    }

    int add(int len, int lastChar, int counter, int limit) {
        if (len==limit) {
            counter++;
            return counter;
        }
        for (int i = lastChar; i <5; i++) {
            counter = add(len+1, i, counter, limit);
        }
        return counter;
    }*/

    /*57ms
    Beats 17.68%of users with Java*/
    /*public int countVowelStrings(int n) {
        return add(0, 0,0,n);
    }

    int add(int len, int lastChar, int counter, int limit) {
        if (len==limit) {
            counter++;
            return counter;
        }
        for (int i = lastChar; i <5; i++) {
            counter = add(len+1, i, counter, limit);
        }
        return counter;
    }*/

    /*53ms
    Beats 18.39%of users with Java*/
    /*public int n;
    public int countVowelStrings(int n) {
        this.n = n;
        return add(0, 0,0);
    }

    int add(int len, int lastChar, int counter) {
        if (len==n) {
            counter++;
            return counter;
        }
        for (int i = lastChar; i <5; i++) {
            counter = add(len+1, i, counter);
        }
        return counter;
    }*/

    /*59ms
    Beats 16.36%of users with Java*/
    /*public int countVowelStrings(int n) {
        return add(0, 0,0,n);
    }

    int add(int len, int lastChar, int counter, int limit) {
        if (len<limit-1) {
            for (int i = lastChar; i < 5; i++) {
                counter=add(len+1, i, counter, limit);
            }
        }
        else {
            counter+=5-lastChar;
        }
        return counter;
    }*/

    /*Runtime 0 ms
    Beats 100%
    DP LET'S GOOOOOOOOOOO*/
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        dp[0] = new int[]{5,4,3,2,1};
        return add(0, 0, n-1, dp);
    }

    int add(int lastChar, int counter, int limit, int[][] dp) {
        if (dp[limit][lastChar]!=0)
            return dp[limit][lastChar];
        else {
            int addRes = 0;
            for (int i = lastChar; i < 5; i++) {
                addRes += add(i, counter, limit-1, dp);
            }
            dp[limit][lastChar]=addRes;
            counter += addRes;
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(35, countVowelStrings(3));
        assertEquals(5, countVowelStrings(1));
        assertEquals(15, countVowelStrings(2));
        assertEquals(66045, countVowelStrings(33));
    }
}
