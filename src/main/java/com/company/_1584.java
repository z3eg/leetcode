package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=daily-question&envId=2023-09-15
1584. Min Cost to Connect All Points*/
public class _1584 {

    /*Time Limit Exceeded
    44 / 72 testcases passed*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        Set<Integer> taken = new HashSet<Integer>();
        int[][] dists = new int[points.length*(points.length-1)][3];
        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i!=j) {
                    int dist = manDist(points[i], points[j]);
                    dists[counter][0] = dist;
                    dists[counter][1] = i;
                    dists[counter][2] = j;
                    counter++;
                }
            }
        }
        //sort the array
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < dists.length - 1; i++) {
                if (dists[i][0] > dists[i+1][0]) {
                    int[] tmp = dists[i];
                    dists[i]=dists[i+1];
                    dists[i+1] = tmp;
                    sorted = false;
                }
            }
        }
        int res = 0;
        res+=dists[0][0];
        taken.add(dists[0][1]);
        taken.add(dists[0][2]);
        while (taken.size()<points.length) {
            for (int i = 1; i < dists.length; i++) {
                if ((taken.contains(dists[i][1]) || taken.contains(dists[i][2])) &&
                        !(taken.contains(dists[i][1]) && taken.contains(dists[i][2]))) {
                    res+=dists[i][0];
                    taken.add(dists[i][1]);
                    taken.add(dists[i][2]);
                    break;
                }
            }
        }
        return res;
    }

    int manDist(int[] source, int[] dest) {
        return Math.abs(source[0] - dest[0]) + Math.abs(source[1] - dest[1]);
    }*/

    /*Time Limit Exceeded
    52 / 72 testcases passed*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        Set<Integer> taken = new HashSet<>();
        int[][] dists = new int[points.length*(points.length+1)/2][3];
        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int dist = manDist(points[i], points[j]);
                dists[counter][0] = dist;
                dists[counter][1] = i;
                dists[counter][2] = j;
                counter++;
            }
        }
        //sort the array
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < dists.length - 1; i++) {
                if (dists[i][0] > dists[i+1][0]) {
                    int[] tmp = dists[i];
                    dists[i]=dists[i+1];
                    dists[i+1] = tmp;
                    sorted = false;
                }
            }
        }
        int res = 0;
        res+=dists[0][0];
        taken.add(dists[0][1]);
        taken.add(dists[0][2]);
        while (taken.size()<points.length) {
            for (int i = 1; i < dists.length; i++) {
                if ((taken.contains(dists[i][1]) || taken.contains(dists[i][2])) &&
                        !(taken.contains(dists[i][1]) && taken.contains(dists[i][2]))) {
                    res+=dists[i][0];
                    taken.add(dists[i][1]);
                    taken.add(dists[i][2]);
                    break;
                }
            }
        }
        return res;
    }*/


    /*Time Limit Exceeded
    54 / 72 testcases passed*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        Set<Integer> taken = new HashSet<>();
        int[][] dists = new int[points.length*(points.length-1)/2][3];
        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int dist = manDist(points[i], points[j]);
                dists[counter][0] = dist;
                dists[counter][1] = i;
                dists[counter][2] = j;
                counter++;
            }
        }
        //sort the array
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < dists.length - 1; i++) {
                if (dists[i][0] > dists[i+1][0]) {
                    int[] tmp = dists[i];
                    dists[i]=dists[i+1];
                    dists[i+1] = tmp;
                    sorted = false;
                }
            }
        }
        int res = 0;
        res+=dists[0][0];
        taken.add(dists[0][1]);
        taken.add(dists[0][2]);
        while (taken.size()<points.length) {
            for (int i = 1; i < dists.length; i++) {
                if ((taken.contains(dists[i][1]) || taken.contains(dists[i][2])) &&
                        !(taken.contains(dists[i][1]) && taken.contains(dists[i][2]))) {
                    res+=dists[i][0];
                    taken.add(dists[i][1]);
                    taken.add(dists[i][2]);
                    break;
                }
            }
        }
        return res;
    }*/

    /*Time Limit Exceeded
    65 / 72 testcases passed*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        Set<Integer> taken = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        taken.add(0);
        List<Integer> available = new ArrayList<>();
        for (int i = 1; i < points.length; i++) {
            available.add(i);
        }
        int res = 0;
        while (taken.size() < points.length) {
            Integer minD = available.get(0);
            int minLen = Integer.MAX_VALUE;
            for (int t : taken) {
                for (int a : available) {
                    Integer curLen = map.get(t+"_"+a);
                    if (curLen==null) {
                        curLen = map.get(a+"_"+t);
                    }
                    if (curLen==null) {
                        curLen = manDist(points[t], points[a]);
                        map.put(t+"_"+a, curLen);
                        map.put(a+"_"+t, curLen);
                    }
                    if (curLen < minLen) {
                        minD = a;
                        minLen = curLen;
                    }
                }
            }
            taken.add(minD);
            available.remove(minD);
            res+=minLen;
        }
        return res;
    }*/

    /*Time Limit Exceeded
    72 / 72 testcases passed
    Testcases passed, but took too long.*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        List<Integer> taken = new ArrayList<>(points.length);
        taken.add(0);
        List<Integer> available = new ArrayList<>(points.length);
        for (int i = 1; i < points.length; i++) {
            available.add(i);
        }
        int res = 0;
        while (taken.size() < points.length) {
            Integer minD = available.get(0);
            int minLen = Integer.MAX_VALUE;
            for (int t : taken) {
                for (int a : available) {
                    int curLen = manDist(points[t], points[a]);
                    if (curLen < minLen) {
                        minD = a;
                        minLen = curLen;
                    }
                }
            }
            taken.add(minD);
            available.remove(minD);
            res+=minLen;
        }
        return res;
    }*/

    /*Runtime
    2241ms
    Beats 5.04%of users with Java*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        List<Integer> taken = new ArrayList<>(points.length);
        int[][] dists = new int[points.length][points.length];
        taken.add(0);
        List<Integer> available = new ArrayList<>(points.length);
        for (int i = 1; i < points.length; i++) {
            available.add(i);
        }
        int res = 0;
        while (taken.size() < points.length) {
            Integer minD = available.get(0);
            int minLen = Integer.MAX_VALUE;
            for (int t : taken) {
                for (int a : available) {
                    int curLen;
                    if (dists[t][a]!=0)
                        curLen = dists[t][a];
                    else if (dists[a][t]!=0)
                        curLen = dists[a][t];
                    else {
                        curLen = manDist(points[t], points[a]);
                        dists[t][a] = curLen;
                        dists[a][t] = curLen;
                    }
                    if (curLen < minLen) {
                        minD = a;
                        minLen = curLen;
                    }
                }
            }
            taken.add(minD);
            available.remove(minD);
            res+=minLen;
        }
        return res;
    }*/

    /*Runtime
    1689ms
    Beats 5.04%of users with Java*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        boolean[] taken = new boolean[points.length];
        int[][] dists = new int[points.length][points.length];
        taken[0] = true;
        List<Integer> available = new ArrayList<>(points.length);
        for (int i = 1; i < points.length; i++) {
            available.add(i);
        }
        int res = 0;
        int counter = 1;
        while (counter < points.length) {
            Integer minD = available.get(0);
            int minLen = Integer.MAX_VALUE;
            for (int t = 0; t < points.length; t++) {
                if (taken[t]) {
                    for (int a = 0; a < points.length; a++) {
                        if (!taken[a]) {
                            int curLen;
                            if (dists[t][a]!=0)
                                curLen = dists[t][a];
                            else if (dists[a][t]!=0)
                                curLen = dists[a][t];
                            else {
                                curLen = manDist(points[t], points[a]);
                                dists[t][a] = curLen;
                                dists[a][t] = curLen;
                            }
                            if (curLen < minLen) {
                                minD = a;
                                minLen = curLen;
                            }
                        }
                    }
                }
            }
            taken[minD]=true;
            res+=minLen;
            counter++;
        }
        return res;
    }*/

    /*Runtime
    1290ms
    Beats 5.04%of users with Java*/
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        boolean[] taken = new boolean[points.length];
        int[][] dists = new int[points.length][points.length];
        taken[0] = true;
        List<Integer> available = new ArrayList<>(points.length);
        for (int i = 1; i < points.length; i++) {
            available.add(i);
        }
        int res = 0;
        int counter = 1;
        while (counter < points.length) {
            Integer minD = available.get(0);
            int minLen = Integer.MAX_VALUE;
            for (int t = 0; t < points.length; t++) {
                if (taken[t]) {
                    for (int a = 0; a < points.length; a++) {
                        if (!taken[a]) {
                            int curLen;
                            if (dists[t][a]!=0)
                                curLen = dists[t][a];
                            else {
                                curLen = manDist(points[t], points[a]);
                                dists[t][a] = curLen;
                                dists[a][t] = curLen;
                            }
                            if (curLen < minLen) {
                                minD = a;
                                minLen = curLen;
                            }
                        }
                    }
                }
            }
            taken[minD]=true;
            res+=minLen;
            counter++;
        }
        return res;
    }*/

    /*Runtime
    1283 ms
                Beats
    5.4%
    */
    /*public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        boolean[] taken = new boolean[points.length];
        int[][] dists = new int[points.length][points.length];
        taken[0] = true;
        int res = 0;
        int counter = 1;
        while (counter < points.length) {
            int minD = 0;
            int minLen = Integer.MAX_VALUE;
            for (int t = 0; t < points.length; t++) {
                if (taken[t]) {
                    for (int a = 0; a < points.length; a++) {
                        if (!taken[a]) {
                            int curLen;
                            if (dists[t][a]!=0)
                                curLen = dists[t][a];
                            else {
                                curLen = manDist(points[t], points[a]);
                                dists[t][a] = curLen;
                                dists[a][t] = curLen;
                            }
                            if (curLen < minLen) {
                                minD = a;
                                minLen = curLen;
                            }
                        }
                    }
                }
            }
            taken[minD]=true;
            res+=minLen;
            counter++;
        }
        return res;
    }*/

    /*1260ms
    Beats 5.04%of users with Java*/
    public int minCostConnectPoints(int[][] points) {
        if (points.length==1) {
            return 0;
        }
        boolean[] taken = new boolean[points.length];
        int[][] dists = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                dists[i][j] = manDist(points[i], points[j]);
            }
        }
        taken[0] = true;
        int res = 0;
        int counter = 1;
        while (counter < points.length) {
            int minD = 0;
            int minLen = Integer.MAX_VALUE;
            for (int t = 0; t < points.length; t++) {
                if (taken[t]) {
                    for (int a = 0; a < points.length; a++) {
                        if (!taken[a]) {
                            int curLen = dists[t][a];
                            if (curLen < minLen) {
                                minD = a;
                                minLen = curLen;
                            }
                        }
                    }
                }
            }
            taken[minD]=true;
            res+=minLen;
            counter++;
        }
        return res;
    }

    int manDist(int[] source, int[] dest) {
        return Math.abs(source[0] - dest[0]) + Math.abs(source[1] - dest[1]);
    }

    @Test
    public void testManDist() {
        assertEquals(4, manDist(new int[]{0,0}, new int[]{2,2}));
        assertEquals(4, manDist(new int[]{2,2}, new int[]{0,0}));
    }

    @Test
    public void test() {
        assertEquals(20,minCostConnectPoints(new int[][]{{0,0},{2,2},{5,2},{7,0},{3,10}}));
        assertEquals(20,minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        assertEquals(4,minCostConnectPoints(new int[][]{{0,0},{2,2}}));
        assertEquals(0,minCostConnectPoints(new int[][]{{0,0}}));
        assertEquals(53 ,minCostConnectPoints(new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}}));
        assertEquals(18,minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));
    }
}
