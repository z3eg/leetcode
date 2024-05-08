package com.company;

/*1450. Number of Students Doing Homework at a Given Time
        https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/*/
public class _1450 {
    /*-ms
    Beats 100.00%of users with Java*/
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i])
                res++;
        }
        return res;
    }
}
