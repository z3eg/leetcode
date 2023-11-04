package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1503 {

    /*public int getLastMoment(int n, int[] left, int[] right) {
        int[][] ants = new int[left.length+right.length][4]; //0-pos //1-direction //2-fallen or not //3-turned this turn or not
        for (int i = 0; i < left.length; i++) {
            ants[i][0] = left[i];
            ants[i][1] = -1;
        }
        for (int i = 0; i < right.length; i++) {
            ants[left.length+i][0] = right[i];
            ants[left.length+i][1] = 1;
        }
        int fallenAnts = 0;
        int time = -1;
        while (fallenAnts<ants.length) {
            time++;
            //reset turned state of all ants
            char[] arr = new char[n+1];
            for (int i = 0; i < n+1; i++) {
                arr[i]='_';
            }
            for(int[] ant : ants) {
                ant[3] = 0;
                if (ant[2]!=1)
                    arr[ant[0]] = (ant[1]==1)?'>':'<';
            }
            System.out.println(time + "\t" + new String(arr));
            for (int i = 0; i < ants.length; i++) {
                if (ants[i][2]==0) {
                    ants[i][0]+=ants[i][1];
                    if ((ants[i][0]==-1 && ants[i][1]==-1) || (ants[i][0]==n+1 && ants[i][1]==1)) { //fall condition
                        fallenAnts++;
                        ants[i][2] = 1;
                    }
                    if (ants[i][2]==0 && ants[i][3]==0)  {  //not fallen and not turned
                        for (int j = 0; j < ants.length; j++) {
                            if (ants[j][2]==0 && ants[i][1]==1 && ants[j][1]==-1 && ants[j][0]-ants[i][0]==0) { //turn condition
                                ants[i][3] = 1;
                                ants[i][1]*=-1;
                                ants[j][3] = 1;
                                ants[j][1]*=-1;
                                break;
                            }
                        }
                    }
                    //check and turn ants
                }
            }
        }
        return time;
    }*/

    /*public int getLastMoment(int n, int[] left, int[] right) {
        int[][] ants = new int[left.length+right.length][4]; //0-pos //1-direction //2-fallen or not //3-turned this turn or not
        for (int i = 0; i < left.length; i++) {
            ants[i][0] = left[i];
            ants[i][1] = -1;
        }
        for (int i = 0; i < right.length; i++) {
            ants[left.length+i][0] = right[i];
            ants[left.length+i][1] = 1;
        }
        int fallenAnts = 0;
        int time = -1;
        while (fallenAnts<ants.length) {
            time++;
            //reset turned state of all ants
            char[] arr = new char[n+1];
            for (int i = 0; i < n+1; i++) {
                arr[i]='_';
            }
            for(int[] ant : ants) {
                ant[3] = 0;
                if (ant[2]!=1)
                    arr[ant[0]] = (ant[1]==1)?'>':'<';
            }
            System.out.println(time + "\t" + new String(arr));
            for (int i = 0; i < ants.length; i++) {
                if (ants[i][2]==0) {
                    if (ants[i][2]==0 && ants[i][3]==0)  {  //not fallen and not turned
                        for (int j = 0; j < ants.length; j++) {
                            *//*if ((ants[j][2]==0 && ants[j][0]==ants[i][0]) ||//check if in the same spot
                                 (ants[i][1]==1 && ants[j][1]==-1 && ants[j][0]-ants[i][0]==1)) { //check if face to face*//*
                            if (ants[j][2]==0 && ants[i][1]==1 && ants[j][1]==-1 && ants[j][0]-ants[i][0]==0) {
                                ants[i][3] = 1;
                                ants[i][1]*=-1;
                                ants[j][3] = 1;
                                ants[j][1]*=-1;
                                break;
                            }
                        }
                    }
                    ants[i][0]+=ants[i][1];
                    if ((ants[i][0]==-1 && ants[i][1]==-1) || (ants[i][0]==n+1 && ants[i][1]==1)) { //fall condition
                        fallenAnts++;
                        ants[i][2] = 1;
                    }
                }
            }
        }
        return time;
    }*/

    /*1280ms
    Beats 16.48%of users with Java*/
    /*public int getLastMoment(int n, int[] left, int[] right) {
        int[][] ants = new int[left.length+right.length][3]; //0-pos //1-direction //2-fallen
        for (int i = 0; i < left.length; i++) {
            ants[i][0] = left[i];
            ants[i][1] = -1;
        }
        for (int i = 0; i < right.length; i++) {
            ants[left.length+i][0] = right[i];
            ants[left.length+i][1] = 1;
        }
        int fallenAnts = 0;
        int time = -1;
        while (fallenAnts<ants.length) {
            time++;
            //print current ant state
            char[] arr = new char[n+1];
            for (int i = 0; i < n+1; i++) {
                arr[i]='_';
            }
            for(int[] ant : ants) {
                if (ant[2]!=1)
                    arr[ant[0]] = (ant[1]==1)?'>':'<';
            }
            System.out.println(time + "\t" + new String(arr));
            for (int i = 0; i < ants.length; i++) {
                if (ants[i][2]==0) {
                    ants[i][0] += ants[i][1];
                    if (ants[i][0] < 0 || ants[i][0] > n) {
                        fallenAnts++;
                        ants[i][2] = 1;
                    }
                }
            }
        }
        return time;
    }*/


    /*1101ms
    Beats 16.48%of users with Java*/
    /*public int getLastMoment(int n, int[] left, int[] right) {
        int fallenAnts = 0;
        int time = -1;
        while (fallenAnts<left.length+right.length) {
            time++;
            for (int i = 0; i < left.length; i++) {
                if (left[i]>=0) {
                    left[i]--;
                    if (left[i]<0)
                        fallenAnts++;
                }
            }
            for (int i = 0; i < right.length; i++) {
                if (right[i]<n+1) {
                    right[i]++;
                    if (right[i]==n+1)
                        fallenAnts++;
                }
            }
        }
        return time;
    }*/

    /*0ms
    Beats 100.00%of users with Java*/
    public int getLastMoment(int n, int[] left, int[] right) {
        int lmax = 0;
        for (int l : left) {
            lmax = Math.max(lmax, l);
        }
        int rmax = 0;
        for (int r : right) {
            rmax = Math.max(rmax, (n - r));
        }
        return Math.max(lmax, rmax);
    }



    @Test
    public void test() {
//        assertEquals(3, getLastMoment(4, new int[]{2}, new int[]{1}));
        assertEquals(4, getLastMoment(4, new int[]{4,3}, new int[]{0,1}));
        assertEquals(7, getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7}));
        assertEquals(7, getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{}));
    }
}
