package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _869_ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        int[] powsOf2 = new int[] {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,
            262144,524288,1048576, 2097152, 4194304, 8388608, 16777216, 33_554_432, 67_108_864, 134_217_728,
            268_435_456, 536_870_912};
        int[] nums = numsMap(n);
        for (int j : powsOf2) {
            int[] powNums = numsMap(j);
            if (Arrays.equals(nums, powNums))
                return true;
        }
        return false;
    }

    private int[] numsMap(int n) {
        int[] res = new int[10];
        while (n>=1) {
            int i = n % 10;
            res[i]++;
            n/=10;
        }
        return res;
    }

    @Test
    public void test() {
        assertTrue(reorderedPowerOf2(218));
//        assertEquals(5, countNums(78923));
    }
}
