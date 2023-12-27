package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _482 {

    /*146
    ms
            Beats
14.11%
    of users with Java*/
    /*public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","");
        s = s.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if ((i+1)%k==0)
                stringBuilder.insert(0,"-");
            stringBuilder.insert(0,s.charAt(s.length()-i));
        }
        return stringBuilder.toString();
    }*/

    /*65
    ms
            Beats
26.38%
    of users with Java*/
    /*public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","");
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i <= s.length()/k; i++) {
            int offset = sb.length() - (i-1) - i * k;
            if (offset < 0)
                break;
            sb.insert(offset, "-");
        }
        return sb.toString();
    }*/


    /*Runtime Error
35 / 39 testcases passed*/
    public String licenseKeyFormatting(String s, int k) {
        double chars = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-')
                chars++;
        }
        char[] tmpChars = new char[(int)chars];
        int offset = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-') {
                if (c <= 'z' && c >= 'a') {
                    c -= 32;
                }
                tmpChars[i + offset] = c;
            }
            else
                offset--;
        }
        double dashes = chars/k;
        if (dashes%1==0)
            dashes--;
        chars+=dashes;
        char[] res = new char[(int) chars];
        offset = 0;
        for (int i = 1; i <= tmpChars.length; i++) {
            int pos = (int)chars - i - offset;
            if (pos<0)
                break;
            res[pos] = tmpChars[tmpChars.length-i];
            if (i!=0 && i%k==0) {
                offset++;
                pos--;
                if (pos<0)
                    break;
                res[pos] = '-';
            }
        }
        return new String(res);
    }

    @Test
    public void test() {
        assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
