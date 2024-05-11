package com.company;

import java.util.*;

public class _914 {

    /*Wrong Answer
46 / 75 testcases passed*/
    /*public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : deck) {
            Integer am = map.get(c);
            if (am == null)
                am = 0;
            am++;
            map.put(c, am);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int fp = it.next().getValue();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue() != fp)
                return false;
        }
        return true;
    }*/


    /*Wrong Answer
47 / 75 testcases passed*/
    /*public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : deck) {
            Integer am = map.get(c);
            if (am == null)
                am = 0;
            am++;
            map.put(c, am);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int fp = it.next().getValue();
        if (fp < 2)
            return false;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue() != fp)
                return false;
        }
        return true;
    }*/


    /*Wrong Answer
71 / 75 testcases passed*/
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : deck) {
            Integer am = map.get(c);
            if (am == null) {
                am = 0;
            }
            am++;
            map.put(c, am);
        }
        int min = map.values().stream().min(Comparator.naturalOrder()).get();
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        if (min < 2)
            return false;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = it.next();
            if (next.getValue() % min != 0)
                return false;
        }
        return true;
    }
}
