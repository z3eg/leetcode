package com.company;

import java.util.*;

public class _1615_MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] cityRoadCount = new int[n];
        for (int[] road : roads) {
            cityRoadCount[road[0]]++;
            cityRoadCount[road[1]]++;
        }
        int [] cities = new int[cityRoadCount.length];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = i;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < cityRoadCount.length; i++) {
            List<Integer> list = map.get(cityRoadCount[i]);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(i);
            map.put(cityRoadCount[i], list);
        }
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        Map.Entry<Integer, List<Integer>> largestPair = iterator.next();
        List<Integer> largestList = largestPair.getValue();
        //several maxes, no need to look further in a map
        if (largestList.size()>1) {
            for (int i = 0; i < largestList.size()-1; i++) {
                for (int j = i+1; j < largestList.size(); j++) {
                    boolean curPairConnected = false;
                    for (int[] road : roads) {
                        if ((road[0] == largestList.get(i) && road[1] == largestList.get(j)) ||
                                (road[1] == largestList.get(i) && road[0] == largestList.get(j))) {
                            curPairConnected = true;
                            break;
                        }
                    }
                    if (!curPairConnected) {
                        return largestPair.getKey()*2;
                    }
                }
            }
            return largestPair.getKey()*2-1;
        }
        else {
            Map.Entry<Integer, List<Integer>> nextLargestPair = iterator.next();
            List<Integer> nextLargestList = nextLargestPair.getValue();
            int largest = largestList.get(0);
            for (int i = 0; i < nextLargestList.size(); i++) {
                boolean curPairConnected = false;
                for (int[] road : roads) {
                    if ((road[0] == largest && road[1] == nextLargestList.get(i)) ||
                            (road[1] == largest && road[0] == nextLargestList.get(i))) {
                        curPairConnected = true;
                        break;
                    }
                }
                if (!curPairConnected) {
                    return largestPair.getKey()+nextLargestPair.getKey();
                }
            }
            return largestPair.getKey()+nextLargestPair.getKey()-1;
        }

    }
}
