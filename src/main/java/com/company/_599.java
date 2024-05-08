package com.company;

import java.util.*;

public class _599 {

    /*112
    ms
            Beats
13.03%
    of users with Java*/
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    List<String> strings = map.get(i + j);
                    if (strings==null)
                        strings = new LinkedList<>();
                    strings.add(list1[i]);
                    map.put(i+j, strings);
                }
            }
        }
        List<String> value = map.entrySet().iterator().next().getValue();
        String[] res = new String[value.size()];
        for (int i = 0; i < value.size(); i++) {
            res[i] = value.get(i);
        }
        return res;
    }

}
