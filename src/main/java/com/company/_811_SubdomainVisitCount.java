package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/subdomain-visit-count/
public class _811_SubdomainVisitCount {
    /*15ms
    Beats 85.23%of users with Java*/
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
            String[] split = cp.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            while (domain.contains(".")) {
                Integer totalDomainCount = map.get(domain);
                if (totalDomainCount==null)
                    totalDomainCount = 0;
                totalDomainCount+=count;
                map.put(domain, totalDomainCount);
                domain = domain.substring(domain.indexOf(".")+1);
            }
            Integer totalDomainCount = map.get(domain);
            if (totalDomainCount==null)
                totalDomainCount = 0;
            totalDomainCount+=count;
            map.put(domain, totalDomainCount);
        }
        List<String> res = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    @Test
    public void test() {
        subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    }
}
