package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class _3723 {

    /*Time Limit Exceeded
417 / 1000 testcases passed*/
    /*public String maxSumOfSquares(int num, int sum) {
        if (sum>81*num)
            return "";
        //do dfs until depth num while keeping the localSum and sequence and score, starting with 9^2 ending with 1^2
        //at depth num check if localSum == sum then we got it! return and fail fast!
        for (int i = 9; i >= 0; i--) { //TODO bring me back once done debugging
//        for (int i = 0; i <= 9; i++) {
            int maxSum = maxSum(num-1,sum,0,i,0);
            if (maxSum!=-1)
                return Integer.toString(maxSum);
        }
        return "";
    }

    int maxSum(int num, int sum, int localSum, int cur, int numSoFar) {
        if (localSum>sum)
            return -1;
        numSoFar = numSoFar*10+cur;
        localSum+=cur;
        if (num==0) {
            return localSum==sum?numSoFar:-1;
        }
        for (int i = 9; i >= 0; i--) { //TODO bring me back
//        for (int i = 0; i <= 9; i++) {
            int res = maxSum(num-1, sum, localSum, i, numSoFar);
            if (res != -1)
                return res;
        }
        return -1;
    }*/

    public String maxSumOfSquares(int num, int sum) {
        if (sum>81*num)
            return "";
        //do dfs until depth num while keeping the localSum and sequence and score, starting with 9^2 ending with 1^2
        //at depth num check if localSum == sum then we got it! return and fail fast!
        for (int i = 9; i >= 0; i--) { //TODO bring me back once done debugging
//        for (int i = 0; i <= 9; i++) {
            int maxSum = maxSum(num-1,sum,i,0);
            if (maxSum!=-1)
                return Integer.toString(maxSum);
        }
        return "";
    }

    int maxSum(int num, int sum, int cur, int numSoFar) {
        if (sum<0)
            return -1;
        numSoFar = numSoFar*10+cur;
        sum-=cur;
        if (num==0) {
            return sum==0?numSoFar:-1;
        }
        for (int i = 9; i >= 0; i--) { //TODO bring me back
//        for (int i = 0; i <= 9; i++) {
            int res = maxSum(num-1, sum, i, numSoFar);
            if (res != -1)
                return res;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals("30", maxSumOfSquares(2,3));
        assertEquals("98", maxSumOfSquares(2,17));
        assertEquals("", maxSumOfSquares(1,10));
    }

    boolean isGood(int n, int num, int sum) {
        int actualSum = 0;
        int curDig = 0;
        while (n>=1) {
            actualSum+=n%10;
            n/=10;
            curDig++;
            if (curDig>num)
                return false;
        }
        return curDig==num && actualSum==sum;
    }

    int score(int n) {
        int score = 0;
        while (n>=1) {
            score+=(n%10)*(n%10);
            n/=10;
        }
        return score;
    }

    @Test
    public void testScore() {
        assertEquals(5,score(12));
        assertEquals(5,score(21));
        assertEquals(9,score(30));
        assertEquals(145,score(89));
        assertEquals(145,score(98));
    }

    @Test
    public void testIsGood() {
        assertTrue(isGood(30,2,3));
        assertTrue(isGood(12,2,3));
        assertTrue(isGood(21,2,3));
        assertTrue(isGood(89,2,17));
        assertTrue(isGood(98,2,17));
        assertFalse(isGood(1,1,10));
        assertFalse(isGood(9,1,10));
        assertFalse(isGood(0,1,10));
        assertFalse(isGood(300,1,10));
        assertFalse(isGood(3,2,10));
        assertFalse(isGood(33,1,10));
        assertFalse(isGood(33,1,100));
    }
}
