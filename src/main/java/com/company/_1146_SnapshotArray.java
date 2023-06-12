package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/snapshot-array/
public class _1146_SnapshotArray {

    //MLE
    /*class SnapshotArray {

        int[] arr;
        List<Map<Integer,Integer>> changesList;
        Map<Integer,Integer> curMap;

        public SnapshotArray(int length) {
            arr = new int[length];
            changesList = new LinkedList<>();
            curMap = new HashMap<>();
        }

        public void set(int index, int val) {
            curMap.put(index, val);
        }

        public int snap() {
            changesList.add(new HashMap<>(curMap));
            return changesList.size()-1;
        }

        public int get(int index, int snap_id) {
            Integer val = changesList.get(snap_id).get(index);
            return val==null?0:val;
        }
    }*/

    //MLE
    /*class SnapshotArray {

        boolean[] changed;
        int[][] arr;
        int curSnapshot;

        public SnapshotArray(int length) {
            arr = new int[50000][length];
            changed = new boolean[length];
            curSnapshot = 0;
        }

        public void set(int index, int val) {
            arr[curSnapshot][index] = val;
            changed[index] = true;
        }

        public int snap() {
            curSnapshot++;
            return curSnapshot-1;
        }

        public int get(int index, int snap_id) {
            if (!changed[index])
                return 0;
            while (snap_id>=0 && arr[snap_id][index]==0) {
                snap_id--;
            }
            if (snap_id==-1)
                snap_id=0;
            return arr[snap_id][index];
        }
    }*/

    class SnapshotArray {

        Map<Integer, Map<Integer, Integer>> map;
        int curSnap = 0;

        public SnapshotArray(int length) {
            map = new HashMap<>();
        }

        public void set(int index, int val) {
            Map<Integer, Integer> snapToVal = map.get(index);
            if (snapToVal == null) {
                snapToVal = new TreeMap<>();
            }
            snapToVal.put(curSnap, val);
            map.put(index,snapToVal);
        }

        public int snap() {
            curSnap++;
            return curSnap-1;
        }

        public int get(int index, int snap_id) {
            Map<Integer, Integer> snapToVal = map.get(index);
            if (snapToVal==null)
                return 0;
            Integer val = snapToVal.get(snap_id);
            if (val!=null)
                return val;
            if (snap_id==0)
                return 0;
            int curEntryNum = 0;
            Set<Map.Entry<Integer, Integer>> entries = snapToVal.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getKey()<snap_id)
                    curEntryNum++;
                else
                    break;
            }
            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
            while (curEntryNum>0) {
                iterator.next();
                curEntryNum--;
            }
            Map.Entry<Integer, Integer> next = iterator.next();
            return next.getValue();
        }
    }

    @Test
    public void test() {
        //38
        SnapshotArray obj = new SnapshotArray(2);
        obj.snap();
        obj.get(1,0);
        obj.get(0,0);
        obj.set(1,8);
        assertEquals(0, obj.get(1,0));
        obj.set(0,20);
        assertEquals(0, obj.get(0,0));
        obj.set(0,7);
        int re = obj.get(0,0);
        System.out.println(re);

        /*SnapshotArray obj = new SnapshotArray(3);
        obj.set(0,5);
        obj.snap();
        obj.set(0,6);
        int re = obj.get(0,0);
        System.out.println(re);*/
    }

}
