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

    public int numBusesToDestination(int[][] routes, int source, int target) {
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
    }

    @Test
    public void test() {
        assertEquals(-1, numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}}, 15, 12));
        assertEquals(2, numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
    }
}
