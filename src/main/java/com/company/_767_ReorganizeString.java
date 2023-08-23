package com.company;

import org.junit.jupiter.api.Test;
import scala.util.parsing.combinator.testing.Str;

//https://leetcode.com/problems/reorganize-string/
public class _767_ReorganizeString {
    /*2ms
    Beats 76.56%of users with Java*/
    public String reorganizeString(String s) {
        //priority queue?
        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)-'a']++;
        }
        char[] chars = new char[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i]='a';
            chars[i]+=i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        sort(freqs, chars);
        while(freqs[0]!=0 && freqs[1]!=0) {
            stringBuilder.append(chars[0]);
            freqs[0]--;
            stringBuilder.append(chars[1]);
            freqs[1]--;
            sort(freqs, chars);
        }
        if (freqs[0] > 1)
            return "";
        if (freqs[0]!=0)
            stringBuilder.append(chars[0]);
        if (freqs[1]!=0)
            stringBuilder.append(chars[1]);
        return stringBuilder.toString();
    }

    private void sort(int[] freqs, char[] chars) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < freqs.length-1; i++) {
                if (freqs[i]<freqs[i+1]) {
                    sorted = false;
                    int tmp = freqs[i];
                    freqs[i] = freqs[i+1];
                    freqs[i+1] = tmp;
                    char tm = chars[i];
                    chars[i] = chars[i+1];
                    chars[i+1] = tm;
                }
            }
        }
    }

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < 20; i++) {
                char c = 'a';
                c+=j;
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        System.out.println("===============================================");
        System.out.println(reorganizeString(sb.toString()));

        System.out.println(reorganizeString("ab"));
        System.out.println(reorganizeString("xyzzz"));
        System.out.println(reorganizeString("xyzzzz"));
        System.out.println(reorganizeString("abczzzz"));
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaba"));
        System.out.println(reorganizeString("a"));
        System.out.println(reorganizeString("aba"));
    }
}
