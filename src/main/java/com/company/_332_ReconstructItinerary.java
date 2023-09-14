package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/reconstruct-itinerary/description/?envType=daily-question&envId=2023-09-14
public class _332_ReconstructItinerary {
    /*6 / 80 testcases passed*/
    /*public List<String> findItinerary(List<List<String>> tickets) {
        List<List<String>> candidates = new LinkedList<>();
        foo: for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals("JFK")) {
                List<List<String>> lTickets = new LinkedList<>(tickets);
                List<String> res = new LinkedList<>();
                res.add(lTickets.get(i).get(0));
                res.add(lTickets.get(i).get(1));
                String cur = lTickets.get(i).get(1);
                lTickets.remove(i);
                while (!lTickets.isEmpty()) {
                    boolean found = false;
                    for (int j = 0; j < lTickets.size(); j++) {
                        if (lTickets.get(j).get(0).equals(cur)) {
                            res.add(lTickets.get(j).get(1));
                            cur = lTickets.get(j).get(1);
                            lTickets.remove(j);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        continue foo;
                }
                candidates.add(res);
            }
        }
        if (candidates.size()==1)
            return candidates.get(0);
        for (int i = 0; i < candidates.get(0).size(); i++) {
            for (int j = 0; j < 3; j++) {
                Iterator<List<String>> iter = candidates.iterator();
                while (iter.hasNext()) {
                    List<String> cur = iter.next();
                    for (List<String> candidate : candidates) {
                        if (cur.get(i).charAt(j) > (candidate.get(i).charAt(j))) {
                            iter.remove();
                            if (candidates.size()==1)
                                return candidates.get(0);
                        }
                    }
                }
            }
        }
        return null;
    }*/

    /*Time Limit Exceeded
    11 / 80 testcases passed
    18 TO 30 MS on local TCs*/
    /*public List<String> findItinerary(List<List<String>> tickets) {
        List<List<String>> results = new LinkedList<>();
        find (tickets, new LinkedList<>(), new boolean[tickets.size()], results);
        return results.get(0);
    }

    void find(List<List<String>> tickets, List<String> cur, boolean[] taken, List<List<String>> results) {
        if (cur.size() == tickets.size()+1) {
            results.add(cur);
        }
        else {
            Map<String, Integer> destToPos = new TreeMap<>();
            if (cur.isEmpty()) {
                cur.add("JFK");
                //get all that start with JFK
                for (int i = 0; i < tickets.size(); i++) {
                    if (tickets.get(i).get(0).equals("JFK")) {
                        destToPos.put(tickets.get(i).get(1),i);
                    }
                }
            }
            else {
                String source = cur.get(cur.size() - 1);
                //get the last dest
                for (int i = 0; i < taken.length; i++) {
                    if (!taken[i] && tickets.get(i).get(0).equals(source)) {
                        destToPos.put(tickets.get(i).get(1),i);
                    }
                }
            }
            //go over sorted dests and execute recursion over them (they are already sorted by the map)
            for (Map.Entry<String, Integer> entry : destToPos.entrySet()) {
                boolean[] curTaken = Arrays.copyOf(taken, taken.length);
                List<String> newCur = new LinkedList<>(cur);
                Integer ticketPos = entry.getValue();
                curTaken[ticketPos] = true;
                newCur.add(tickets.get(ticketPos).get(1));
                find(tickets, newCur, curTaken, results);
            }
        }
    }*/

    /*Time Limit Exceeded
    11 / 80 testcases passed*/
    /*public List<String> findItinerary(List<List<String>> tickets) {
        //sort tickets by dest
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < tickets.size() - 1; i++) {
                for (int j = 0; j < 3; j++) {
                    List<String> cur = tickets.get(i);
                    List<String> next = tickets.get(i + 1);
                    if (cur.get(1).charAt(j) > next.get(1).charAt(j)) {
                        sorted = false;
                        tickets.add(i+2, cur);
                        tickets.remove(cur);
                        break;
                    }
                    if (cur.get(1).charAt(j) < next.get(1).charAt(j))
                        break;
                }
            }
        }
        List<List<String>> results = new LinkedList<>();
        find (tickets, new LinkedList<>(), new boolean[tickets.size()], results);
        return results.get(0);
    }

    void find(List<List<String>> tickets, List<String> cur, boolean[] taken, List<List<String>> results) {
        if (cur.size() == tickets.size()+1) {
            results.add(cur);
        }
        else {
            if (cur.isEmpty()) {
                cur.add("JFK");
                //get all that start with JFK
                for (int i = 0; i < tickets.size(); i++) {
                    if (tickets.get(i).get(0).equals("JFK")) {
                        addTrip(tickets, cur, taken, results, i);
                    }
                }
            }
            else {
                String source = cur.get(cur.size() - 1);
                //get the last dest
                for (int i = 0; i < taken.length; i++) {
                    if (!taken[i] && tickets.get(i).get(0).equals(source)) {
                        addTrip(tickets, cur, taken, results, i);
                    }
                }
            }
        }
    }

    private void addTrip(List<List<String>> tickets, List<String> cur, boolean[] taken, List<List<String>> results, int i) {
        boolean[] curTaken = Arrays.copyOf(taken, taken.length);
        List<String> newCur = new LinkedList<>(cur);
        curTaken[i] = true;
        newCur.add(tickets.get(i).get(1));
        find(tickets, newCur, curTaken, results);
    }*/

    /*YAAAAAAAAAAAAAAAASSSSSSSSSSSSSS
    461ms
    Beats 5.11% of users with Java*/
    public List<String> findItinerary(List<List<String>> tickets) {
        //sort tickets by dest
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < tickets.size() - 1; i++) {
                for (int j = 0; j < 3; j++) {
                    List<String> cur = tickets.get(i);
                    List<String> next = tickets.get(i + 1);
                    if (cur.get(1).charAt(j) > next.get(1).charAt(j)) {
                        sorted = false;
                        tickets.add(i+2, cur);
                        tickets.remove(cur);
                        break;
                    }
                    if (cur.get(1).charAt(j) < next.get(1).charAt(j))
                        break;
                }
            }
        }
        List<int[]> results = new LinkedList<>();
        find(tickets, new int[tickets.size()], 0, -1, results);
        int[] resSeq = results.get(0);
        String[] resArr = new String[tickets.size()+1];
        resArr[0] = "JFK";
        //deconstruct from sequence
        for (int i = 0; i < resSeq.length; i++) {
            resArr[resSeq[i]] = tickets.get(i).get(1);
        }
        return Arrays.asList(resArr);
    }

    void find(List<List<String>> tickets, int[] order, int depth, int last, List<int[]> results) {
        if (!results.isEmpty()) {
            return;
        }
        if (depth == tickets.size()) {
            results.add(Arrays.copyOf(order, order.length));
        }
        else {
            String source = "JFK";
            if (last!=-1) {
                source = tickets.get(last).get(1);
            }
            //get the last dest
            for (int i = 0; i < order.length; i++) {
                if (order[i]==0 && tickets.get(i).get(0).equals(source)) {
                    order[i] = depth+1;
                    find(tickets, order, depth+1, i, results);
                    order[i] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        List<String> res;
        List<List<String>> tickets;

        res = Arrays.asList("JFK","ATL","JFK","SFO","ATL","SFO");
        tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        assertEquals(res, findItinerary(tickets));

        res = Arrays.asList("JFK","AAA","JFK","CCC","JFK","BBB");
        tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK","AAA"));
        tickets.add(Arrays.asList("AAA","JFK"));
        tickets.add(Arrays.asList("JFK","BBB"));
        tickets.add(Arrays.asList("JFK","CCC"));
        tickets.add(Arrays.asList("CCC","JFK"));
        assertEquals(res, findItinerary(tickets));

        res = Arrays.asList("JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL");
        tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("ORD","PHL"));
        tickets.add(Arrays.asList("JFK","ORD"));
        tickets.add(Arrays.asList("PHX","LAX"));
        tickets.add(Arrays.asList("LAX","JFK"));
        tickets.add(Arrays.asList("PHL","ATL"));
        tickets.add(Arrays.asList("ATL","PHX"));
        assertEquals(res, findItinerary(tickets));

        res = Arrays.asList("JFK","MUC","LHR","SFO","SJC");
        tickets = new LinkedList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        assertEquals(res, findItinerary(tickets));

    }
}
