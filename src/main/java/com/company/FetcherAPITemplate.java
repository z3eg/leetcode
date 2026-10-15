package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FetcherAPITemplate {

    class Page {

        private static final int PAGE_SIZE = 7;
        int pageNumber;
        private final List<Integer> content;

        public Page(int pageNumber) {
            this.pageNumber = pageNumber;
            this.content = new ArrayList<>();
            int firstRes = pageNumber*PAGE_SIZE;
            int lastRes = (pageNumber+1)*PAGE_SIZE;
            for (int i = firstRes; i <= lastRes; i++)
                this.content.add(i);
        }

        public List<Integer> getContent() {
            return content;
        }
    }
    class Client {
        Page getPage(int pageNum) {
            return new Page(pageNum);
        }
    }

    class Fetcher {

        Client client;


        public Fetcher(Client client) {
            this.client = client;
        }

        //get n next results
        List<Integer> fetch(int n) { //implement this
            return null;
        }
    }

    @Test
    public void test() {
        Fetcher fetcher = new Fetcher(new Client());
        ArrayList<Integer> expected;

        expected = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            expected.add(i);
        }
        assertEquals(expected,fetcher.fetch(5));

        expected = new ArrayList<>();
        for (int i = 5; i < 7; i++) {
            expected.add(i);
        }
        assertEquals(expected,fetcher.fetch(2));

        expected = new ArrayList<>();
        for (int i = 7; i < 12; i++) {
            expected.add(i);
        }
        assertEquals(expected,fetcher.fetch(5));
        expected = new ArrayList<>();
        for (int i = 12; i < 115; i++) {
            expected.add(i);
        }
        assertEquals(expected,fetcher.fetch(103));
    }
}
