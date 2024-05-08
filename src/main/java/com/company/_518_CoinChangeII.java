package com.company;

import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.*;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/coin-change-ii/
public class _518_CoinChangeII {

    /*Time Limit Exceeded
8 / 28 testcases passed*/
    /*public int change(int amount, int[] coins) {
        HashSet<List<Integer>> set = new HashSet<>();
        change(new LinkedList<>(), amount, coins, set);
        return set.size();
    }

    public void change(List<Integer> curStr, int leftover, int[] coins, Set<List<Integer>> set) {
        if (leftover >= 0) {
            if (leftover == 0) {
                Collections.sort(curStr);
                set.add(curStr);
            }
            else {
                for (int c : coins) {
                    int newLO = leftover-c;
                    List<Integer> newStr = new LinkedList<>(curStr);
                    newStr.add(c);
                    change(newStr, newLO, coins, set);
                }
            }
        }
    }*/


    /*Time Limit Exceeded
8 / 28 testcases passed*/
    /*public int change(int amount, int[] coins) {
        HashSet<Map<Integer, Integer>> set = new HashSet<>();
        change(new TreeMap<>(), amount, coins, set);
        return set.size();
    }

    public void change(Map<Integer, Integer> curStr, int leftover, int[] coins, Set<Map<Integer, Integer>> set) {
        if (leftover >= 0) {
            if (leftover == 0) {
                set.add(curStr);
            }
            else {
                for (int c : coins) {
                    int newLO = leftover-c;
                    Map<Integer, Integer> newStr = new TreeMap<>(curStr);
                    Integer val = newStr.get(c);
                    if (val == null)
                        val = 0;
                    val++;
                    newStr.put(c, val);
                    change(newStr, newLO, coins, set);
                }
            }
        }
    }*/

    //gives all unique combinations
    public int change(int amount, int[] coins) {
        return change(amount, coins, 0);
    }

    public int change(int leftover, int[] coins, int total) {
        if (leftover >= 0) {
            if (leftover == 0) {
                total++;
            }
            else {
                for (int c : coins) {
                    int newLO = leftover-c;
                    total = change(newLO, coins, total);
                }
            }
        }
        return total;
    }

    /*public int change(int amount, int[] coins) {
        int[] coinAms = new int[5001];
        Set<String> set = new HashSet<>();
        change(coinAms, amount, coins, set);
        return set.size();
    }

    public void change(int[] coinAms, int leftover, int[] coins, Set<String> set) {
        if (leftover >= 0) {
            if (leftover == 0) {
                set.add(Arrays.toString(coinAms));
            }
            else {
                for (int c : coins) {
                    int newLO = leftover-c;
                    coinAms[c]++;
                    change(coinAms, newLO, coins, set);
                    coinAms[c]--;
                }
            }
        }
    }*/

    @Test
    public void test() {
        /*assertEquals(4, */change(500, new int[]{1,2,5});
        assertEquals(4, change(5, new int[]{1,2,5}));
        assertEquals(0, change(3, new int[]{2}));
        assertEquals(1, change(10, new int[]{10}));
    }
}
