package com.company;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-underground-system/
public class _1396_DesignUndergroundSystem {

    class UndergroundSystem {

        Map<String, double[]> routeToAvgDistMap;

        Map<Integer, String> stationCheckIns;

        public UndergroundSystem() {
            routeToAvgDistMap = new HashMap<>();
            stationCheckIns = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            stationCheckIns.put(id, stationName + "_" + t);
        }

        public void checkOut(int id, String stationName, int t) {
            String s = stationCheckIns.get(id);
            String[] split = s.split("_");
            int checkInTime = Integer.parseInt(split[1]);
            String checkInStationName = split[0];
            String key = checkInStationName + "_" + stationName;
            double[] val = routeToAvgDistMap.get(key);
            int curTime = t - checkInTime;
            if (val==null) {
                val = new double[]{curTime,1};
            }
            else {
                val[0]+=curTime;
                val[1]++;
            }
            routeToAvgDistMap.put(key, val);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "_" + endStation;
            double[] val = routeToAvgDistMap.get(key);
            return val[0]/val[1];
        }
    }
}
