package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FetcherAPI {

    class Page {

        int pageNumber;
        private final List<Integer> content;

        public Page(int pageNumber) {
            this.pageNumber = pageNumber;
            this.content = new ArrayList<>();
            int firstRes = pageNumber*10;
            int lastRes = (pageNumber+1)*10;
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

        private static final int PAGE_SIZE = 10;
        Client client;
        Page curPage;
        int lastCalledNum;
        int lastFetchedNum;
        int curPageNum;

        public Fetcher(Client client) {
            this.client = client;
            this.curPage = client.getPage(0);
            this.lastCalledNum = PAGE_SIZE-1;
            this.lastFetchedNum = -1;
            this.curPageNum = 0;
        }

        //get n next results
        List<Integer> fetch(int n) {
            List<Integer> res = new ArrayList<>();
            if (n==0)
                return res;
            int lastNumToFetch = lastFetchedNum+n;
            int curNum = lastFetchedNum;
            List<Integer> curContent = curPage.getContent();
            while (curNum<lastNumToFetch) {
                curNum++;
                if (curNum>this.lastCalledNum) {
                    curPage = client.getPage(++this.curPageNum);
                    curContent = curPage.getContent();
                    this.lastCalledNum+=PAGE_SIZE;
                }
                res.add(curContent.get(curNum%PAGE_SIZE));
            }
            lastFetchedNum = curNum;
            return res;
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
