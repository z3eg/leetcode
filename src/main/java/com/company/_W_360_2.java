package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*https://leetcode.com/contest/weekly-contest-360/problems/find-the-minimum-possible-sum-of-a-beautiful-array/
        8022. Find the Minimum Possible Sum of a Beautiful Array*/
public class _W_360_2 {

    /*public long minimumPossibleSum(int n, int target) {
        int[] bArr = new int[n];
        bArr[0] = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            int newNum = bArr[i-1]+1;
            boolean acceptable = false;
            while (!acceptable) {
                acceptable = true;
                for (int j = 0; j < i; j++) {
                    if (bArr[j] + newNum == target) {
                        newNum++;
                        acceptable = false;
                        break;
                    }
                }
            }
            bArr[i] = newNum;
            sum+=newNum;
        }
        return sum;
    }*/

    /*public long minimumPossibleSum(int n, int target) {
        int[] arr = new int[99999];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        int[] bArr = new int[n];
        bArr[0] = 1;
        arr[target-1] = 0;
        int sum = 1;
        int counter = 1;
        for (int i = 2; i < arr.length && counter < n; i++) {
            if (arr[i]!=0) {
                sum+=i;
                bArr[counter] = arr[i];
                arr[i]=0;
                if (target-i >= 0) {
                    arr[target-i] = 0;
                }
                counter++;
            }
        }
        return sum;
    }*/

    public long minimumPossibleSum(int n, int target) {
        long res = 0;
        int counter = 0;
        for (int i = 0; i < target / 2 && counter < n; i++, counter++) {
            res += i+1;
        }
        int tar = target;
        while (counter < n) {
            res+=tar;
            tar++;
            counter++;
        }
        return res;
    }


    @Test
    public void test() {
        assertEquals(91, minimumPossibleSum(13,50));
        assertEquals(19, minimumPossibleSum(5,6));
        assertEquals(21, minimumPossibleSum(5,5));
        assertEquals(4, minimumPossibleSum(2,3));
        assertEquals(8, minimumPossibleSum(3,3));
        assertEquals(1, minimumPossibleSum(1,1));
        /*assertEquals();
        assertTrue();
        assertFalse();
        assertArrayEquals();*/
    }
}
