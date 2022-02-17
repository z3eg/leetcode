package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



public class Main {




    ////////////////////////////////////////////////////////////
    //https://leetcode.com/problems/sequential-digits/
    public static void main(String[] args) {
        System.out.println(seqDigs(10,1000000000));
    }

    public static List<Integer> seqDigs(int low, int high) {
        int [] seqDigsArr = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567,
                5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678,
                3456789, 12345678, 23456789, 123456789};
        ArrayList<Integer> seqDigs = new ArrayList<>();
        int i = 0;
        while (seqDigsArr[i] < low) {
            i++;
        }
        while (i < seqDigsArr.length && seqDigsArr[i] <= high) {
            seqDigs.add(seqDigsArr[i]);
            i++;
        }
        return seqDigs;
    }

    /*public static List<Integer> sequentialDigits(int low, int high) {
        if (high > 123456789) {
            high = 123456789;
        }
        List<Integer> sequentialDigits = new ArrayList<>();
        String digits = "123456789";
        int frameStart = getFirstDigit(low)-1;
        int frameSize = getDigitNumber(low);
        int digit = low;
        while (digit <= high && frameSize<=digits.length()) {
            if (frameStart+frameSize <= digits.length()) {
                digit = Integer.parseInt(digits.substring(frameStart,frameStart+frameSize));
                if (digit>=low) {
                    frameStart++;
                    if (digit<=high)
                        sequentialDigits.add(digit);
                }
            }
            else {
                frameSize++;
                frameStart = 0;
            }
        }
        return sequentialDigits;
    }

    private static int getDigitNumber(int digit) {
        int number = 1;
        while (digit/10 >= 1) {
            number++;
            digit/=10;
        }
        return number;
    }

    private static int getFirstDigit(int digit) {
        while (digit/10 >= 1) {
            digit/=10;
        }
        return digit;
    }

    private static boolean isSequentialDigit(int digit) {
        int digitLength = String.valueOf(digit).length();
        int curDig = digit%10;
        for (int i = digitLength; i > 0; i--) {
            if (curDig - (digit/10)%10 != 1) {
                return false;
            }
            else {
                digit = digit/10;
                curDig = digit%10;
            }
        }
        return true;
    }*/
    ////////////////////////////////////////////////////////////
    //https://leetcode.com/problems/stone-game-iv/
    /*public static void main(String[] args) {
        System.out.println(winnerSquareGame(4));
    }

    public static boolean winnerSquareGame(int n) {
        int[] squares = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400,
                441, 484, 529, 576, 625, 676, 729, 784, 841, 900, 961, 1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521,
                1600, 1681, 1764, 1849, 1936, 2025, 2116, 2209, 2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136,
                3249, 3364, 3481, 3600, 3721, 3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329,
                5476, 5625, 5776, 5929, 6084, 6241, 6400, 6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100,
                8281, 8464, 8649, 8836, 9025, 9216, 9409, 9604, 9801, 10000, 10201, 10404, 10609, 10816, 11025, 11236,
                11449, 11664, 11881, 12100, 12321, 12544, 12769, 12996, 13225, 13456, 13689, 13924, 14161, 14400, 14641,
                14884, 15129, 15376, 15625, 15876, 16129, 16384, 16641, 16900, 17161, 17424, 17689, 17956, 18225, 18496,
                18769, 19044, 19321, 19600, 19881, 20164, 20449, 20736, 21025, 21316, 21609, 21904, 22201, 22500, 22801,
                23104, 23409, 23716, 24025, 24336, 24649, 24964, 25281, 25600, 25921, 26244, 26569, 26896, 27225, 27556,
                27889, 28224, 28561, 28900, 29241, 29584, 29929, 30276, 30625, 30976, 31329, 31684, 32041, 32400, 32761,
                33124, 33489, 33856, 34225, 34596, 34969, 35344, 35721, 36100, 36481, 36864, 37249, 37636, 38025, 38416,
                38809, 39204, 39601, 40000, 40401, 40804, 41209, 41616, 42025, 42436, 42849, 43264, 43681, 44100, 44521,
                44944, 45369, 45796, 46225, 46656, 47089, 47524, 47961, 48400, 48841, 49284, 49729, 50176, 50625, 51076,
                51529, 51984, 52441, 52900, 53361, 53824, 54289, 54756, 55225, 55696, 56169, 56644, 57121, 57600, 58081,
                58564, 59049, 59536, 60025, 60516, 61009, 61504, 62001, 62500, 63001, 63504, 64009, 64516, 65025, 65536,
                66049, 66564, 67081, 67600, 68121, 68644, 69169, 69696, 70225, 70756, 71289, 71824, 72361, 72900, 73441,
                73984, 74529, 75076, 75625, 76176, 76729, 77284, 77841, 78400, 78961, 79524, 80089, 80656, 81225, 81796,
                82369, 82944, 83521, 84100, 84681, 85264, 85849, 86436, 87025, 87616, 88209, 88804, 89401, 90000, 90601,
                91204, 91809, 92416, 93025, 93636, 94249, 94864, 95481, 96100, 96721, 97344, 97969, 98596, 99225, 99856};
        boolean isAlicesTurn = true;
        while (n>0) {
            if (isSquare(n)) {
                return isAlicesTurn;
            }
            int i = (int) Math.sqrt(n);
            if (i>2)
                i--;
            //found
            boolean resultsInLoss = true;
            while (resultsInLoss && i>0) {
                resultsInLoss = false;
                int res = n - squares[i];
                if (i!=1 && isSquare(res)) {
                    resultsInLoss = true;
                    i--;
                }
            }
            n-=squares[i];
            isAlicesTurn=!isAlicesTurn;
        }
        return !isAlicesTurn;
    }

    private static boolean isSquare(int input) {
        int x = (int) Math.sqrt(input);
        return (Math.pow(x,2) == input);
    }*/
    ////////////////////////////////////////////////////////////
    //https://leetcode.com/problems/gas-station/submissions/
    /*private static final int[] gas = {1,2,3,4,5};
    private static final int[] cost = {3,4,5,1,2};

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int bestStationPos = 0;
        int[] diff = new int[gas.length];
        int totalDiff = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas+=gas[i];
            sumCost+=cost[i];
            diff[i] = gas[i]-cost[i];
            totalDiff += diff[i];
            if (totalDiff <= 0) {
                totalDiff = 0;
                bestStationPos = (i+1<gas.length) ? i+1 : 0;
            }
        }
        if (sumGas<sumCost) {
            return -1;
        }
        else {
            return bestStationPos;
        }
    }*/



    ////////////////////////////////////////////////////////////
    //https://leetcode.com/problems/koko-eating-bananas/

    /*private static int[] piles = {3,6,7,11}; //4
    private static int h = 8;
    *//*private static int[] piles = {30,11,23,4,20}; //30
    private static int h = 5;*//*
    *//*private static int[] piles = {30,11,23,4,20}; //23
    private static int h = 6;*//*


    public static void main(String[] args) {
        System.out.println(minEatingSpeed(piles,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        if (piles.length==1) {
            return (int)Math.ceil((double)piles[0]/h);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < piles.length; i++) {
            integers.add(piles[i]);
        }
        Arrays.sort(piles);
        if (piles.length==h) {
            return piles[piles.length-1];
        }
        while (integers.size() < h) {
            Collections.sort(integers);
            Integer max = integers.get(integers.size() - 1);
            integers.set(integers.size()-1, (int) Math.ceil((double)max/2));
            integers.add(max/2);
        }
        Collections.sort(integers);
        return integers.get(integers.size()-1);
    }*/


    /*public static int minEatingSpeed(int[] piles, int h) {
        if (piles.length==1) {
            return (int)Math.ceil((double)piles[0]/h);
        }
        Arrays.sort(piles);
        if (piles.length==h) {
            return piles[piles.length-1];
        }
        int extraHours = h - piles.length;
        int posToSplit = piles.length-1;
        int hoursRequired = 0;
        int biteSize = piles[posToSplit];
        while (hoursRequired < extraHours) {
            hoursRequired = 0;
            biteSize=Math.max(gcdByEuclidsAlgorithm(piles[posToSplit],piles[posToSplit-1]),piles[posToSplit-1]);
            for (int i = posToSplit; i<piles.length; i++) {
                hoursRequired+=Math.ceil((double)piles[posToSplit]/biteSize);
            }
            posToSplit--;
        }
        return biteSize;
        //brute force pretty much, time limit exceeded
        *//*int biteSize = 0;
        int hoursConsumed=h+1;
        while (hoursConsumed>h) {
            hoursConsumed = 0;
            biteSize++;
            for (int i = 0; i < piles.length; i++) {
                hoursConsumed+=Math.ceil((double)piles[i]/biteSize);
            }
        }
        return biteSize;*//*
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }*/

    /*public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int biteSize = piles[piles.length-1];
        boolean theyReturn = false;
        while (!theyReturn) {
            int[] newPiles = Arrays.copyOf(piles, piles.length);
            int currentPile = 0;
            int hoursConsumed = 0;
            while (currentPile < piles.length) {
                while (newPiles[currentPile]>0) {
                    newPiles[currentPile]-=biteSize;
                    hoursConsumed++;
                }
                currentPile++;
            }
            if (hoursConsumed<=h) {
//                biteSize--;
                biteSize = decreaseBiteSize(newPiles, biteSize);
            }
            else {
                theyReturn = true;
            }
        }
        return biteSize+1;

        *//*Arrays.sort(piles);
        if (piles.length==h) {
            return piles[piles.length-1];
        }
        else {
            int spareHours = h - piles.length;
            int splitStartPos = piles.length - (spareHours);// - 1;
            int timesBigger = (int) Math.ceil(piles[piles.length-1]/piles[splitStartPos]);
            return piles[piles.length-1]/timesBigger;
        }*//*

    }

    private static int decreaseBiteSize(int[] piles, int biteSize) {
        for (int i = piles.length-1; i>=0; i--) {
            if (biteSize>piles[i]) {
                return (biteSize/2>piles[i]) ? biteSize/2 : piles[i];
            }
        }
        return biteSize-1;
    }*/

    ////////////////////////////////////////////////////////
    //https://leetcode.com/problems/maximize-distance-to-closest-person/
    /*private static int[] seats = {1,0,0,0,1,0,1}; //Output: 2
//    private static int[] seats = {1,0,0,0}; //Output: 3
//    private static int[] seats = {0,1}; //Output: 1

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        if (seats.length == 2) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int seat : seats) {
            stringBuilder.append(seat);
        }
        String s = stringBuilder.toString();
        String[] freeRanges = s.split("1");
        int leftMostRange = 0;
        int rightMostRange = 0;
        if (s.startsWith("0")) {
            leftMostRange = freeRanges[0].length();
        }
        if (s.endsWith("0")) {
            rightMostRange = freeRanges[freeRanges.length-1].length();
        }
        int biggestSideRange = Math.max(leftMostRange, rightMostRange);
        Arrays.sort(freeRanges, Comparator.comparingInt(String::length));
        int farthestInBetween = (int) Math.ceil((double) freeRanges[freeRanges.length - 1].length() / 2);
        return Math.max(biggestSideRange, farthestInBetween);
    }*/

    ////////////////////////////////////////////////////////
    //https://leetcode.com/problems/can-place-flowers/

    /*private static int[] flowerbed = {1,0,0,0,1};
    private static int n = 1;*//*

    *//*private static int[] flowerbed = {1,0,0,0,1};
    private static int n = 2;*//*

    *//*private static int[] flowerbed = {1,0,0,0,1,0,0};
    private static int n = 2;*//*

    private static int[] flowerbed = {1,0,0,0};
    private static int n = 1;

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int posToPlant = 0;
        while (posToPlant < flowerbed.length) {
            if (n==0) {
                return true;
            }
            else {
                if (flowerbed[posToPlant]==1) {
                    posToPlant+=2;
                }
                else {
                    if (flowerbed.length==posToPlant+1) {
                        n--;
                        if (n == 0)
                            return true;
                        posToPlant += 2;
                    }
                    else {
                        if (flowerbed[posToPlant + 1] == 1) {
                            posToPlant += 3;
                        }
                        else {
                            n--;
                            if (n == 0)
                                return true;
                            posToPlant += 2;
                        }
                    }
                }
            }
        }
        return false;
    }*/

    ////////////////////////////////////////////////
//    https://leetcode.com/problems/word-pattern/
    /*public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] array = s.split(" ");
        if (pattern.length() !=array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++)
        {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(array[i])) {
                    return false;
                }
                map.put(pattern.charAt(i),array[i]);
            }
            else {
                if (!map.get(pattern.charAt(i)).equals(array[i])) {
                    return false;
                }
            }
        }
        return true;
    }*/


    ///////////////////////////////

    /*private static int[][] ex1 = {{10,16},{2,8},{1,6},{7,12}};
    private static int[][] ex2 = {{1,2},{3,4},{5,6},{7,8}};
    private static int[][] ex3 = {{1,2},{2,3},{3,4},{4,5}};
    private static int[][] ex4 = {{0,11},{7,20},{12,27},{10,12},{4,9},{7,15}};

    public static void main(String[] args) {
	// write your code here
//        System.out.println(intersect(new int[]{2, 8}, new int[]{1, 6}));
        System.out.println(Arrays.deepToString(findIntersections(ex4)));
    }

    private static int[][] findIntersections(int[][] points) {
        ArrayList<int[]> intersections = new ArrayList<>();
        int curpos = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = curpos; j < points.length; j++) {
                if (i != j) {
                    if (intersect(points[i],points[j]))
                        intersections.add(new int[]{max(points[i][0],points[j][0]), min(points[i][1],points[j][1])});
                }
            }
            curpos++;
        }
        return intersections.toArray(new int[intersections.size()][]);
//        return new int[][]{{0, 0},{0,0}};
    }

    private static int max(int a, int b) {
        return (a>b) ? a : b;
    }

    private static int min(int a, int b) {
        return (a<b) ? a : b;
    }

    private static boolean intersect(int[] a, int[] b) {
        if (a[0] > b[1] || b[0] > a[1])
            return false;
        else {
            return (a[1] > b[0]) || (b[1] > a[0]);
        }
    }*/
}
