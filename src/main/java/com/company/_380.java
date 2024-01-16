package com.company;

import java.util.*;

public class _380 {

    /*105
    ms
            Beats
31.27%
    of users with Java*/
    class RandomizedSet {

        Set<Integer> set;
        Random rand;

        public RandomizedSet() {
            set = new HashSet<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            boolean res = set.contains(val);
            set.add(val);
            return !res;
        }

        public boolean remove(int val) {
            boolean res = set.contains(val);
            set.remove(val);
            return res;
        }

        public int getRandom() {
            int pos = rand.nextInt(set.size());
            Iterator<Integer> iterator = set.iterator();
            int count = 0;
            while (count < pos) {
                iterator.next();
                count++;
            }
            return iterator.next();
        }
    }
}
