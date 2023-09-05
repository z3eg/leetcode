package com.company;

/*
https://leetcode.com/problems/design-browser-history/
        1472. Design Browser History
*/

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class _1472 {

    /*63ms
    Beats 28.59%of users with Java*/
    /*class BrowserHistory {

        Deque<String> back = new LinkedList<>();
        Deque<String> forward = new LinkedList<>();
        String curPage;

        public BrowserHistory(String homepage) {
            curPage = homepage;
        }

        public void visit(String url) {
            back.push(curPage);
            curPage = url;
            forward.clear();
        }

        public String back(int steps) {
            for (int i = 0; i < steps; i++) {
                if (!back.isEmpty()) {
                    forward.push(curPage);
                    curPage = back.pop();
                }
            }
            return curPage;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps; i++) {
                if (!forward.isEmpty()) {
                    back.push(curPage);
                    curPage = forward.pop();
                }
            }
            return curPage;
        }
    }*/

    /*46ms
    Beats 94.28%of users with Java*/
    class BrowserHistory {

        class Page {
            String url;
            Page next;
            Page prev;

            public Page(String url) {
                this.url = url;
            }

            public Page(String url, Page prev) {
                this.url = url;
                this.prev = prev;
            }
        }

        Page curPage;

        public BrowserHistory(String homepage) {
            curPage = new Page(homepage);
        }

        public void visit(String url) {
            curPage.next = new Page(url, curPage);
            curPage = curPage.next;
        }

        public String back(int steps) {
            for (int i = 0; i < steps; i++) {
                if (curPage.prev!=null)
                    curPage = curPage.prev;
            }
            return curPage.url;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps; i++) {
                if (curPage.next!=null)
                    curPage = curPage.next;
            }
            return curPage.url;
        }
    }

    @Test
    public void test() {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        assertEquals("leetcode.com", browserHistory.curPage.url);
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        assertEquals("google.com", browserHistory.curPage.url);
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        assertEquals("facebook.com", browserHistory.curPage.url);
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        assertEquals("youtube.com", browserHistory.curPage.url);
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        assertEquals("facebook.com", browserHistory.curPage.url);
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        assertEquals("google.com", browserHistory.curPage.url);
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        assertEquals("facebook.com", browserHistory.curPage.url);
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        assertEquals("linkedin.com", browserHistory.curPage.url);
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        assertEquals("linkedin.com", browserHistory.curPage.url);
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        assertEquals("google.com", browserHistory.curPage.url);
        browserHistory.back(7);// You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
        assertEquals("leetcode.com", browserHistory.curPage.url);
    }
}
