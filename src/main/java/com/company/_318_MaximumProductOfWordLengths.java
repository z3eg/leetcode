package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/maximum-product-of-word-lengths/
public class _318_MaximumProductOfWordLengths {

    //seemingly optimal solution
    public int maxProduct(String[] words) {
        int mp = 0;
        int wl = words.length;
        int[] bms = new int[wl];
        for (int i = 0; i < wl; i++) {
            bms[i] = getBitMask(words[i]);
            for (int j = 0; j < i; j++) {
                if ((bms[i] & bms[j]) ==0 ) mp = Math.max(mp, words[i].length()*words[j].length());
            }
        }
        return mp;
    }

    private int getBitMask(String word) {
        int bm = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            bm |= 1 << (chars[i]-'a');
        }
        return bm;
    }

    //again, not the most optimal way (unnecessary recounting of bitmasks)
    /*public int maxProduct(String[] words) {
        int maxProduct = 0;
        for (int i = 0; i < words.length-1; i++) {
            int iBM = getBitMask(words[i]);
            for (int j = i+1; j < words.length; j++) {
                int jBM = getBitMask(words[j]);
                if ((iBM & jBM) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length()*words[j].length());
                }
            }
        }
        return maxProduct;
    }*/

    //nice try, buddy, but bitsets < bitmasks in this case
    /*public int maxProduct(String[] words) {
        int maxProduct = 0;
        int wl = words.length;
        BitSet[] bss = new BitSet[wl];
        for (int i = 0; i < wl; i++) {
            bss[i] = getBS(words[i]);
            for (int j = 0; j < i; j++) {
                if (!bss[i].intersects(bss[j])) {
                    maxProduct = Math.max(maxProduct, (words[i].length()*words[j].length()));
                }
            }
        }
        return maxProduct;
    }

    private BitSet getBS(String s) {
        BitSet bitSet = new BitSet(26);
        for (int i = 0; i < s.length(); i++) {
            bitSet.set(s.charAt(i)-'a');
        }
        return bitSet;
    }

    @Test
    public void testBS() {
        BitSet aBitSet = new BitSet();
        aBitSet.set(0);
        BitSet abcBitSet = new BitSet();
        abcBitSet.set(0);
        abcBitSet.set(1);
        abcBitSet.set(2);
        BitSet zBitSet = new BitSet();
        zBitSet.set(25);
        assertEquals(aBitSet, getBS("a"));
        assertEquals(aBitSet, getBS("aa"));
        assertEquals(abcBitSet, getBS("abc"));
        assertEquals(abcBitSet, getBS("abcabcaabbccbca"));
        assertEquals(zBitSet, getBS("z"));
        assertEquals(zBitSet, getBS("zzzz"));
    }*/

    //too slow, let's try bitmasking instead
    /*private boolean share(String s1, String s2) {
        //find the longest
        String longest;
        String shortest;
        if (s1.length()>s2.length()) {
            longest = s1;
            shortest = s2;
        }
        else {
            longest = s2;
            shortest = s1;
        }
        for (char c : shortest.toCharArray()) {
            if (longest.indexOf(c)!=-1) {
                return true;
            }
        }
        return false;
    }

    private void sortArray(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
    }
    */

    /*@Test
    public void testSort() {
//        String[] sorted = {"abcd", "bcd", "abc", "cd", "ab", "a", "d"};
        String[] sorted = {"a", "d", "ab", "cd", "abc", "bcd", "abcd"};
        String[] original = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        sortArray(original);
        assertArrayEquals(sorted, original);
    }*/

    /*@Test
    public void testShare() {
        assertTrue(share("abcw","baz"));
        assertFalse(share("abcd","xyz"));
    }*/

    /*Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.*/

    @Test
    public void test() {
        assertEquals("bcdefghijklmnopqrstuvwxyz".length(), maxProduct(new String[]{"a","bcdefghijklmnopqrstuvwxyz"}));
        assertEquals(0, maxProduct(new String[]{"a","abcdefghijklmnopqrstuvwxyz"}));
        assertEquals(1, maxProduct(new String[]{"a","b"}));
        assertEquals(0, maxProduct(new String[]{"a","a"}));
        assertEquals(0, maxProduct(new String[]{"a","a","a","a"}));
        assertEquals(1, maxProduct(new String[]{"a","b","c","d"}));
        assertEquals(16, maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        assertEquals(4, maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        assertEquals(0, maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
}
