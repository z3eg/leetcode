package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class _279 {

    /*108
    ms
            Beats
21.70%
    of users with Java*/
    class Holder {
        int sum;
        int count;

        public Holder(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    public int numSquares(int n) {
        int[] squares = new int[]{1,4,9,16,25,36,49,64,81,100,121,144,169,196,225,256,289,324,361,400,441,484,529,576,625,676,729,784,841,900,961,1024,1089,1156,1225,1296,1369,1444,1521,1600,1681,1764,1849,1936,2025,2116,2209,2304,2401,2500,2601,2704,2809,2916,3025,3136,3249,3364,3481,3600,3721,3844,3969,4096,4225,4356,4489,4624,4761,4900,5041,5184,5329,5476,5625,5776,5929,6084,6241,6400,6561,6724,6889,7056,7225,7396,7569,7744,7921,8100,8281,8464,8649,8836,9025,9216,9409,9604,9801,10000};
        Queue<Holder> q = new LinkedList<>();
        q.add(new Holder(0,0));
        while (!q.isEmpty()) {
            Holder cur = q.poll();
            int curSum = cur.sum;
            int curCount = cur.count;
            int i = 0;
            int diff = n-curSum;
            while (squares[i] < diff) {
                q.add(new Holder(curSum+squares[i], curCount+1));
                i++;
            }
            if (squares[i] == diff)
                return curCount+1;
        }
        return 0;
    }

    @Test
    public void test() {
        /*int square = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        while (square < 10000) {
            square = n*n;
            stringBuilder.append(square).append(",");
            n++;
        }
        System.out.println(stringBuilder.toString());*/
        assertEquals(3, numSquares(12));
        assertEquals(2, numSquares(13));
    }
}
