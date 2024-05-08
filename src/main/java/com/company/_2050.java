package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*2050. Parallel Courses III
        https://leetcode.com/problems/parallel-courses-iii/description/?envType=daily-question&envId=2023-10-18*/
public class _2050 {

    //nah this is bullshit
    /*class Node {
        public int length;
        public int totalDur;
        public List<Node> nexts;

        public Node(int length) {
            this.length = length;
            this.totalDur = length;
        }

        public Node(int length, List<Node> nexts) {
            this.length = length;
            this.nexts = nexts;
            this.totalDur = length;
        }
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        Set<Integer> starters = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int courseNum = i+1;
            boolean isStarter = true;
            for (int[] rel : relations) {
                if (rel[1] == courseNum) {
                    isStarter = false;
                    break;
                }
            }
            if (isStarter)
                starters.add(courseNum);
        }
        for (int s : starters) {
            Node course = new Node(time[s - 1]);
            q.add(course);
        }
//        while (visited.size() < n) {
        while (!q.isEmpty()) {
            Node curCourse = q.poll();

        }
    }*/

    /*TLE 19 / 42 testcases passed. Not actually an optimisation lol*/
    /*public int minimumTime(int n, int[][] relations, int[] time) {
        if (n==1)
            return time[0];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] dp = new int[n+1];
        List<Integer> finals = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isFinal = true;
            for (int[] relation : relations) {
                Set<Integer> prevs = map.get(relation[1]);
                if (prevs==null)
                    prevs = new HashSet<>();
                prevs.add(relation[0]);
                map.put(relation[1], prevs);
                if (relation[0] == i)
                    isFinal = false;
            }
            if (isFinal)
                finals.add(i);
        }
        int res = 0;
        for (Integer finalCourse : finals) {
            res = Math.max(res, dp(finalCourse, map, time, dp));
        }
        return res;
    }

    int dp(int n, Map<Integer, Set<Integer>> map, int[] time, int[]dp) {
        if (dp[n]!=0)
            return dp[n];
        Set<Integer> prevs = map.get(n);
        if (prevs!=null)
            for (int prev : prevs)
                dp[n] = Math.max(dp[n], dp(prev, map, time, dp));
        dp[n]+=time[n-1];
        return dp[n];
    }*/

    /*Time Limit Exceeded
    38 / 42 testcases passed*/
    /*public int minimumTime(int n, int[][] relations, int[] time) {
        if (n==1)
            return time[0];
        int[] dp = new int[n+1];
        List<Integer> finishers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isFinisher = true;
            for (int[] relation : relations) {
                if (relation[0] == i) {
                    isFinisher = false;
                    break;
                }
            }
            if (isFinisher)
                finishers.add(i);
        }
        int res = 0;
        for (Integer finisher : finishers) {
            res = Math.max(res, dp(finisher, relations, time, dp));
        }
        return res;
    }

    int dp(int n, int[][] relations, int[] time, int[]dp) {
        if (dp[n]!=0)
            return dp[n];
        for (int[] relation : relations) {
            int curCourse = relation[1];
            if (curCourse == n) {
                int prevCourse = relation[0];
                dp[n] = Math.max(dp[n], dp(prevCourse, relations, time, dp));
            }
        }
        dp[n]+=time[n-1];
        return dp[n];
    }*/

    /*public int minimumTime(int n, int[][] relations, int[] time) {
        if (n==1)
            return time[0];
        int[] dp = new int[n+1];
        List<Integer> finals = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isFinalCourse = true;
            for (int[] relation : relations) {
                if (relation[0] == i) {
                    isFinalCourse = false;
                    break;
                }
            }
            if (isFinalCourse)
                finals.add(i);
        }
        int res = 0;
        for (Integer finalCourse : finals) {
            res = Math.max(res, dp(finalCourse, relations, time, dp));
        }
        return res;
    }

    int dp(int n, int[][] relations, int[] time, int[]dp) {
        if (dp[n]!=0)
            return dp[n];
        for (int[] relation : relations) {
            int curCourse = relation[1];
            if (curCourse == n) {
                int prevCourse = relation[0];
                dp[n] = Math.max(dp[n], dp(prevCourse, relations, time, dp));
            }
        }
        dp[n]+=time[n-1];
        return dp[n];
    }*/

    /*2259ms
    Beats 6.22%of users with Java*/
    public int minimumTime(int n, int[][] relations, int[] time) {
        if (n==1)
            return time[0];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] dp = new int[n+1];
        List<Integer> finals = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isFinal = true;
            for (int[] relation : relations) {
                if (relation[0] == i) {
                    isFinal = false;
                    break;
                }
            }
            if (isFinal)
                finals.add(i);
        }
        for (int[] relation : relations) {
            Set<Integer> prevs = map.get(relation[1]);
            if (prevs==null)
                prevs = new HashSet<>();
            prevs.add(relation[0]);
            map.put(relation[1], prevs);
        }
        int res = 0;
        for (Integer finalCourse : finals) {
            res = Math.max(res, dp(finalCourse, map, time, dp));
        }
        return res;
    }

    int dp(int n, Map<Integer, Set<Integer>> map, int[] time, int[]dp) {
        if (dp[n]!=0)
            return dp[n];
        Set<Integer> prevs = map.get(n);
        if (prevs!=null)
            for (int prev : prevs)
                dp[n] = Math.max(dp[n], dp(prev, map, time, dp));
        dp[n]+=time[n-1];
        return dp[n];
    }

    @Test
    public void test() {
        assertEquals(5, minimumTime(2, new int[][]{}, new int[]{5,3}));
        assertEquals(5, minimumTime(1, new int[][]{}, new int[]{5}));
        assertEquals(7, minimumTime(3, new int[][]{{2,3}}, new int[]{5,3,4}));
        assertEquals(5, minimumTime(3, new int[][]{{2,3}}, new int[]{5,3,1}));
        assertEquals(8, minimumTime(3, new int[][]{{1,3},{2,3}}, new int[]{3,2,5}));
        assertEquals(12, minimumTime(5, new int[][]{{1,5},{2,5},{3,5},{3,4},{4,5}}, new int[]{1,2,3,4,5}));
    }
}
