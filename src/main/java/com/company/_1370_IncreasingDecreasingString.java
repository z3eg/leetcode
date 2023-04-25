package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/increasing-decreasing-string/
public class _1370_IncreasingDecreasingString {

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        LinkedList<Character> charList = new LinkedList<>();
        for (char c: chars)
            charList.add(c);
        StringBuilder stringBuilder = new StringBuilder();
        Character curC = charList.getFirst();
        stringBuilder.append(curC);
        int pos = 0;
        int size = charList.size();
        while (!charList.isEmpty()) {
            while (pos < size) {
                if (curC==charList.get(pos))
                    pos++;
                else {
                    curC = charList.get(pos);
                    stringBuilder.append(curC);
                    charList.remove(pos);
                    size--;
                }
            }
            pos = charList.size()-1;
            while (pos > 0) {
                if (curC==charList.get(pos))
                    pos--;
                else {
                    curC = charList.get(pos);
                    stringBuilder.append(curC);
                    charList.remove(pos);
                    size--;
                    pos--;
                }
            }
        }
        return stringBuilder.toString();
    }

}
