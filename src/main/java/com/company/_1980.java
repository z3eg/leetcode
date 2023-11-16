package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class _1980 {
//    174 / 183 testcases passed
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] freqs = new int[n];
        for (String s : nums) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i)=='1')
                    freqs[i]++;
            }
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            res+=(freqs[i]>=n/2?"0":"1");
        }
        return res;
    }

    @Test
    public void test() {
        assertTrue("11".equals(findDifferentBinaryString(new String[]{"01","10"})) ||
                "00".equals(findDifferentBinaryString(new String[]{"01","10"})));
        assertTrue("11".equals(findDifferentBinaryString(new String[]{"00","01"})) ||
                "10".equals(findDifferentBinaryString(new String[]{"00","01"})));
        assertTrue("101".equals(findDifferentBinaryString(new String[]{"111","011","001"})) ||
                "000".equals(findDifferentBinaryString(new String[]{"111","011","001"})) ||
                "010".equals(findDifferentBinaryString(new String[]{"111","011","001"})) ||
                "100".equals(findDifferentBinaryString(new String[]{"111","011","001"})) ||
                "110".equals(findDifferentBinaryString(new String[]{"111","011","001"}))
        );

    }
}
