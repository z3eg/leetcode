package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/number-of-senior-citizens/
public class _2678_NumberOfSeniorCitizens {
    /*Runtime
    0 ms
    Beats
    100%*/
    public int countSeniors(String[] details) {
        int res = 0;
        for (String p : details) {
            if (p.charAt(11)>53 && !(p.charAt(11) == '6' && p.charAt(12) == '0'))
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(2, countSeniors(new String[]{"5612624052M0130","5378802576M6424","5447619845F0171","2941701174O9078"}));
        assertEquals(2, countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
        assertEquals(0, countSeniors(new String[]{"1313579440F2036","2921522980M5644"}));
    }
}
