package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _815 {


    //47 / 49 testcases passed
    /*public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target)
            return 0;
        List<Integer> sourceRoutes = new LinkedList<>();
        List<Integer> targetRoutes = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> list = map.get(routes[i][j]);
                if (list==null)
                    list = new LinkedList<>();
                list.add(i);
                map.put(routes[i][j], list);
                if (routes[i][j] == source) {
                    sourceRoutes.add(i);
                }
                if (routes[i][j] == target) {
                    targetRoutes.add(i);
                }
            }
        }
        boolean[][] adjMat = new boolean[routes.length][routes.length];
        map.forEach((k,v)->{
            if (v.size()>1) {
                for (int i = 0; i < v.size(); i++) {
                    for (int j = 0; j < v.size(); j++) {
                        if (i!=j) {
                            adjMat[v.get(i)][v.get(j)] = true;
                            adjMat[v.get(j)][v.get(i)] = true;
                        }
                    }
                }
            }
        });
        int minDist = Integer.MAX_VALUE;
        //min of dijkstra for each pair of source+target routes
        for (Integer curSourceRoot : sourceRoutes) {
            for (Integer curTarRoot : targetRoutes) {
                if (curSourceRoot == curTarRoot)
                    return 1;
                else {
                    minDist = Math.min(minDist, dijkstra(adjMat, curSourceRoot, curTarRoot));
                }
            }
        }
        return minDist==Integer.MAX_VALUE?-1:minDist;
    }

    private int dijkstra(boolean[][] connected, int sourceRoute, int tarRoute) {
        boolean[] visited = new boolean[connected.length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < connected.length; i++) {
            if (connected[sourceRoute][i]) {
                q.add(new int[]{i,2});
            }
        }
        visited[sourceRoute] = true;
        while (!q.isEmpty()) {
            int[] curRoute = q.poll();
            int curRouteNum = curRoute[0];
            int curLen = curRoute[1];
            if (curRouteNum == tarRoute) {
                return curLen;
            } else {
                for (int i = 0; i < connected.length; i++) {
                    if (!visited[i] && connected[curRouteNum][i]) {
                        q.add(new int[]{i,curLen+1});
                    }
                }
                visited[curRouteNum] = true;
            }
        }
        return Integer.MAX_VALUE;
    }*/

    //47 / 49 TLE
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target) {
            return 0;
        }
        short[] freqs = new short[1_000_000];
        List<Integer> sourceRoutes = new LinkedList<>();
        List<Integer> targetRoutes = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                freqs[routes[i][j]]++;
                if (routes[i][j] == source) {
                    sourceRoutes.add(i);
                }
                if (routes[i][j] == target) {
                    targetRoutes.add(i);
                }
            }
        }
        Set<Integer> dupes = new HashSet<>();
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i]>1)
                dupes.add(i);
        }
        //bs each route to find if dupe is there
        boolean[][] adjMat = new boolean[routes.length][routes.length];
        for (Integer dupe : dupes) {
            List<Integer> dupeRoutes = new LinkedList<>();
            for (int i = 0; i < routes.length; i++) {
                int[] route = routes[i];
                if (bs(route, dupe, 0, route.length)!=-1) {
                    dupeRoutes.add(i);
                }
            }
            for (int i = 0; i < dupeRoutes.size(); i++) {
                for (int j = 0; j < dupeRoutes.size(); j++) {
                    if (i!=j) {
                        adjMat[dupeRoutes.get(i)][dupeRoutes.get(j)] = true;
                        adjMat[dupeRoutes.get(j)][dupeRoutes.get(i)] = true;
                    }
                }
            }
        }
        for (Integer curSourceRoot : sourceRoutes) {
            for (Integer curTarRoot : targetRoutes) {
                if (curSourceRoot == curTarRoot)
                    return 1;
            }
        }
        int minDist = Integer.MAX_VALUE;

        //min of dijkstra for each pair of source+target routes
        for (Integer curSourceRoot : sourceRoutes) {
            for (Integer curTarRoot : targetRoutes) {
                minDist =  Math.min(minDist, dijkstra(adjMat, curSourceRoot, curTarRoot));
            }
        }
        return minDist==Integer.MAX_VALUE?-1:minDist;
    }

    private int bs(int[] route, int k, int l, int r) {
        if (r-l <= 1)
            return (route[l]==k?l:-1);
        int mid = (r+l)/2;
        if (route[mid]==k)
            return mid;
        if (k < route[mid]) {
            return bs(route, k, l, mid);
        }
        else {
            return bs(route, k, mid, r);
        }
    }

    private int dijkstra(boolean[][] connected, int sourceRoute, int tarRoute) {
        boolean[] visited = new boolean[connected.length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < connected.length; i++) {
            if (connected[sourceRoute][i]) {
                q.add(new int[]{i,2});
            }
        }
        visited[sourceRoute] = true;
        while (!q.isEmpty()) {
            int[] curRoute = q.poll();
            int curRouteNum = curRoute[0];
            int curLen = curRoute[1];
            if (curRouteNum == tarRoute) {
                return curLen;
            } else {
                for (int i = 0; i < connected.length; i++) {
                    if (!visited[i] && connected[curRouteNum][i]) {
                        q.add(new int[]{i,curLen+1});
                    }
                }
                visited[curRouteNum] = true;
            }
        }
        return Integer.MAX_VALUE;
    }

    @Test
    public void testBS() {
        assertEquals(1, bs(new int[]{1,2,3,4,5}, 2, 0, 5));
        assertEquals(-1, bs(new int[]{1,2,3,4,5}, 0, 0, 5));
        assertEquals(-1, bs(new int[]{1,2,3,4,5}, 7, 0, 5));
        assertEquals(-1, bs(new int[]{1,2,3,5,6}, 4, 0, 5));
        assertEquals(-1, bs(new int[]{1}, 4, 0, 1));
        assertEquals(0, bs(new int[]{1}, 1, 0, 1));
        assertEquals(-1, bs(new int[]{1}, 0, 0, 1));
        assertEquals(0, bs(new int[]{1,2}, 1, 0, 2));
        assertEquals(-1, bs(new int[]{1,5}, 2, 0, 2));
        assertEquals(-1, bs(new int[]{1,5}, 3, 0, 2));
        assertEquals(-1, bs(new int[]{1,5}, 4, 0, 2));
        assertEquals(0, bs(new int[]{1,2,3}, 1, 0, 3));
        assertEquals(2, bs(new int[]{1,2,3}, 3, 0, 3));
        assertEquals(1, bs(new int[]{1,2,3}, 2, 0, 3));
    }


    @Test
    public void test() {
        assertEquals(-1, numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}}, 15, 12));
        assertEquals(2, numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
    }
}
