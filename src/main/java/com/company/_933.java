package com.company;

import scala.Int;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*933. Number of Recent Calls
        https://leetcode.com/problems/number-of-recent-calls/*/
public class _933 {


    /*
        548ms
    Beats 14.82%of users with Java*/
    /*class RecentCounter {

        Set<Integer> times;

        public RecentCounter() {
            times = new TreeSet<>(Comparator.reverseOrder());
        }

        public int ping(int t) {
            times.add(t);
            int res = 0;
            for (Integer time : times) {
                if (time > t-3000)
                    res++;
                else
                    return res;
            }
            return res;
        }
    }*/

    class RecentCounter {
        int[] times;
        int i;

        public RecentCounter() {
            times = new int[10000];
            i = 0;
        }

        public int ping(int t) {
            times[i] = t;
            int j = i;
            while (j >= 0&& times[j] >= t-3000) {
                j--;
            }
            i++;
            return i-j-1;
        }
    }
}
