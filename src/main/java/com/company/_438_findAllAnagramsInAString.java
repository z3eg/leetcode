package com.company;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class _438_findAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            String substring = s.substring(i,i+p.length());
            if (isAnagram(substring,p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        return hashcode(s1)==hashcode(s2);
    }

    private long hashcode(String s) {
        long hashcode = 1;
        for (Character c : s.toCharArray()) {
            hashcode*=c.hashCode();
        }
        return hashcode;
    }

    /*public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new LinkedList<>();
        //case for 1 symbol
        if (p.length() == 1) {
            int i = -1;
            do {
                i = s.indexOf(p, i+1);
                if (i != -1) {
                    results.add(i);
                }
            }
            while (i != -1);
        } else {
            //if all chars are the same
            if (allCharsAreSame(p)) {
                int i = -1;
                do {
                    i = s.indexOf(p, i + 1);
                    if (i != -1) {
                        results.add(i);
                    }
                }
                while (i != -1);
            }
            else {
                //if it's a repeated substing
                *//*if (s.contains(p) && s.length()%p.length()==0) {
                    int nums = s.length()/p.length();
                    String repeatedP = p.repeat(nums);
                    if (s.equals(repeatedP)) {
                        for(int i = 0; i < s.length()-p.length()+1; i++) {
                            results.add(i);
                        }
                    }
                    else {
                        return doItTheEasyWay(s, p);
                    }
                }
                else {*//*
                    return doItTheEasyWay(s, p);
//                }
            }
        }
        return results;
    }

    private List<Integer> doItTheEasyWay(String s, String p) {
        char[] chars = p.toCharArray();
        HashMap<Integer, String> stringMap = new HashMap<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            stringMap.put(i, s.substring(i, i + p.length()));
        }
        stringMap.entrySet().removeIf(entry -> !isAnagram(entry.getValue(), chars));
        return stringMap.keySet().stream().toList();
    }

    public static List<Character> strToList(String str)
    {
        return str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    }

    public boolean allCharsAreSame(String s) {
        String c = Character.toString(s.charAt(0));
        String repeat = c.repeat(s.length());
        return repeat.equals(s);
    }

    public boolean isAnagram(String s, char[] chars) {
        List<Character> characters = strToList(s);
        for (char c : chars) {
            characters.remove(Character.valueOf(c));
        }
        return characters.isEmpty();
    }*/

    //this solution works, but TLE
    /*public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> results = new LinkedList<>();
        if (p.length() == 1) {
            int i = -1;
            do {
                i = s.indexOf(p, i+1);
                if (i!= -1) {
                    results.add(i);
                }
            }
            while (i != -1);
        }
        else {
            //if all chars are the same
            if (allCharsAreSame(p)) {
                int i = -1;
                do {
                    i = s.indexOf(p, i+1);
                    if (i!= -1) {
                        results.add(i);
                    }
                }
                while (i != -1);
            }
            else {
                Map<Integer, List <Character>> map = new HashMap<>();
                int i = 0;
                List<Character> pList = strToList(p);
                while (i < s.length()) {
                    char curChar = s.charAt(i);
                    if (pList.contains(curChar)) {
                        map.put(i, new ArrayList<>(pList));
                    }
                    Iterator<Map.Entry<Integer,List<Character>>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, List<Character>> entry = iterator.next();
                        List<Character> charsForIndex = entry.getValue();
                        if (charsForIndex.contains(curChar)) {
                            charsForIndex.remove(Character.valueOf(curChar));
                        }
                        else {
                            iterator.remove();
                        }
                        if (charsForIndex.size() == 0) {
                            results.add(entry.getKey());
                            iterator.remove();
                        }
                    }
                    i++;
                }
            }
        }
        return results;
    }*/

    @Test
    public void testHashCode() {
        String abc = "abc";
        System.out.println(abc.hashCode());
        String cba = "cba";
        System.out.println(cba.hashCode());
    }

    @Test
    public void testIsAnagram() {
       /* assertTrue(isAnagram("cba", new char[]{'a','b','c'}));
        assertFalse(isAnagram("cbae", new char[]{'a','b','c','x'}));
        assertFalse(isAnagram("ba", new char[]{'a','a'}));
        assertTrue(isAnagram("ba", new char[]{'a','b'}));*/
    }


    @Test
    public void test() {
        assertEquals(Arrays.asList(0,6), findAnagrams("cbaebabacd", "abc"));
        assertEquals(Arrays.asList(0,1,2), findAnagrams("abab", "ab"));
        assertEquals(Arrays.asList(1,4,6), findAnagrams("cbaebabacd", "b"));
        assertEquals(Arrays.asList(0,1,2,3,4,5), findAnagrams("aaaaaaaa", "aaa"));
        assertEquals(Arrays.asList(1), findAnagrams("baa", "aa"));
        assertEquals(Arrays.asList(0,2,4,6), findAnagrams("ababababab", "aab"));
        assertEquals(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10), findAnagrams("abcdeabcdeabcde", "abcde"));
        assertEquals(Arrays.asList(1,2,3,5), findAnagrams("abacbabc", "abc"));
        assertEquals(Arrays.asList(3,4,6), findAnagrams("abaacbabc", "abc"));
        assertEquals(Arrays.asList(19,20,21,22), findAnagrams("dinitrophenylhydrazinetrinitrophenylmethylnitramine", "trinitrophenylmethylnitramine"));
    }
}
