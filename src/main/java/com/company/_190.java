package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _190 {

    /*1
ms
Beats
58.60%
*/
    public int reverseBits(int n) {
        int bitNum = 0;
        int[] bits = new int[32];
        int pos = 0;
        while (pos<32) {
            bits[pos]=Math.floorMod(n,2);
            n = Math.floorDiv(n,2);
            pos++;
        }
        int pows[] = new int[32];
        int powed = 1;
        for (int i = 0; i < 32; i++) {
            pows[i] = powed;
            powed*=2;
        }
        int res = 0;
        for (int i = 0; i <32; i++) {
            res+=pows[i]*bits[31-i];
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(964176192, reverseBits(43261596));
        assertEquals(1073741822, reverseBits(2147483644));
    }
}
