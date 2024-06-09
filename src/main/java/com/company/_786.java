package com.company;

import java.util.*;

public class _786 {

    /*Time Limit Exceeded
58 / 59 testcases passed*/
    /*public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        TreeMap<Double, int[]> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i!=j) {
                    map.put((double) arr[i] / arr[j], new int[]{arr[i],arr[j]});
                }
            }
        }
        int pos = 1;
        Iterator<Map.Entry<Double, int[]>> iterator = map.entrySet().iterator();
        while (iterator.hasNext() && pos<k) {
            iterator.next();
            pos++;

        }
        return iterator.next().getValue();
    }*/

    /*public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Arrays.sort(arr);
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >= 0; j--) {
                if (i != j) {
                    if (k==counter)
                        return new int[]{arr[i],arr[j]};
                    counter++;
                }
            }
        }
        return null;
    }*/

    private class Node {
        double val;
        int[] nums;

        public Node(int a, int b) {
            val = (double) a/b;
            nums = new int[]{a,b};
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingDouble(o -> o.val));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i!=j)
                    q.offer(new Node(arr[i],arr[j]));
            }
        }
        int counter = 1;
        while (k>counter) {
            q.poll();
            counter++;
        }
        return q.poll().nums;
    }

    /*777
    ms
    Beats
    6.11%
    of users with Java*/
    /*public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<Node> q = new PriorityQueue<Node>((o1, o2) -> Double.compare(o1.val, o2.val));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i!=j)
                    q.offer(new Node(arr[i],arr[j]));
            }
        }
        int counter = 1;
        while (k>counter) {
            q.poll();
            counter++;
        }
        return q.poll().nums;
    }*/
}
