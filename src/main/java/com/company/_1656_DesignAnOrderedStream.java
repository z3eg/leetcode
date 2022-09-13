package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/design-an-ordered-stream/
public class _1656_DesignAnOrderedStream {

    class OrderedStream {

        String[] stream;

        public OrderedStream(int n) {
            stream = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey-1] = value;
            LinkedList<String> res = new LinkedList<>();
            LinkedList<String> curChunk = new LinkedList<>();
            int i = idKey-1;
            while (i < stream.length) {
                if (stream[i]!=null) {
                    curChunk.add(stream[i]);
                }
                else {
                    if (curChunk.size() > res.size()) {
                        res = curChunk;
                    }
                    curChunk = new LinkedList<>();
                }
                i++;
            }
            if (curChunk.size() > res.size()) {
                res = curChunk;
            }
            return res;
        }
    }

}
