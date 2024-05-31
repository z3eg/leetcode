package com.company;

import org.junit.Test;

import java.util.HashMap;

public class _260 {

    /*6
    ms
    Beats
    31.65%
    of users with Java*/
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            Boolean aBoolean = map.get(n);
            if (aBoolean == null)
                map.put(n, true);
            else if (aBoolean)
                map.put(n, false);
        }
        int[] res = new int[2];
        final int[] counter = {0};
        map.forEach((key, value) -> {
            if (value) {
                res[counter[0]] = key;
                counter[0]++;
            }
        });
        return res;
    }

    @Test
    public void test() {
        int[] ints = singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(ints);
    }
}
