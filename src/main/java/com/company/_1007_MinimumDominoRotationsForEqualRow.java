package com.company;

import org.junit.Test;

import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
public class _1007_MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Integer.MAX_VALUE;
        int topLen = tops.length;
        outerLoop:
        for (int i = 1; i < 7; i++) {
            int topRots = 0;
            int botRots = 0;
            for (int j = 0; j < topLen; j++) {
                int curTop = tops[j];
                int curBot = bottoms[j];
                if (i != curTop && i != curBot) {
                    continue outerLoop;
                }
                if (i != curTop) {
                    topRots++;
                }
                if (i != curBot) {
                    botRots++;
                }
            }
            minRotations = Math.min(minRotations,Math.min(topRots, botRots));
        }
        return (minRotations==Integer.MAX_VALUE) ? -1 : minRotations;
    }

    //greedier than the 1st one but still bad
    /*public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> topRotations = new HashMap<>();
        HashMap<Integer, Integer> bottomRotations = new HashMap<>();
        for (int i = 1; i < 7; i++) {
            topRotations.put(i,0);
            bottomRotations.put(i,0);
        }
        int arrLength = tops.length;
        for (int i = 0; i < arrLength; i++) {
            Iterator<Map.Entry<Integer, Integer>> iterator = topRotations.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer curVal = next.getKey();
                if (curVal != tops[i] && curVal != bottoms[i]) {
                    iterator.remove();
                    bottomRotations.remove(curVal);
                }
                else if (curVal != tops[i] && curVal == bottoms[i]){
                    next.setValue(next.getValue()+1);
                }
                else if (curVal == tops[i] && curVal != bottoms[i]){
                    bottomRotations.put(curVal, bottomRotations.get(curVal)+1);
                }
            }
        }
        List<Integer> topValues = new LinkedList<>(topRotations.values());
        Collection<Integer> bottomValues = bottomRotations.values();
        topValues.addAll(bottomValues);
        Optional<Integer> min = topValues.stream().min(Comparator.naturalOrder());
        return min.orElse(-1);

    }*/

    //better, but still not good enough
    /*public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, BitSet> topsMap = new HashMap<>();
        Map<Integer, BitSet> bottomsMap = new HashMap<>();
        BitSet topsSet;
        BitSet botsSet;
        for (int i = 1; i < 7; i++) {
            topsSet = new BitSet();
            for (int j = 0; j < tops.length; j++) {
                if (i==tops[j])
                    topsSet.set(j);
            }
            topsMap.put(i, topsSet);
            botsSet = new BitSet();
            for (int j = 0; j < bottoms.length; j++) {
                if (i==bottoms[j])
                    botsSet.set(j);
            }
            bottomsMap.put(i, botsSet);
        }

        Map<Integer, Integer> topCardinalities = new HashMap<>();
        Map<Integer, Integer> bottomCardinalities = new HashMap<>();
        int arrLength = tops.length;
        bottomsMap.forEach((k,v) -> {bottomCardinalities.put(k, v.cardinality());});
        topsMap.forEach((k,v) -> {
            topCardinalities.put(k, v.cardinality());
            v.or(bottomsMap.get(k));
            if (v.cardinality() < arrLength) {
                topCardinalities.remove(k);
                bottomCardinalities.remove(k);
            }
        });
        List<Integer> topValues = new LinkedList<>(topCardinalities.values());
        Collection<Integer> bottomValues = bottomCardinalities.values();
        topValues.addAll(bottomValues);
        Optional<Integer> max = topValues.stream().max(Comparator.naturalOrder());
        int maxVal = max.orElse(-1);
        return (maxVal==-1) ? -1 : arrLength-maxVal;
    }*/

    // 5%/5%. not effective enough
    /*public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Set<Integer>> valueToPositions = new HashMap<>();
        Map<Integer, Integer> valueToTopValueCount = new HashMap<>();
        Map<Integer, Integer> valueToBottomValueCount = new HashMap<>();
        fillPositionsMap(tops, valueToPositions, valueToTopValueCount);
        fillPositionsMap(bottoms, valueToPositions, valueToBottomValueCount);
        int arrLength = tops.length;
        Iterator<Map.Entry<Integer, Set<Integer>>> iterator = valueToPositions.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Set<Integer>> next = iterator.next();
            if (next.getValue().size() < arrLength) {
                iterator.remove();
                valueToTopValueCount.remove(next.getKey());
                valueToBottomValueCount.remove(next.getKey());
            }
        }
        Collection<Integer> topValues = valueToTopValueCount.values();
        Optional<Integer> maxTops = topValues.stream().max(Comparator.naturalOrder());
        Collection<Integer> bottomValues = valueToBottomValueCount.values();
        Optional<Integer> maxBottoms = bottomValues.stream().max(Comparator.naturalOrder());
        int maxTopsVal = maxTops.orElse(-1);
        int maxBottomsVal = maxBottoms.orElse(-1);
        int max = Math.max(maxTopsVal, maxBottomsVal);
        return (max==-1) ? -1 : arrLength - max;
    }

    private void fillPositionsMap(int[] arr, Map<Integer, Set<Integer>> valueToPositions, Map<Integer,Integer> valueToValueCount) {
        for (int i = 0, topsLength = arr.length; i < topsLength; i++) {
            Set<Integer> valPositions = valueToPositions.get(arr[i]);
            if (valPositions == null) {
                valPositions = new HashSet<>();
            }
            valPositions.add(i);
            valueToPositions.put(arr[i],valPositions);

            Integer valueCount = valueToValueCount.get(arr[i]);
            valueToValueCount.put(arr[i],(valueCount==null)? 1 : valueCount+1);
        }
    }*/

    @Test
    public void test() {

        /*for (int i = 0; i < 1000000; i++) {
            minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
        }*/
//        for (int i = 0; i < 1000000; i++) {
            assertEquals(2, minDominoRotations(new int[]{6,1,6,4,6,6}, new int[]{5,6,2,6,3,6}));
            assertEquals(2, minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
            assertEquals(-1, minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
//        }
    }


}
