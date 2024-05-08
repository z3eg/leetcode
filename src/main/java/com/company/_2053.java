package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/kth-distinct-string-in-an-array/description/
2053. Kth Distinct String in an Array*/
public class _2053 {

    /*66ms
    Beats 16.60%of users with Java*/
    public String kthDistinct(String[] arr, int k) {
        int distinctCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDistinct = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i].equals(arr[j])) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                distinctCounter++;
                if (distinctCounter==k)
                    return arr[i];
            }
        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("a", kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
        assertEquals("aaa", kthDistinct(new String[]{"aaa","aa","a"}, 1));
        assertEquals("", kthDistinct(new String[]{"a","b","a"}, 3));
    }
}
