package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/mirror-reflection/
public class _858_MirrorReflection {

    public int mirrorReflection(int p, int q) {
        /*if (q == 0) return 0;
        if (p % q != 0) return 0;
        int proportion = p / q;
        if (proportion % 2 ==0) {
            return 2;
        }
        return 1;*/
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (p % 2 == 0) {
            return 2;
        } else if (q % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Test
    public void test() {
        assertEquals(2, mirrorReflection(4,3));
        assertEquals(2, mirrorReflection(2,1));
        assertEquals(1, mirrorReflection(3,1));
    }
}
