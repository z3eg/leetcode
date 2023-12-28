package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _1531 {
    public int getLengthOfOptimalCompression(String s, int k) {
        if (s.length()==1)
            return k>0?0:2;
        int p = 0;
        char[] chars = s.toCharArray();
        List<Integer> list = new LinkedList<>();
        while (p < chars.length) {
            if (p < chars.length && chars[p] == chars[p+1]) {
                int curLen = 1;
                p++;
                while (p < chars.length && chars[p] == chars[p-1]) {
                    curLen++;
                    p++;
                }
                list.add(curLen);
            }
        }
        //x100
        if (list.get(0)==100) {
            if (k==100)
                return 0;
            if (k>90)
                return 2;
            else
                return 3;
        }
        List<Integer> distances = new LinkedList<>();
        for (int number : list) {

        }
        //oh you can merge them fuck me
        return 0;
    }

    @Test
    public void test() {
        assertEquals(4, getLengthOfOptimalCompression("aaabcccd", 2));
        assertEquals(2, getLengthOfOptimalCompression("aabbaa", 2));
        assertEquals(4, getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }
}
