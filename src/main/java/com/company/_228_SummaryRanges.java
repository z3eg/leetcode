package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/summary-ranges/
public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> strings = new LinkedList<>();
        if (nums.length==0)
            return strings;
        int l = nums[0];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1]!=1) {
                String s = String.valueOf(l);
                if (l!=r) {
                    s=s+"->"+r;
                }
                strings.add(s);
                l = nums[i];
            }
            r = nums[i];
        }
        String s = String.valueOf(l);
        if (l!=r) {
            s=s+"->"+r;
        }
        strings.add(s);
        return strings;
    }

    @Test
    public void test() {
        assertArrayEquals(new String[]{"0->2","4->5","7"}, summaryRanges(new int[]{0,1,2,4,5,7}).toArray());
        assertArrayEquals(new String[]{"0","2->4","6","8->9"}, summaryRanges(new int[]{0,2,3,4,6,8,9}).toArray());
    }
}
