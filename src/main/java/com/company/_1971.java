package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1971 {

    /*Memory Limit Exceeded
    22 / 30 testcases passed*/
    /*public boolean validPath(int n, int[][] edges, int source, int destination) {
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
    }*/

    /*Wrong Answer
    23 / 30 testcases passed*/
    /*public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        visited[source] = true;
        boolean newPathFound = true;
        while (newPathFound) {
            newPathFound = false;
            for (int[] edge : edges) {
                if (visited[edge[0]] && !visited[edge[1]]) {
                    if (edge[1]==destination)
                        return true;
                    newPathFound = true;
                    visited[edge[1]] = true;
                }
                if (visited[edge[1]] && !visited[edge[0]]) {
                    newPathFound = true;
                    visited[edge[0]] = true;
                }
            }
        }
        return false;
    }*/

    /*Wrong Answer
    25 / 30 testcases passed*/
    /*public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source==destination)
            return true;
        if (edges.length==0)
            return false;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        boolean newPathFound = true;
        while (newPathFound) {
            newPathFound = false;
            for (int[] edge : edges) {
                if (visited[edge[0]] && !visited[edge[1]]) {
                    if (edge[1]==destination)
                        return true;
                    newPathFound = true;
                    visited[edge[1]] = true;
                }
                if (visited[edge[1]] && !visited[edge[0]]) {
                    newPathFound = true;
                    visited[edge[0]] = true;
                }
            }
        }
        return false;
    }*/

    /*3
    ms
    Beats
    99.62%
    of users with Java*/
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source==destination)
            return true;
        if (edges.length==0)
            return false;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        boolean newPathFound = true;
        while (newPathFound) {
            newPathFound = false;
            if (visited[destination])
                return true;
            for (int[] edge : edges) {
                if (visited[edge[0]] && !visited[edge[1]]) {
                    newPathFound = true;
                    visited[edge[1]] = true;
                }
                if (visited[edge[1]] && !visited[edge[0]]) {
                    newPathFound = true;
                    visited[edge[0]] = true;
                }
            }
        }
        return false;
    }

}
