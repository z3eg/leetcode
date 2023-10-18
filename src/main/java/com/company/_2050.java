package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

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

    /*Time Limit Exceeded
    38 / 42 testcases passed*/
    public int minimumTime(int n, int[][] relations, int[] time) {
        if (n==1)
            return time[0];
        int[] dp = new int[n+1];
        List<Integer> finishers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean isFinisher = true;
            for (int j = 0; j < relations.length; j++) {
                if (relations[j][0] == i) {
                    isFinisher = false;
                    break;
                }
            }
            if (isFinisher)
                finishers.add(i);
        }
        int res = 0;
        for (int i = 0; i < finishers.size(); i++) {
            res = Math.max(res, dp(finishers.get(i), relations, time, dp));
        }
        return res;
    }

    int dp(int n, int[][] relations, int[] time, int[]dp) {
        if (dp[n]!=0)
            return dp[n];

        for (int j = 0; j < relations.length; j++) {
            int curCourse = relations[j][1];
            if (curCourse == n) {
                int prevCourse = relations[j][0];
                dp[n] = Math.max(dp[n], time[n-1] + dp(prevCourse,relations,time,dp));
            }
        }
        if (dp[n] == 0)
            dp[n] = time[n-1];
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
