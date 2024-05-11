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
    /*public boolean hasGroupsSizeX(int[] deck) {
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
    }*/


    /*Wrong Answer
68 / 75 testcases passed*/
    /*public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : deck) {
            Integer am = map.get(c);
            if (am == null) {
                am = 0;
            }
            am++;
            map.put(c, am);
        }
        int lcd = 0;
        for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
            if (e1.getValue() < 2)
                return false;
            for (Map.Entry<Integer, Integer> e2 : map.entrySet()) {
                if (e1.getKey()!=e2.getKey()) {
                    int curLcd = lcd(e1.getValue(), e2.getValue());
                    if (lcd == 0)
                        lcd = curLcd;
                    else {
                        if (curLcd == -1)
                            return false;
                        else if (curLcd != lcd)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    int lcd(int a, int b) {
        int min = Math.min(a,b);
        for (int i = 2; i <= min; i++) {
            if (a%i == 0 && b%i==0)
                return i;
        }
        return -1;
    }*/


    /*11
    ms
    Beats
    62.24%
    of users with Java*/
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
        foo: for (int i = 2; i <= min; i++) {
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue()%i != 0)
                    continue foo;
            }
            return true;
        }
        return false;
    }
}
