package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//https://leetcode.com/problems/evaluate-division/
public class _399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        HashMap<String, Double> eqVals = new HashMap<>();
        HashSet<String> knownDivisors = new HashSet<>();
        HashSet<String> knownNumbers = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> curEq = equations.get(i);
            eqVals.put(curEq.get(0)+"/"+curEq.get(1),values[i]);
            knownDivisors.add(curEq.get(1));
            knownNumbers.add(curEq.get(0));
            knownNumbers.add(curEq.get(1));
        }
        Set<String> keySet = new HashSet<>(eqVals.keySet());
        for (String divisor: knownDivisors) {
            for (String key: keySet) {
                if (key.contains("/"+divisor)) {
                    for (String key2: keySet) {
                        if (key2.contains(divisor+"/")) {
                            Double val1 = eqVals.get(key);
                            Double val2 = eqVals.get(key2);
                            eqVals.put(key.split("/")[0]+"/"+key2.split("/")[1], val1 * val2);
                        }
                    }
                }
            }
        }
        keySet = new HashSet<>(eqVals.keySet());
        for (String key: keySet) {
            eqVals.put((key.split("/")[1] + "/" + key.split("/")[0]), 1/eqVals.get(key));
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> ithQuery = queries.get(i);

            String divident = ithQuery.get(0);
            String divisor = ithQuery.get(1);
            if (divident.equals(divisor) && knownNumbers.contains(divisor))
                res[i]=1;
            else {
                Double ithRes = eqVals.get(divident + "/" + divisor);
                res[i] = ithRes==null?-1:ithRes;
            }
        }
        //
        return res;
    }

    @Test
    public void test() {
        LinkedList<List<String>> equations = new LinkedList<>();
        LinkedList<String> eq = new LinkedList<>();
        eq.add("a");
        eq.add("b");
        equations.add(eq);
        eq = new LinkedList<>();
        eq.add("b");
        eq.add("c");
        equations.add(eq);

        LinkedList<List<String>> queries = new LinkedList<>();
        LinkedList<String> query = new LinkedList<>();
        query.add("a");
        query.add("c");
        queries.add(query);
        query = new LinkedList<>();
        query.add("b");
        query.add("a");
        queries.add(query);
        query = new LinkedList<>();
        query.add("a");
        query.add("e");
        queries.add(query);
        query = new LinkedList<>();
        query.add("a");
        query.add("a");
        queries.add(query);
        query = new LinkedList<>();
        query.add("x");
        query.add("x");
        queries.add(query);
        assertArrayEquals(new double[]{6.00000,0.50000,-1.00000,1.00000,-1.00000},calcEquation(equations,new double[]{2,3},queries));
    }
}
