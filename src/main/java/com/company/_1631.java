package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

//1631. Path With Minimum Effort
public class _1631 {
    //naive recursion
    /*Time Limit Exceeded
    8 / 75 testcases passed*/
    /*public int minimumEffortPath(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        return move(heights, visited, 0, 0, 0, Integer.MAX_VALUE);
    }

    int move(int[][] heights, boolean[][] visited, int r, int c, int curMaxEff, int minEff) {
        if (r==heights.length-1 && c== heights[0].length-1)
            return Math.min(minEff, curMaxEff);
        if (r+1<heights.length && !visited[r+1][c]) {
            visited[r+1][c] = true;
            minEff = move(heights, visited,r+1,c,Math.max(curMaxEff,Math.abs(heights[r+1][c]-heights[r][c])),minEff);
            visited[r+1][c] = false;
        }
        if (c+1<heights[0].length && !visited[r][c+1]) {
            visited[r][c+1] = true;
            minEff = move(heights, visited,r,c+1,Math.max(curMaxEff,Math.abs(heights[r][c+1]-heights[r][c])),minEff);
            visited[r][c+1] = false;
        }
        if (r-1>=0 && !visited[r-1][c]) {
            visited[r-1][c] = true;
            minEff = move(heights, visited,r-1,c,Math.max(curMaxEff,Math.abs(heights[r-1][c]-heights[r][c])),minEff);
            visited[r-1][c] = false;
        }
        if (c-1>=0 && !visited[r][c-1]) {
            visited[r][c-1] = true;
            minEff = move(heights, visited,r,c-1,Math.max(curMaxEff,Math.abs(heights[r][c-1]-heights[r][c])),minEff);
            visited[r][c-1] = false;
        }
        return minEff;
    }*/

    /*110ms
    Beats 15.08%of users with Java*/
    /*public int minimumEffortPath(int[][] heights) {
        int[][] dists = new int[heights.length][heights[0].length];
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                dists[i][j] = Integer.MAX_VALUE;
            }
        }
        dists[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            if (r +1<heights.length) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r +1][c]-heights[r][c]));
                if (newDist < dists[r +1][c]) {
                    dists[r +1][c]=newDist;
                    q.add(new int[]{r+1,c});
                }
            }
            if (r -1>=0) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r -1][c]-heights[r][c]));
                if (newDist < dists[r -1][c]) {
                    dists[r -1][c]=newDist;
                    q.add(new int[]{r-1,c});
                }
            }
            if (c +1<heights[0].length) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r][c+1]-heights[r][c]));
                if (newDist < dists[r][c+1]) {
                    dists[r][c+1]=newDist;
                    q.add(new int[]{r,c+1});
                }
            }
            if (c -1>=0) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r][c-1]-heights[r][c]));
                if (newDist < dists[r][c-1]) {
                    dists[r][c-1]=newDist;
                    q.add(new int[]{r,c-1});
                }
            }
        }
        return dists[dists.length-1][dists[0].length-1];
    }*/

    /*103ms
    Beats 15.96%of users with Java*/
    public int minimumEffortPath(int[][] heights) {
        int[][] dists = new int[heights.length][heights[0].length];
        for (int i = 0; i < dists.length; i++) {
            for (int j = 0; j < dists[0].length; j++) {
                dists[i][j] = Integer.MAX_VALUE;
            }
        }
        dists[0][0] = 0;
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        qr.add(0);
        qc.add(0);
        while (!qr.isEmpty()) {
            int r = qr.poll();
            int c = qc.poll();
            if (r +1<heights.length) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r +1][c]-heights[r][c]));
                if (newDist < dists[r +1][c]) {
                    dists[r +1][c]=newDist;
                    qr.add(r+1);
                    qc.add(c);
                }
            }
            if (r -1>=0) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r -1][c]-heights[r][c]));
                if (newDist < dists[r -1][c]) {
                    dists[r -1][c]=newDist;
                    qr.add(r-1);
                    qc.add(c);
                }
            }
            if (c +1<heights[0].length) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r][c+1]-heights[r][c]));
                if (newDist < dists[r][c+1]) {
                    dists[r][c+1]=newDist;
                    qr.add(r);
                    qc.add(c+1);
                }
            }
            if (c -1>=0) {
                int newDist = Math.max(dists[r][c], Math.abs(heights[r][c-1]-heights[r][c]));
                if (newDist < dists[r][c-1]) {
                    dists[r][c-1]=newDist;
                    qr.add(r);
                    qc.add(c-1);
                }
            }
        }
        return dists[dists.length-1][dists[0].length-1];
    }

    @Test
    public void test() {
        assertEquals(6,minimumEffortPath(new int[][]{{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}}));
        assertEquals(2,minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
        assertEquals(1,minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
        assertEquals(0,minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
    }
}
