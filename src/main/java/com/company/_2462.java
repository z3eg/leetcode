package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/*2462. Total Cost to Hire K Workers
        https://leetcode.com/problems/total-cost-to-hire-k-workers/*/
public class _2462 {

    //TLE
    /*public long totalCost(int[] costs, int k, int candidates) {
        List<Integer> ints = new LinkedList<>();
        for (int cost : costs) {
            ints.add(cost);
        }
        int res = 0;
        while (k>0) {
            int minIdx = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < candidates && i < ints.size(); i++) {
                if (min > ints.get(i)) {
                    min = ints.get(i);
                    minIdx = i;
                }
                if (min > ints.get(ints.size()-1-i)) {
                    min = ints.get(ints.size()-1-i);
                    minIdx = ints.size()-1-i;
                }
            }
            res+=min;
            ints.remove(minIdx);
            k--;
        }
        return res;
    }*/

    //TLE ( 132)
    /*public long totalCost(int[] costs, int k, int candidates) {
        int costLen = costs.length;
        int l = candidates;
        int r = costLen - candidates -1;
        int res = 0;
        int posToAdd = -1;
        while (k > 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < l && i < costLen; i++) {
                if (min > costs[i]) {
                    min = costs[i];
                    posToAdd = i;
                }
            }
            for (int i = costLen-1; i > r && i > 0; i--) {
                if (min > costs[i]) {
                    min = costs[i];
                    posToAdd = i;
                }
            }
            if (posToAdd<=l) {
                l++;
            }
            else {
                r--;
            }
            res+=costs[posToAdd];
            costs[posToAdd] = Integer.MAX_VALUE;
            k--;
        }
        return res;
    }*/

    public long totalCost(int[] costs, int k, int candidates) {
        Set<Long> hashes = new TreeSet<>();
        int costLen = costs.length;
        for (int i = 0; i < candidates; i++) {
            hashes.add(hash(costs[i],i));
            hashes.add(hash(costs[costLen-i-1],costLen-i-1));
        }
        int l = candidates;
        int r = costLen - candidates - 1;
        int res = 0;
        while (k > 0) {
            Iterator<Long> iterator = hashes.iterator();
            Long next = iterator.next();
            iterator.remove();
            res+=getVal(next);
            int pos = getPos(next);
            if (pos < l && l < costLen) {
                hashes.add(hash(costs[l], l));
                l++;
            }
            else if (r > 0){
                hashes.add(hash(costs[r], r));
                r--;
            }
            k--;
        }
        return res;
    }

    long hash(int val, int pos) {
        return val* 10001L + pos;
    }

    int getVal(long hash) {
        return (int) (hash/10001);
    }

    int getPos(long hash) {
        return (int) (hash%10001);
    }

    @Test
    public void test() {
        assertEquals(11, totalCost(new int[]{17,12,10,2,7,2,11,20,8},3,4));
        assertEquals(4, totalCost(new int[]{1,2,4,1},3,3));
        assertEquals(7, totalCost(new int[]{1,2,4},3,3));
    }
}
