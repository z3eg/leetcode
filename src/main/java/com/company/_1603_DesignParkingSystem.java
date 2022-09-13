package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/problems/design-parking-system/
public class _1603_DesignParkingSystem {

    class ParkingSystem {

        int[] carSpots;

        public ParkingSystem(int big, int medium, int small) {
            carSpots = new int[]{big,medium,small};
        }

        public boolean addCar(int carType) {
            if (carSpots[carType-1]>0) {
                carSpots[carType-1]--;
                return true;
            }
            return false;
        }
    }

    @Test
    public void test() {
//        ParkingSystem obj = new ParkingSystem(big, medium, small);
        ParkingSystem obj = new ParkingSystem(1,1,0);
        assertTrue(obj.addCar(1));
        assertTrue(obj.addCar(2 ));
        assertFalse(obj.addCar(3 ));
        assertFalse(obj.addCar(1 ));
    }

    /*Input
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
Output
[null, true, true, false, false]

Explanation
ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
parkingSystem.addCar(3); // return false because there is no available slot for a small car
parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.


Constraints:

0 <= big, medium, small <= 1000
carType is 1, 2, or 3
At most 1000 calls will be made to addCar*/
}
