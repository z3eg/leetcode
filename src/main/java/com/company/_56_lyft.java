package com.company;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class _56_lyft {

    /*public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1)
            return intervals;
        int curPos = 0;
        int finLen = len;
        while (curPos < len-1) {
            if (overlap(intervals[curPos],intervals[curPos+1])) {
                intervals[curPos + 1] = merge(intervals[curPos], intervals[curPos + 1]);
                intervals[curPos] = null;
                finLen--;
            }
            curPos++;
        }
        int[][] res = new int[finLen][];
        curPos = 0;
        for (int i = 0; i < len; i++) {
            if (intervals[i] != null) {
                res[curPos] = intervals[i];
                curPos++;
            }
        }
        return res;
    }*/

    //TLE 168/172
    /*public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len == 1)
                return intervals;
            LinkedList<int[]> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                list.add(intervals[i]);
            }
            boolean mergedAtLeastOnce = true;
            while (mergedAtLeastOnce) {
                mergedAtLeastOnce = false;
                foo: for (int i = 0; i < list.size(); i++) {
                    for (int j = i+1; j < list.size(); j++) {
                        if (i!=j && overlap(list.get(i),list.get(j)))
                        {
                            int[] tmp = merge(list.get(i), list.get(j));
                            mergedAtLeastOnce = true;
                            list.remove(j);
                            list.remove(i);
                            list.add(tmp);
                            break foo;
                        }
                    }
                }
            }
            int[][] res = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
    }*/

    //TLE 168/172
    /*public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1)
            return intervals;
        LinkedList<int[]> list = new LinkedList<>();
        boolean merged;
        for (int i = 0; i < len; i++) {
            merged = false;
            for (int j = 0; j < list.size(); j++) {
                if (overlap(intervals[i],list.get(j))) {
                    int[] tmp = merge(list.get(j),intervals[i]);
                    list.remove(j);
                    list.add(tmp);
                    merged = true;
                    break;
                }
            }
            if (!merged)
                list.add(intervals[i]);
        }
        boolean mergedAtLeastOnce = true;
        while (mergedAtLeastOnce) {
            mergedAtLeastOnce = false;
            foo: for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    if (i!=j && overlap(list.get(i),list.get(j)))
                    {
                        int[] tmp = merge(list.get(i), list.get(j));
                        mergedAtLeastOnce = true;
                        list.remove(j);
                        list.remove(i);
                        list.add(tmp);
                        break foo;
                    }
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }*/

    /*public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1)
            return intervals;
        TreeMap<Integer,int[]> map = new TreeMap<>();
        for (int[] interval : intervals)
        {
            map.merge(interval[0],interval, this::merge);
            map.merge(interval[1],interval, this::merge);
        }
        Set<Map.Entry<Integer, int[]>> entries = map.entrySet();
        LinkedList<int[]> list = new LinkedList<>();
        entries.forEach(e -> {
            int[] v = e.getValue();
            boolean merged = false;
            for (int i = 0; i < list.size(); i++) {
                int[] el = list.get(i);
                if (overlap(v, el)) {
                    list.set(i,merge(el, v));
                    merged = true;
                    break;
                }
            }
            if (!merged)
                list.add(v);
        });
        boolean mergedAtLeastOnce = true;
        while (mergedAtLeastOnce) {
            mergedAtLeastOnce = false;
            foo: for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    if (i!=j && overlap(list.get(i),list.get(j)))
                    {
                        int[] tmp = merge(list.get(i), list.get(j));
                        mergedAtLeastOnce = true;
                        list.remove(j);
                        list.remove(i);
                        list.add(tmp);
                        break foo;
                    }
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }*/

    /*public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> (a[0]==b[0])?0:(a[0]>b[0])?1:-1);
        int resLen = intervals.length;
        for (int i = 0; i < intervals.length-1; i++) {
            if (overlap(intervals[i],intervals[i+1])) {
                intervals[i+1] = merge(intervals[i],intervals[i+1]);
                intervals[i] = null;
                resLen--;
            }
        }
        int[][] res = new int[resLen][];
        int p = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i]!=null) {
                res[p] = intervals[i];
                p++;
            }
        }
        return res;
    }*/


    /*7
    ms
    Beats
    98.91%
*/
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> (a[0]==b[0])?0:(a[0]>b[0])?1:-1);
        int resLen = intervals.length;
        for (int i = 0; i < intervals.length-1; i++) {
            if (overlap(intervals[i],intervals[i+1])) {
                intervals[i+1] = merge(intervals[i],intervals[i+1]);
                intervals[i] = null;
                resLen--;
            }
        }
        int[][] res = new int[resLen][];
        int p = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i]!=null) {
                res[p] = intervals[i];
                p++;
            }
        }
        return res;
    }

    boolean overlap(int[] a, int[] b) {
        return a[1]>=b[0];
    }

    int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0],b[0]),Math.max(a[1],b[1])};
    }


    ///////////////////////////

    boolean in(int a, int[] arr) {
        return a>=arr[0] && a<=arr[1];
    }

    @Test
    public void testIn() {
        assertTrue(in(3, new int[]{2,6}));
        assertTrue(in(3, new int[]{3,6}));
        assertTrue(in(3, new int[]{1,3}));
        assertFalse(in(3, new int[]{1,2}));
        assertFalse(in(3, new int[]{4,6}));
    }

    @Test
    public void test() {
        assertEquals(new int[][]{{1,6},{8,10},{15,18}}, merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        assertEquals(new int[][]{{1,5}}, merge(new int[][]{{1,4},{4,5}}));
        assertEquals(new int[][]{{1,7}}, merge(new int[][]{{4,7},{1,4}}));
    }
}
