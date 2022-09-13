package com.company;

import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/destination-city/
public class _1436_DestinationCity {

    public String destCity(List<List<String>> paths) {
        HashSet<String> startPoints = new HashSet<>();
        for (List<String> path : paths) {
            startPoints.add(path.get(0));
        }
        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!startPoints.contains(dest))
                return dest;
        }
        return "";
    }
}
