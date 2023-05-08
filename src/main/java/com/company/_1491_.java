package com.company;
//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
//1491. Average Salary Excluding the Minimum and Maximum Salary
public class _1491_ {
    public double average(int[] salary) {
        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int curSal : salary) {
            if (min > curSal)
                min = curSal;
            if (max < curSal)
                max = curSal;
            sum += curSal;
        }
        sum-=min;
        sum-=max;
        return sum/(salary.length-2);
    }
}
