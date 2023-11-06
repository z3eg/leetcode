package com.company;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class _1845 {

    /*34ms
    Beats 71.93%of users with Java*/
    /*class SeatManager {

        int counter;
    Set<Integer> set;

        public SeatManager(int n) {
            counter = 1;
            set = new TreeSet<>();
        }

        public int reserve() {
            if (!set.isEmpty()) {
                Integer next = set.iterator().next();
                set.remove(next);
                return next;
            }
            counter++;
            return counter-1;
        }

        public void unreserve(int seatNumber) {
            set.add(seatNumber);
        }
    }*/

    /*32ms
    Beats 76.64%of users with Java*/
    class SeatManager {

        int counter;
        Set<Integer> set;

        public SeatManager(int n) {
            counter = 1;
            set = new TreeSet<>();
        }

        public int reserve() {
            if (!set.isEmpty()) {
                Iterator<Integer> iterator = set.iterator();
                Integer next = iterator.next();
                iterator.remove();
                return next;
            }
            counter++;
            return counter-1;
        }

        public void unreserve(int seatNumber) {
            set.add(seatNumber);
        }
    }

    @Test
    public void test() {
//        ["SeatManager","reserve","reserve","unreserve","unreserve","reserve","unreserve","reserve","unreserve"]
        //[[3],[],[],[1],[2],[],[1],[],[1]]
//        Expected: [null,1,2,null,null,1,null,1,null]
        SeatManager seatManager = new SeatManager(3);
        assertEquals(1, seatManager.reserve());
        assertEquals(2, seatManager.reserve());
        seatManager.unreserve(1);
        seatManager.unreserve(2);
        assertEquals(1, seatManager.reserve());
        seatManager.unreserve(1);
        assertEquals(1, seatManager.reserve());
        seatManager.unreserve(1);
    }
}
