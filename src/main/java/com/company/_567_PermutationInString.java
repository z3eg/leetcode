package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/permutation-in-string/
public class _567_PermutationInString {

    //4 times slower than hash-based initial one
    /*public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char curChar = s1.charAt(i);
            s1Map.merge(curChar, 1, Integer::sum);
        }
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            String substring = s2.substring(i, i + s1.length());
            Map<Character, Integer> occurenceMap = new HashMap<>();
            for (int j = 0; j < substring.length(); j++) {
                char curChar = substring.charAt(j);
                occurenceMap.merge(curChar, 1, Integer::sum);
            }
            if (s1Map.equals(occurenceMap)) {
                return true;
            }
        }
        return false;
    }*/

    //surprisingly TLE
    /*public boolean checkInclusion(String s1, String s2) {
        LinkedList<TreeMap<Character, Integer>> occurenceMaps = new LinkedList<>();
        TreeMap<Character, Integer> s1Map = new TreeMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char curChar = s1.charAt(i);
            s1Map.merge(curChar, 1, Integer::sum);
        }
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            String substring = s2.substring(i, i + s1.length());
            TreeMap<Character, Integer> occurenceMap = new TreeMap<>();
            for (int j = 0; j < substring.length(); j++) {
                char curChar = substring.charAt(j);
                occurenceMap.merge(curChar, 1, Integer::sum);
            }
            occurenceMaps.add(occurenceMap);
        }
        return occurenceMaps.contains(s1Map);
    }*/

    //actually works, but trying to come up with something more optimal
    /*public boolean checkInclusion(String s1, String s2) {
        HashSet<Integer> hashes = new HashSet<>();
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            String fragment = s2.substring(i,i+s1.length());
            int hash = hash(fragment);
            hashes.add(hash);
        }
        return hashes.contains(hash(s1));
    }*/

    public boolean checkInclusion(String s1, String s2) {
        //count hash of s1 and starting hash of s2
        int s1len = s1.length();
        int s2len = s2.length();
        if (s1len>s2len) {
            return false;
        }
        int hash1 = 0;
        int hash2 = 0;
        for (int i = 0; i < s1len; i++) {
            hash1 += s1.charAt(i) * s1.charAt(i);
            hash2 += s2.charAt(i) * s2.charAt(i);
        }
        if (hash1==hash2) {
            return true;
        }
        //done
        //slide the window modifying hash2 and compare to hash1
        int left = 0;
        int right = s1len;
        while (right<s2len) {
            hash2-=s2.charAt(left)*s2.charAt(left);
            hash2+=s2.charAt(right)*s2.charAt(right);
            left++;
            right++;
            if (hash1==hash2) {
                return true;
            }
        }
        return false;
    }

    //MOOOOOOOOORE
    /*public boolean checkInclusion(String s1, String s2) {
        int hash1 = hash(s1.toCharArray(), 0,s1.length());
        char[] chars = s2.toCharArray();
        int s1len = s1.length();
        int rightBorder = chars.length - s1len + 1;
        for (int i = 0; i < rightBorder; i++) {
            int hash = hash(chars,i,i+ s1len);
            if (hash1==hash) {
                return true;
            }
        }
        return false;
    }

    public int hash(char[] chars, int start, int finish) {
        int hash = 0;
        for (int i = start; i < finish; i++) {
            hash+=chars[i]*chars[i];
        }
        return hash;
    }*/

    /*public int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash+=s.charAt(i)*s.charAt(i);
        }
        return hash;
    }

    @Test
    public void testHash() {
        assertEquals(hash("abc"),hash("cba"));
        assertEquals(hash("abc"),hash("cba"));
        assertEquals(hash("bca"),hash("cba"));
        assertNotEquals(hash("bca"),hash("cbd"));
        assertNotEquals(hash("bca"),hash("bcd"));
    }*/


    @Test
    public void test() {
        assertFalse(checkInclusion("ab", "a"));
        assertTrue(checkInclusion("adc", "dcda"));
        assertFalse(checkInclusion("abc", "ccccbbbbaaaa"));
        assertFalse(checkInclusion("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef",
                                   "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"));
        assertTrue(checkInclusion("ab","eidbaooo"));
        assertFalse(checkInclusion("ab","eidboaoo"));
    }

    /*Example 1:

    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").
    Example 2:

    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false*/
}
