package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*706. Design HashMap
        https://leetcode.com/problems/design-hashmap/description/?envType=daily-question&envId=2023-10-04*/
public class _706 {

    /*436ms
    Beats 5.02%of users with Java*/
    class MyHashMap {

        List<int[]> map;
        public MyHashMap() {
            map = new LinkedList<>();
        }

        public void put(int key, int value) {
            boolean found = false;
            for (int[] cur : map) {
                if (cur[0] == key) {
                    cur[1] = value;
                    found = true;
                }
            }
            if (!found) {
                map.add(new int[]{key, value});
            }
        }

        public int get(int key) {
            for (int[] cur : map) {
                if (cur[0] == key) {
                    return cur[1];
                }
            }
            return -1;
        }

        public void remove(int key) {
            Iterator<int[]> iterator = map.iterator();
            while (iterator.hasNext()) {
                int[] cur = iterator.next();
                if (cur[0] == key) {
                    iterator.remove();
                    break;
                }
            }
        }
    }
}
