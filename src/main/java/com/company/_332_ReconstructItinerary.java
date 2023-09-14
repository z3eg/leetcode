package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/reconstruct-itinerary/description/?envType=daily-question&envId=2023-09-14
public class _332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
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
        char min;
        List<String> res = null;
        for (int i = 0; i < candidates.get(0).size(); i++) {
            for (int j = 0; j < 3; j++) {
                min = candidates.get(0).get(i).charAt(j);
                for (int k = 1; k < candidates.size(); k++) {
                    if (candidates.get(k).get(i).charAt(j)<min) {
                        min = candidates.get(k).get(i).charAt(j);
                        res = candidates.get(k);
                    }
                }
                if (res!=null)
                    return res;
            }
        }
        return null;
    }

    @Test
    public void test() {
        List<String> res = Arrays.asList("JFK","MUC","LHR","SFO","SJC");
        List<List<String>> tickets = new LinkedList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        assertEquals(res, findItinerary(tickets));
        res = Arrays.asList("JFK","ATL","JFK","SFO","ATL","SFO");
        tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        assertEquals(res, findItinerary(tickets));

    }
}
