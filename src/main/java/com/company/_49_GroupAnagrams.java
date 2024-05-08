package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertNotEquals;

//https://leetcode.com/problems/group-anagrams/
public class _49_GroupAnagrams {
    /*18ms
    Beats 28.50%of users with Java*/
    /*public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = hash(s);
            List<String> val = map.get(key);
            if (val==null)
                val = new LinkedList<>();
            val.add(s);
            map.put(key, val);
        }
        return new LinkedList<>(map.values());
    }

    private String hash(String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c-'a']++;
        }
        return Arrays.toString(freqs);
    }*/

    /*private Integer hash(String s) {
        int res = 1;
        for (char c : s.toCharArray()) {
            res+=c*c*101;
        }
        return res;
    }*/

    /*@Test
    public void testHash() {
        String tho = hash("tho");
        String pay = hash("pay");
        assertNotEquals(tho, pay);
        tho = hash("fin");
        pay = hash("ell");
        assertNotEquals(tho, pay);
    }*/

    /*6ms
    Beats 93.60%of users with Java*/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }
        return new LinkedList<>(map.values());
    }

    @Test
    public void test() {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("HW");
    }
}
