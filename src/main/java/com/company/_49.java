package com.company;

import org.junit.Test;

import java.util.*;

public class _49 {

    /*19
ms
Beats
16.93%*/
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] fMap = genFreqmap(s);
            map.computeIfAbsent(Arrays.toString(fMap), k -> new LinkedList<>()).add(s);
        }
        map.values().forEach(v->res.add(v));
        return res;
    }

    int[] genFreqmap(String str) {
        int[] freqMap = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freqMap[str.charAt(i)-'a']++;
        }
        return freqMap;
    }

    @Test
    public void test() {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
