package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/range-sum-query-mutable/
public class _307_RangeSumQueryMutable {

    //cumulative sum: (still not fast enough :( )
    class NumArray {

        int[] arr;
        int[] cumulativeSums;
        int[] changes;

        public NumArray(int[] nums) {
            arr = nums;
            cumulativeSums = new int[arr.length];
            changes = new int[arr.length];
            cumulativeSums[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                cumulativeSums[i] = cumulativeSums[i-1] + arr[i];
            }
        }

        public void update(int index, int val) {
            int diff = val-arr[index];
            if (diff!=0) {
                arr[index] = val;
                changes[index]+=diff;
                /*for (int i = index; i < arr.length; i++) {
                    cumulativeSums[i]+=diff;
                }*/
            }
        }

        public int sumRange(int left, int right) {
            int cumsum = cumulativeSums[right]-((left==0)?0:cumulativeSums[left-1]);
            for (int i = left; i <= right; i++) {
                cumsum+=changes[i];
            }
            return cumsum;
        }
    }

    //caching sums proved ineffective
    /*class NumArray {

        int[] arr;
        Map<Integer,Integer> sumCache;

        public NumArray(int[] nums) {
            this.arr = nums;
            sumCache = new HashMap<>();
        }

        public void update(int index, int val) {
            int oldVal = arr[index];
            int diff = val-oldVal;
            sumCache.forEach((key,v)->{
                if (index >= Integer.parseInt(k[0]) && index <= Integer.parseInt(k[1])) {
                    sumCache.put(key, v + diff);
                }
            });
            arr[index] = val;
        }

        public int sumRange(int left, int right) {
            String k = new StringBuilder().append(left).append("_").append(right).toString();
            return sumCache.computeIfAbsent(k,(key)->{
                String[] s = key.split("_");
                int l = Integer.parseInt(s[0]);
                int r = Integer.parseInt(s[1]);
                int sum = 0;
                for (int i = l; i <= r; i++) {
                    sum+=arr[i];
                }
                return sum;
            });
        }

        private int hash(int l, int r) {
            return l*r+(l+r);
        }
    }*/

    @Test
    public void test() {
        NumArray numArray = new NumArray(new int[]{-1});
        numArray.sumRange(0, 0); // return 1 + 3 + 5 = 9
        numArray.update(0, 1);   // nums = [1, 2, 5]
        numArray.sumRange(0, 0); // return 1 + 2 + 5 = 8
    }
}
