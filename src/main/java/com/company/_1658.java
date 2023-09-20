package com.company;

import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/?envType=daily-question&envId=2023-09-20
1658. Minimum Operations to Reduce X to Zero*/
public class _1658 {
    /*public int minOperations(int[] nums, int x) {
        int dfs = dfs(nums, x, 0, Integer.MAX_VALUE, 0, nums.length - 1);
        return dfs==Integer.MAX_VALUE?-1:dfs;
    }

    //bfs is better here but i just cant come up with a bfs at the moment
    int dfs(int[] nums, int x, int cur, int min, int l, int r) {
        if (l>r)
            return Integer.MAX_VALUE;
        if (x==0)
            return cur;
        int left = dfs(nums, x-nums[l], cur+1, min, l+1, r);
        if (left > 0)
            min = Math.min(min, left);
        int right = dfs(nums, x-nums[r], cur+1, min, l, r-1);
        if (right > 0)
            min = Math.min(min, right);
        return min;
    }*/

    /*Time Limit Exceeded
    10 / 94 testcases passed*/
    /*public class bfs {
        int depth, l, r, x;

        public bfs(int depth, int l, int r, int x) {
            this.depth = depth;
            this.l = l;
            this.r = r;
            this.x = x;
        }
    }

    public int minOperations(int[] nums, int x) {
        Queue<bfs> q = new LinkedList<>();
        q.add(new bfs(0,0,nums.length-1,x));
        while (!q.isEmpty()) {
            bfs cur = q.poll();
            if (cur.x==0)
                return cur.depth;
            if (cur.l <= cur.r) {
                if (cur.x - nums[cur.l] >= 0)
                    q.add(new bfs(cur.depth + 1, cur.l + 1, cur.r, cur.x - nums[cur.l]));
                if (cur.x - nums[cur.r] >= 0)
                    q.add(new bfs(cur.depth + 1, cur.l, cur.r - 1, cur.x - nums[cur.r]));
            }
        }
        return -1;
    }*/

    /*Time Limit Exceeded
    83 / 94 testcases passed*/
    /*public int minOperations(int[] nums, int x) {
        int[] l = new int[nums.length+1];
        int[] r = new int[nums.length+1];
        l[0] = 0;
        r[r.length-1] = 0;
        for (int i = 1; i < l.length; i++) {
            l[i] = nums[i-1]+l[i-1];
            r[r.length-1-i] = nums[r.length-i-1]+r[r.length-i];
        }
        if (r[0] == x || l[nums.length]==x)
            return nums.length;
        int left, right;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++) {
            for (int j = l.length-1; j > i; j--) {
                left = l[i];
                right = r[j];
                if (left + right == x) {
                    int rightOffset = l.length - j-1;
                    min = Math.min(min, i + rightOffset);
                }
            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }*/

    /*121ms
    Beats 5.25%of users with Java*/
    /*public int minOperations(int[] nums, int x) {
        int[] l = new int[nums.length+1];
        int[] r = new int[nums.length+1];
        l[0] = 0;
        r[0] = 0;
        for (int i = 1; i < l.length; i++) {
            l[i] = nums[i-1]+l[i-1];
            r[i] = nums[r.length-i-1]+r[i-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++) {
            int rest = x - l[i];
            int restPos = bs(r, rest,0,r.length-i-1);
            if (restPos!=-1) {
                int curRes = i + restPos;
                min = Math.min(min, curRes);
            }
            rest = x - r[i];
            restPos = bs(l, rest,0,l.length-i-1);
            if (restPos!=-1) {
                int curRes = i + restPos;
                min = Math.min(min, curRes);
            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }*/



    int bs(int[] arr, int n) {
        return bs(arr, n, 0, arr.length);
    }
    
    //binarySearch
    int bs(int[] arr, int n, int l, int r) {
        if (l==r)
            return (arr[l]==n)?l:-1;
        int mid = (l+r)/2;
        if (n==arr[mid])
            return mid;
        if (mid==l || mid==r)
            return -1;
        if (n > arr[mid])
            return bs(arr, n, mid, r);
        else
            return bs(arr, n, l, mid);
    }

    @Test
    public void testBS() {
        assertEquals(1, bs(new int[]{0,10,12,22,78,100}, 10));
        assertEquals(1, bs(new int[]{0,10,12,22,78}, 10));
        assertEquals(1, bs(new int[]{0,10}, 10));
        assertEquals(1, bs(new int[]{0,10,11}, 10));
        assertEquals(0, bs(new int[]{1}, 1));
        assertEquals(-1, bs(new int[]{1,10,17,56,88,97,123}, 11));
    }

    public int minOperations(int[] nums, int x) {
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int curSum = 0;
        int totalSum = 0;
        for (int n : nums)
            totalSum+=n;
        if (totalSum < x)
            return -1;
        if (totalSum==x)
            return nums.length;
        int rem = totalSum - x;
        while (r<nums.length && l < nums.length) {
            while (r<nums.length && curSum < rem) {
                curSum+=nums[r];
                r++;
            }
            while (r<nums.length && curSum==rem) {
                min=Math.min(min, l + nums.length-r);
                curSum+=nums[r];
                r++;
            }
            while (l < nums.length && curSum > rem) {
                curSum-=nums[l];
                l++;
            }
        }
        if (curSum==rem)
            min=Math.min(min, l + nums.length-r);
        return (min==Integer.MAX_VALUE)?-1:min;
    }

    @Test
    public void test() {
        assertEquals(5, minOperations(new int[]{1,1,1,1,1,10}, 5));
        assertEquals(3, minOperations(new int[]{1000,1,1,2,3}, 1004));
        assertEquals(16, minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
        assertEquals(-1, minOperations(new int[]{1,1}, 3));
        assertEquals(5, minOperations(new int[]{10,1,1,1,1,1}, 5));
        assertEquals(5, minOperations(new int[]{3,2,20,1,1,3}, 10));
        assertEquals(-1, minOperations(new int[]{1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136}, 894887480));
        assertEquals(-1, minOperations(new int[]{5,6,7,8,9}, 4));
        assertEquals(-1, minOperations(new int[]{4}, 5));
        assertEquals(-1, minOperations(new int[]{4}, 5));
        assertEquals(-1, minOperations(new int[]{5}, 4));
        assertEquals(2, minOperations(new int[]{1,1,4,2,3}, 5));
        assertNotEquals(-1, minOperations(new int[]{
                8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309},134365 ));
    }
}
