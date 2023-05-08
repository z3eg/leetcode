package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/dota2-senate/
public class _649_Dota2Senate {

    /*public String predictPartyVictory(String senate) {
        List<Character> senateList = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char curSenateMember = senate.charAt(i);
            senateList.add(curSenateMember);
        }
        boolean victoryAchieved = false;
        while (!victoryAchieved) {
            victoryAchieved = true;
            for (int i = 0; i < senateList.size()-1; i++) {
                if (tryRemoveNext(senateList, i))
                    victoryAchieved = false;
            }
        }
        return (senateList.get(0)=='R') ? "Radiant" : "Dire";
    }

    boolean tryRemoveNext(List<Character> list, int pos) {
        if (list.isEmpty()) {
            return false;
        }
        if (pos!=list.size()-1) {
            if (list.get(pos)!=list.get(pos+1)) {
                list.remove(pos+1);
                return true;
            }
        }
        else {
            if (list.get(pos)!=list.get(0)) {
                list.remove(0);
                return true;
            }
        }
        return false;
    }*/

    //beats 7.95%
    /*public String predictPartyVictory(String senate) {
        Map<Character, Integer> factionCount = new HashMap<>();
        int senLen = senate.length();
        char[] chars = new char[senLen];
        for (int i = 0; i < senLen; i++) {
            char c = senate.charAt(i);
            int val = factionCount.containsKey(c) ? factionCount.get(c)+1 : 1;
            factionCount.put(c,val);
            chars[i] = c;
        }
        if (!factionCount.containsKey('D'))
            return "Radiant";
        if (!factionCount.containsKey('R'))
            return "Dire";
        int curPos = 0;
        int nextPos = 1;
        while (factionCount.get('R')>0 && factionCount.get('D')>0) {
            if (chars[curPos]!='X') {
                while (chars[nextPos]=='X' || chars[nextPos]==chars[curPos]) {
                    nextPos = updatePos(senLen, nextPos);
                }
                if (chars[nextPos]!=chars[curPos]) {
                    factionCount.put(chars[nextPos],factionCount.get(chars[nextPos])-1);
                    chars[nextPos] = 'X';
                }
            }
            curPos = updatePos(senLen, curPos);
            nextPos = updatePos(senLen, curPos);

        }
        return factionCount.get('R')==0?"Dire":"Radiant";
    }

    private int updatePos(int senLen, int pos) {
        pos++;
        if (pos == senLen) {
            pos = 0;
        }
        return pos;
    }*/

    class Node {
        Node next;
        Node prev;
        Character val;

        public Node(Character val) {
            this.val = val;
        }
    }

    public String predictPartyVictory(String senate) {
        int r = 0;
        int d = 0;
        if (senate.charAt(0)=='R')
            r++;
        else
            d++;
        Node current = new Node(senate.charAt(0));
        Node first = current;
        for (int i = 1; i < senate.length(); i++) {
            Node prev = current;
            current.next = new Node(senate.charAt(i));
            current = current.next;
            current.prev = prev;
            if (senate.charAt(i)=='R')
                r++;
            else
                d++;
        }
        current.next = first;
        first.prev = current;
        current = first;
        Node next = current.next;
        while (r>0 && d> 0) {
            while (current.val == next.val) {
                next = next.next;
            }
            if (next.val=='R')
                r--;
            else
                d--;
            //delete node
            next.prev.next = next.next;
            next.next.prev = next.prev;
            //
            current = current.next;
            next = current.next;
        }
        return r>d?"Radiant":"Dire";
    }

    @Test
    public void test() {
        assertEquals("Dire", predictPartyVictory("DDRRR"));
        assertEquals("Dire", predictPartyVictory("DDR"));
        assertEquals("Radiant", predictPartyVictory("RRRRRRRRR"));
        assertEquals("Radiant", predictPartyVictory("R"));
        assertEquals("Dire", predictPartyVictory("D"));
        assertEquals("Dire", predictPartyVictory("DR"));
        assertEquals("Radiant", predictPartyVictory("RD"));
        assertEquals("Dire", predictPartyVictory("RDD"));
    }
}
