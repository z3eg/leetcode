package com.company;

import org.junit.Test;

import java.security.Key;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/top-k-frequent-elements/
public class _347_TopKFrequentElements {
    /*public int[] topKFrequent(int[] nums, int k) {
        int[] freqs = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            freqs[nums[i]+1000]++;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i]>max) {
                max = freqs[i];
                stack.push(i-1000);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = stack.pop();
        }
        return res;
    }*/

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            Integer nFreq = freqMap.get(n);
            freqMap.put(n, nFreq==null?1:nFreq+1);
        }
        int size = freqMap.size();
        int[] keys = new int[size];
        int[] values = new int[size];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            keys[index] = entry.getKey();
            values[index] = entry.getValue();
            index++;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int curMax = values[0];
            int curMaxPos = 0;
            for (int j = 1; j < values.length; j++) {
                if (values[j] > curMax) {
                    curMax = values[j];
                    curMaxPos = j;
                }
            }
            res[i] = keys[curMaxPos];
            values[curMaxPos] = 0;
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{-1,2}, topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
        assertArrayEquals(new int[]{1,2}, topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        assertArrayEquals(new int[]{1}, topKFrequent(new int[]{1}, 1));
    }
}
