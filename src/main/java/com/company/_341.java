package com.company;

import scala.Int;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*341. Flatten Nested List Iterator
        https://leetcode.com/problems/flatten-nested-list-iterator/description/?envType=daily-question&envId=2023-10-20*/
public class _341 {

   public interface NestedInteger {
       boolean isInteger();
       Integer getInteger();
       List<NestedInteger> getList();
   }

   /* public class NestedIterator implements Iterator<Integer> {

        Stack<List<NestedInteger>> stack;

        List<NestedInteger> cur;

        int curNum;
        int nextNum;

        Stack<Integer> numStack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            numStack = new Stack<>();
            curNum = 0;
            cur = nestedList;
        }

        @Override
        public Integer next() {
            if (curNum >= cur.size()) {
                cur = stack.pop();
                curNum = numStack.pop();
            }
            while (!cur.get(curNum).isInteger()) {
                List<NestedInteger> tmp = cur.get(curNum).getList();
                stack.push(cur);
                cur = tmp;
                numStack.push(curNum);
                curNum = 0;
            }
            Integer res = cur.get(curNum).getInteger();
            curNum++;
            return res;
        }

        @Override
        public boolean hasNext() {
            while (!cur.get(curNum).isInteger()) {
                if (curNum < cur.size() && cur.get(curNum).isInteger())
                    return true;
                while (curNum >= cur.size()) {
                    cur = stack.pop();
                    curNum = numStack.pop();
                    curNum++;
                }
            }
            if (cur)
        }
    }*/

    /*39ms
    Beats 9.38%of users with Java*/
    public class NestedIterator implements Iterator<Integer> {

        List<Integer> list;

        int cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>();
            for (NestedInteger nestedInteger : nestedList) {
                flatten(nestedInteger, list);
            }
            cur = -1;
        }

        @Override
        public Integer next() {
            cur++;
            return cur<list.size()?list.get(cur):null;
        }

        @Override
        public boolean hasNext() {
            return cur+1<list.size();
        }

        private void flatten(NestedInteger nestedList, List<Integer> list) {
            if (nestedList.isInteger())
                list.add(nestedList.getInteger());
            List<NestedInteger> innerList = nestedList.getList();
            for (NestedInteger nestedInteger : innerList) {
                flatten(nestedInteger, list);
            }
        }
    }

}
