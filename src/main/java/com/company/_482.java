package com.company;

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
    public String licenseKeyFormatting(String s, int k) {
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
    }
}
