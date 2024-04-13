package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class _884 {

    /*
    Wrong Answer
    12 / 55 testcases passed*/
    /*public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new LinkedList<String>();
        String[] sp1 = s1.split(" ");
        String[] sp2 = s2.split(" ");
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        for (String word : sp1) {
            m1.merge(word, 1, Integer::sum);
        }
        for (String word : sp2) {
            m2.merge(word, 1, Integer::sum);
        }
        List<String> u1 = new LinkedList<>();
        List<String> u2 = new LinkedList<>();
        for (Map.Entry<String, Integer> next : m1.entrySet()) {
            if (next.getValue() == 1)
                u1.add(next.getKey());
        }
        for (Map.Entry<String, Integer> next : m2.entrySet()) {
            if (next.getValue() == 1)
                u2.add(next.getKey());
        }
        for (String word : u1) {
            if (!u2.contains(word))
                list.add(word);
        }
        for (String word : u2) {
            if (!u1.contains(word))
                list.add(word);
        }
        return list.toArray(new String[]{});
    }*/

    /*3
    ms
    Beats
    42.84%
    of users with Java*/
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new LinkedList<>();
        String[] sp1 = s1.split(" ");
        String[] sp2 = s2.split(" ");
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        for (String word : sp1) {
            m1.merge(word, 1, Integer::sum);
        }
        for (String word : sp2) {
            m2.merge(word, 1, Integer::sum);
        }
        List<String> u1 = new LinkedList<>();
        List<String> u2 = new LinkedList<>();
        for (Map.Entry<String, Integer> next : m1.entrySet()) {
            if (next.getValue() == 1)
                u1.add(next.getKey());
        }
        for (Map.Entry<String, Integer> next : m2.entrySet()) {
            if (next.getValue() == 1)
                u2.add(next.getKey());
        }
        for (String word : u1) {
            if (m2.get(word)==null)
                list.add(word);
        }
        for (String word : u2) {
            if (m1.get(word)==null)
                list.add(word);
        }
        return list.toArray(new String[]{});
    }

    @Test
    public void test() {
        assertArrayEquals(new String[]{"ejt"}, uncommonFromSentences("s z z z s","s z ejt"));
        assertArrayEquals(new String[]{"sweet","sour"}, uncommonFromSentences("this apple is sweet","this apple is sour"));
        assertArrayEquals(new String[]{"banana"}, uncommonFromSentences("apple apple","banana"));
    }
}
