package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1971 {

    /*Memory Limit Exceeded
    22 / 30 testcases passed*/
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        boolean[][] paths = new boolean[n][n];
        for (int[] edge : edges) {
            paths[edge[0]][edge[1]] = true;
            paths[edge[1]][edge[0]] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            if (poll == destination)
                return true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && paths[i][poll]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return false;
    }
}
