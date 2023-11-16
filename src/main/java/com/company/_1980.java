package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class _1980 {
//    174 / 183 testcases passed
    /*public String findDifferentBinaryString(String[] nums) {
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
    }*/

//    175 / 183 testcases passed
    /*public String findDifferentBinaryString(String[] nums) {
        if (nums.length==1) {
            if (nums[0].equals("0"))
                return "1";
            else
                return "0";
        }
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
    }*/

    /*Time Limit Exceeded
180 / 183 testcases passed (on 5 strings??)*/
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] freqs = new int[n];
        Set<String> set = new HashSet<>();
        for (String s : nums) {
            set.add(s);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i)=='1')
                    freqs[i]++;
            }
        }
        //construct the most infrequent string
        char[] sChArr = new char[n];
        for (int i = 0; i < n; i++) {
            sChArr[i] = (freqs[i]>=n/2?'0':'1');
        }
        String res = new String(sChArr);
        if (!set.contains(res))
            return res;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n-1; i++) {
                if (freqs[i] < freqs[i+1]) {
                    int tmp = freqs[i];
                    freqs[i] = freqs[i+1];
                    freqs[i+1] = tmp;
                    tmp = pos[i];
                    pos[i] = pos[i+1];
                    pos[i+1] = tmp;
                }
            }
        }
        int counter = 0;
        while (set.contains(res)) {
            sChArr[counter]=sChArr[counter]=='0'?'1':'0';
            res = new String(sChArr);
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
