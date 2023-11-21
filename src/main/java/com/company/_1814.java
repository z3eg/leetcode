package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _1814 {
    /*Time Limit Exceeded
65 / 84 testcases passed*/
    /*public int countNicePairs(int[] nums) {
        int mod = 1_000_000_007;
        if (nums.length==1)
            return 0;
        //type overflowing?
        long[] revs = new long[nums.length]; //long to not overflow when reversing big integers
        for (int i = 0; i < nums.length; i++) {
            revs[i] = rev(nums[i]);
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j && (revs[i] + nums[j] == revs[j] + nums[i])) { //order is important for not overflowing
                    res++; //TODO see if there are duplicates
                }
            }
        }
        return (int) (res/2)%mod;
    }

    private long rev(int num) {
        long res = 0;
        while (num>=1) {
            res*=10;
            res+=num%10;
            num/=10;
        }
        return res;
    }*/

    /*Time Limit Exceeded
    65 / 84 testcases passed
    */
    /*public int countNicePairs(int[] nums) {
        int mod = 1_000_000_007;
        if (nums.length==1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
             nums[i] -= rev(nums[i]);
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j && (nums[i] == nums[j])) {
                    res++;
                }
            }
        }
        return (int) (res/2)%mod;
    }

    private long rev(int num) {
        long res = 0;
        while (num>=1) {
            res*=10;
            res+=num%10;
            num/=10;
        }
        return res;
    }*/

    /*Wrong Answer
    83 / 84 testcases passed*/
    public int countNicePairs(int[] nums) {
        int mod = 1_000_000_007;
        if (nums.length==1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= rev(nums[i]);
        }
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer val = map.get(n);
            if (val==null)
                val = 0;
            val++;
            map.put(n, val);
        }
        for (Integer value : map.values()) {
            if (value > 1)
                res+=((long) value *(value-1))/2;
        }

        return (int) res%mod;
    }

    private long rev(int num) {
        long res = 0;
        while (num>=1) {
            res*=10;
            res+=num%10;
            num/=10;
        }
        return res;
    }

    @Test
    public void testRev() {
        assertEquals(1, rev(10));
        assertEquals(1, rev(1));
        assertEquals(27, rev(72));
        assertEquals(27, rev(720));
        assertEquals(27, rev(7200));
        assertEquals(27, rev(720000));
        assertEquals(33, rev(33));
        assertEquals(33, rev(330));
        assertEquals(33, rev(33000));
        assertEquals(7463847412L, rev(2147483647));
    }

    @Test
    public void test() {
        assertEquals(2, countNicePairs(new int[]{42,11,1,97}));
        assertEquals(4, countNicePairs(new int[]{13,10,35,24,76}));
        assertEquals(0, countNicePairs(new int[]{13}));
    }
}
