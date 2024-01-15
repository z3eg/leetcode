package com.company;

import scala.Int;

import java.util.*;

public class _2225 {


    /*Time Limit Exceeded
    125 / 127 testcases passed*/
    /*public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int loser = match[1];
            Integer losses = map.get(loser);
            if (losses == null)
                losses = 0;
            losses++;
            map.put(loser, losses);
        }
        ans.add(new LinkedList<>());
        ans.add(new LinkedList<>());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue()==1) {
                ans.get(1).add(e.getKey());
            }
        }
        for (int[] match : matches) {
            int winner = match[0];
            if (map.get(winner)==null && !ans.get(0).contains(winner))
                ans.get(0).add(winner);
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }*/


    /*120
    ms
            Beats
    23.46%
    of users with Java*/
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int loser = match[1];
            Integer losses = map.get(loser);
            if (losses == null)
                losses = 0;
            losses++;
            map.put(loser, losses);
        }
        TreeSet<Integer> oneLossSet = new TreeSet<>();
        TreeSet<Integer> noLossSet = new TreeSet<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue()==1) {
                oneLossSet.add(e.getKey());
            }
        }
        for (int[] match : matches) {
            int winner = match[0];
            if (map.get(winner)==null)
                noLossSet.add(winner);
        }
        ans.add(new LinkedList<>(noLossSet));
        ans.add(new LinkedList<>(oneLossSet));
        return ans;
    }

}
