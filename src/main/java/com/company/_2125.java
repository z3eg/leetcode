package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
2125. Number of Laser Beams in a Bank*/
public class _2125 {

    //25.75%
    /*public int numberOfBeams(String[] bank) {
        LinkedList<Integer> beamRows = new LinkedList<>();
        for (int i = 0; i < bank.length; i++) {
            int devices = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j)=='1')
                    devices++;
            }
            if (devices>0)
                beamRows.add(devices);
        }
        if (beamRows.size()<2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < beamRows.size()-1; i++) {
            res+=beamRows.get(i)*beamRows.get(i+1);
        }
        return res;
    }*/

    //44%
    /*public int numberOfBeams(String[] bank) {
        int res = 0;
        int bankLen = bank.length;
        if (bankLen==1)
            return 0;
        int rowLen = bank[0].length();
        int nextRow = 0;
        int curRowDevices;
        int nextRowDevices;
        do {
            nextRowDevices = devicesOnARow(bank[nextRow],rowLen);
            nextRow++;
        }
        while (nextRowDevices==0 && nextRow<bankLen);
        curRowDevices = nextRowDevices;
        while (nextRow<bankLen) {
            do {
                nextRowDevices = devicesOnARow(bank[nextRow],rowLen);
                nextRow++;
            }
            while (nextRowDevices==0 && nextRow<bankLen);
            res+=curRowDevices*nextRowDevices;
            curRowDevices = nextRowDevices;
        }
        return res;
    }*/

    //44.60%
    public int numberOfBeams(String[] bank) {
        int bankLen = bank.length;
        if (bankLen==1)
            return 0;
        int res = 0;
        int cur = 0;
        int rowLen = bank[0].length();
        for (int i = 0; i < bankLen; i++) {
            int next = devicesOnARow(bank[i], rowLen);
            if (next != 0) {
                res+=cur*next;
                cur = next;
            }
        }
        return res;
    }

    private int devicesOnARow(String row, int rowLen) {
        int res = 0;
        for (char c : row.toCharArray()) {
            if (c=='1')
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(0, numberOfBeams(new String[]{"0","0"}));
        assertEquals(8, numberOfBeams(new String[]{"011001","000000","010100","001000"}));
        assertEquals(0, numberOfBeams(new String[]{"000","111","000"}));
    }
}
