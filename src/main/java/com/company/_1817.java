package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;

/*https://leetcode.com/problems/finding-the-users-active-minutes/
        1817. Finding the Users Active Minutes*/
public class _1817 {
    /*public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        HashMap<Integer, boolean[]> userMinutes = new HashMap<>();
        for (int[] log : logs) {
            if (log[1] <= k) {
                boolean[] minutes = userMinutes.get(log[0]);
                if (minutes==null)
                    minutes = new boolean[k];
                minutes[log[1]-1] = true;
                userMinutes.put(log[0], minutes);
            }
        }
        for (Map.Entry<Integer, boolean[]> entry : userMinutes.entrySet()) {
            int totalActiveMinutes = 0;
            boolean[] curUserMinutes = entry.getValue();
            for (boolean minute: curUserMinutes) {
                totalActiveMinutes+=minute?1:0;
            }
            if (totalActiveMinutes < res.length)
                res[totalActiveMinutes-1]++;
        }
        return res;
    }*/

      /*Runtime
        19 ms
        Beats
        88.83%*/
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, Set<Integer>> userActiveMinutesMap = new HashMap<>();
        for (int[] log : logs) {
            int userId = log[0];
            int activeMinute = log[1];
            Set<Integer> userActiveMinutes = userActiveMinutesMap.get(userId);
            if (userActiveMinutes == null) {
                userActiveMinutes = new HashSet<>();
            }
            userActiveMinutes.add(activeMinute);
            userActiveMinutesMap.put(userId, userActiveMinutes);
        }
        int[] res = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : userActiveMinutesMap.entrySet()) {
            int activeMinutesForCurrentUser = entry.getValue().size();
            if (activeMinutesForCurrentUser <= k) {
                res[activeMinutesForCurrentUser-1]++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,0,1,0,0,0}, findingUsersActiveMinutes(new int[][]{{305589003,4136},{305589004,4139},{305589004,4141},{305589004,4137},{305589001,4139},{305589001,4139}}, 6));
        assertArrayEquals(new int[]{0,2,0,0,0}, findingUsersActiveMinutes(new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5));
        assertArrayEquals(new int[]{1,1,0,0}, findingUsersActiveMinutes(new int[][]{{1,1},{2,2},{2,3}}, 4));
    }
}
