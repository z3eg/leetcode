package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/*950. Reveal Cards In Increasing Order
        https://leetcode.com/problems/reveal-cards-in-increasing-order/*/
public class _950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        //get the desired state
        Arrays.sort(deck);
        int deckLen = deck.length;
        LinkedList<Integer> deckList = new LinkedList<>();
        ArrayList<Integer> revealed = new ArrayList<>();
        for (int card : deck) {
            revealed.add(card);
        }
        //do reverse operations to get the starting state
        boolean toTop = true;
        while (!revealed.isEmpty()) {
            Integer card;
            if (toTop) {
                card = revealed.get(revealed.size() - 1);
                revealed.remove(card);
            }
            else {
                card = deckList.get(deckList.size() - 1);
                deckList.remove(card);
            }
            deckList.addFirst(card);
            toTop = !toTop;
        }
        //put deck into an array
        for (int i = 0; i < deckLen; i++) {
            deck[i] = deckList.get(i);
        }
        return deck;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,13,3,11,5,17,7}, deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7}));
        assertArrayEquals(new int[]{1,1000}, deckRevealedIncreasing(new int[]{1,1000}));
        assertArrayEquals(new int[]{1}, deckRevealedIncreasing(new int[]{1}));
    }
}
