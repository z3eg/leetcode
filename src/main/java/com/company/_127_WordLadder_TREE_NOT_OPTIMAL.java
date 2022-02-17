package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/word-ladder/
public class _127_WordLadder_TREE_NOT_OPTIMAL {

    //BUILD A TREE LEVEL BY LEVEL (WITHOUT RECURSION PERHAPS)
    private class Node {
        public String val;
        public List<Node> children;

        public Node(String val) {
            this.val = val;
            this.children = new LinkedList<>();
        }
    }

    private void buildATree(String beginWord, String endWord, String wordList) {
        Node root = new Node(beginWord);
        //build next layer

    }

    private boolean isNotWorse(String s1, String s2, String example) {
        return countMatches(s1,example)>=countMatches(s2,example);
    }

    private boolean isBetter(String s1, String s2, String example) {
        return countMatches(s1,example)>countMatches(s2,example);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.remove(beginWord);
        Node globalRoot = new Node(beginWord);
        buildATree(globalRoot, wordList, endWord);
        HashSet<Integer> pathLengths = new HashSet<>();
        findPaths(1, globalRoot, endWord, pathLengths);
        pathLengths.remove(0);
        if (pathLengths.isEmpty()) {
            return 0;
        }
        else {
            return Collections.min(pathLengths);
        }
    }

    /*newList.sort((o1, o2) -> {
                if (countMatches(o1, beginWord) > countMatches(o2, beginWord)) {
                    return -1;
                }
                if (countMatches(o1, beginWord) < countMatches(o2, beginWord)) {
                    return 1;
                }
                if (countMatches(o1, beginWord) == countMatches(o2, beginWord)) {
                    return 0;
                }
                return 0;
            });*/
    private int stringDiff(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return -1;
        }
        else {
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                diff+=Math.abs(s1.charAt(i)-s2.charAt(i));
            }
            return diff;
        }
    }

    private void buildATree(Node root, List<String> wordList, String stopWord) {
        String rootval = root.val;
        if (!Objects.equals(rootval, stopWord)) {
            ArrayList<String> newList = new ArrayList<>(wordList);
            for (String word : wordList) {
                if (wordsCanTransit(rootval, word) && isNotWorse(word, rootval, stopWord)) {
                    Node child = new Node(word);
                    root.children.add(child);
                    newList.remove(word);
                    buildATree(child, newList, stopWord);
                }
            }
        }
    }

    /*private void buildATree(Node root, List<String> wordList, String stopWord) {
        String beginWord = root.val;
        if (!Objects.equals(beginWord, stopWord)) {
            LinkedList<String> newList = new LinkedList<>(wordList);
            Iterator<String> iterator = newList.iterator();
            while (iterator.hasNext()) {
                String word = iterator.next();
                if (wordsCanTransit(root.val, word)) {
                    Node child = new Node(word);
                    root.children.add(child);
                    iterator.remove();
                    buildATree(child, newList, stopWord);
                }
            }
        }
    }*/

    private void findPaths(int i, Node root, String stopWord, Set<Integer> pathLengths) {
        if (root!=null) {
            if (root.val.equals(stopWord)) {
                pathLengths.add(i);
            }
            else {
                for (Node child : root.children) {
                    findPaths(i+1, child, stopWord, pathLengths);
                }
            }
        }
    }

    private int countMatches(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return 0;
        }
        int matchCounter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)==s2.charAt(i)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }

    private boolean wordsCanTransit(String s1, String s2) {
        return (countMatches(s1,s2)==s1.length()-1);
    }

    /*private Map<Character,Integer> getFrequencyMap(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequencyMap.merge(s.charAt(i), 1, Integer::sum);
        }
        return frequencyMap;
    }*/

    /*private boolean mapsCanTransit(Map<Character,Integer> map1, Map<Character,Integer> map2) {
        Map<Character,Integer> big;
        Map<Character,Integer> small;
        if (map1.size()>map2.size()) {
            big = map1;
            small = map2;
        }
        else {
            big = map2;
            small = map1;
        }
//        Iterator<Map.Entry<Character, Integer>> bigIterator = big.entrySet().iterator();
//        Iterator<Map.Entry<Character, Integer>> smallIterator = small.entrySet().iterator();
        for (Map.Entry<Character, Integer> entry : big.entrySet()) {
            Character smallKey = entry.getKey();
            Integer smallVal = small.get(smallKey);
            if (smallVal!=null) {
                if (smallVal>1) {
                    small.put(smallKey,smallVal-1);
                }
                else {
                    small.remove(smallKey);
                }
            }
        }
        Iterator<Map.Entry<Character, Integer>> map1Iterator = small.entrySet().iterator();
        int mapSize = 0;
        int mapVal = 0;
        while (map1Iterator.hasNext()) {
            Map.Entry<Character, Integer> next = map1Iterator.next();
            mapVal = next.getValue();
            mapSize++;
        }
        return (mapSize==1 && mapVal==1);
    }*/

    /*@Test
    public void testMapsCanTransit() {
        assertTrue(mapsCanTransit(getFrequencyMap("miss"),getFrequencyMap("mist")));
        assertTrue(mapsCanTransit(getFrequencyMap("mist"),getFrequencyMap("miss")));
        assertTrue(mapsCanTransit(getFrequencyMap("hit"),getFrequencyMap("hot")));
        assertTrue(mapsCanTransit(getFrequencyMap("hot"),getFrequencyMap("dot")));
        assertTrue(mapsCanTransit(getFrequencyMap("dog"),getFrequencyMap("dot")));
        assertFalse(mapsCanTransit(getFrequencyMap("dog"),getFrequencyMap("lot")));
        assertTrue(mapsCanTransit(getFrequencyMap("dog"),getFrequencyMap("log")));
        assertTrue(mapsCanTransit(getFrequencyMap("dog"),getFrequencyMap("cog")));
        assertTrue(mapsCanTransit(getFrequencyMap("log"),getFrequencyMap("cog")));
    }*/

    @Test
    public void testWordsCanTransit() {
        assertTrue(wordsCanTransit("miss","mist"));
        assertTrue(wordsCanTransit("mist","miss"));
        assertTrue(wordsCanTransit("hit","hot"));
        assertTrue(wordsCanTransit("hot","dot"));
        assertTrue(wordsCanTransit("dog","dot"));
        assertFalse(wordsCanTransit("dog","lot"));
        assertTrue(wordsCanTransit("dog","log"));
        assertTrue(wordsCanTransit("dog","cog"));
        assertTrue(wordsCanTransit("log","cog"));
    }


    @Test
    public void testBuild() {
        List<String> wordList = new ArrayList<>(Arrays.asList("sq"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"/*
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"*/));
        System.out.println(wordList.size());
        wordList.remove("qa");
        Node globalRoot = new Node("qa");
        buildATree(globalRoot, wordList, "sq");
    }

    @Test
    public void test() {
//        assertNotEquals(3,ladderLength("hot","dog", new ArrayList<>(Arrays.asList("hot","dog","vay"))));
        //TLE
        /*HashSet<String> stringsSet = new HashSet<>(stringsList);
        assertEquals(stringsSet.size(),stringsList.size());*/
        /*ArrayList<String> wordList = new ArrayList<>(Arrays.asList("si"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"));*/
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("sq"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"
                , "lo", "as", "fr", "nb", "yb", "if", "pb"/*, "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"*/));
        System.out.println(wordList.size());
        assertNotEquals(987, ladderLength("qa", "sq", wordList));
        assertEquals(6,ladderLength("leet","code",
                new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"))));
        assertEquals(4,ladderLength("lost","miss",
                new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"))));
        assertEquals(2,ladderLength("a","c", new ArrayList<>(Arrays.asList("a","b","c"))));
        assertEquals(3,ladderLength("hot","dog", new ArrayList<>(Arrays.asList("hot","dog","dot"))));
        assertEquals(5,ladderLength("hit","cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        assertEquals(0,ladderLength("hit","cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
    }

    /*private int findShortestPath(int i, Node root, String stopWord) {
        if (root!=null) {
            if (root.val.equals(stopWord)) {
                return i;
            }
            else {
                for (Node child : root.children) {
                    i++;
                    return findShortestPath(i, child, stopWord);
                }
            }
        }
        return i;
    }*/

    //actually working whole tree, but i need to stop if i reach stopWord
    /*private void buildATree(Node root, List<String> wordList) {
        for (String word : wordList) {
            if (mapsCanTransit(getFrequencyMap(root.val), getFrequencyMap(word))) {
                Node child = new Node(word);
                root.children.add(child);
                List<String> newList = new LinkedList<>(wordList);
                newList.remove(word);
                buildATree(child, newList);
            }
        }
//        return root;
    }*/

    /*Example 1:

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    Example 2:

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.*/
}
