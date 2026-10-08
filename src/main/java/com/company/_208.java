package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _208 {

    /*30
ms
Beats
92.52%
*/

    class Trie {

        class Node {
            char val;
            Node[] children;

            public Node(char val) {
                this.val = val;
                this.children = new Node[27];
            }
        }

        Node root;

        public void insert(Node node, String word, int cur) {
            Node[] children = node.children;
            if (cur==word.length()) {
                children[26]=new Node('.');
                return;
            }
            char curChar = word.charAt(cur);
            if (children[curChar-'a']==null) {
                children[curChar-'a'] = new Node(curChar);
            }
            insert(children[curChar-'a'], word,++cur);
        }

        public boolean search(Node node, String word, int cur) {
            if (node == null)
                return false;
            Node[] children = node.children;
            if (cur==word.length()) {
                return children[26]!=null;
            }
            char curChar = word.charAt(cur);
            if (children[curChar-'a']==null) {
                return false;
            }
            return search(children[curChar-'a'],word,++cur);
        }

        public boolean startsWith(Node node, String word, int cur) {
            if (node == null)
                return false;
            if (cur==word.length()) {
                return true;
            }
            Node[] children = node.children;
            char curChar = word.charAt(cur);
            if (children[curChar-'a']==null) {
                return false;
            }
            return startsWith(children[curChar-'a'],word,++cur);
        }

        public Trie() {
            root = new Node('?');
        }

        public void insert(String word) {
            insert(root,word,0);
        }

        public boolean search(String word) {
            return search(root, word,0);
        }

        public boolean startsWith(String prefix) {
            return startsWith(root,prefix,0);
        }
    }

    @Test
    public void test() {
        Trie t = new Trie();
        t.insert("apple");
        assertTrue(t.search("apple"));
        assertFalse(t.search("app"));
        assertTrue(t.startsWith("app"));
        t.insert("app");
        assertTrue(t.search("app"));

    }
}
