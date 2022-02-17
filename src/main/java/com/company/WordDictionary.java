package com.company;

import java.util.List;
import java.util.TreeMap;
import java.util.Map;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class WordDictionary {

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    private class Node {
        char key;
        List<Node> children;

        Node(){};

        Node(char key) {
           this.key = key;
        }

        void get(char key) {
            /*if (children == null) {
                return child;
            }
            return children;*/
        }

    }


    private Node dic;

    public WordDictionary() {
        dic = new Node();
    }

    public void addWord(String word) {
        addWord(word,dic);
    }

    private void addWord(String word, Node map) {
        /*if (word.length()>0) {
            char c = word.charAt(0);
            String leftPart = word.substring(1);
            Map childMap = map.get(c);
            if (childMap == null) {
                map.put(c, new TreeMap<Character, Map>());
            }
            childMap = map.get(c);
            addWord(leftPart,childMap);
        }
        else {
            map.put('!', new TreeMap());
        }*/
    }

    private boolean search(String word, Map<Character, Map> map) {
        if (word.length() == 0) {
            if (map.get('!')!=null)
                return true;
            else
                return false;
        }
        else {
            char c = word.charAt(0);
            String leftPart = word.substring(1);
            if (c!='.') {
                Map childMap = map.get(c);
                if (childMap == null) {
                    return false;
                }
                if (search(leftPart,childMap)) {
                    return true;
                }
            }
            else {
                for (Map.Entry<Character, Map> entry : map.entrySet()) {
                    if (entry.getKey()!='!') {
                        Map childMap = entry.getValue();
                        if (search(leftPart,childMap)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean search(String word) {
//        return search(word,dic);
        return true;
    }

}
