package com.company;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*341. Flatten Nested List Iterator
        https://leetcode.com/problems/flatten-nested-list-iterator/description/?envType=daily-question&envId=2023-10-20*/
public class _341 {

   public interface NestedInteger {
       boolean isInteger();
       Integer getInteger();
       List<NestedInteger> getList();
   }

   public class NestedIntegerImpl implements NestedInteger {

       Integer intVal;
       List listVal;

       boolean isInteger;

       public NestedIntegerImpl(Integer val) {
           this.intVal = val;
           this.isInteger = true;
       }

       public NestedIntegerImpl(List listVal) {
           this.listVal = listVal;
       }

       @Override
       public boolean isInteger() {
           return isInteger;
       }

       @Override
       public Integer getInteger() {
           return intVal;
       }

       @Override
       public List<NestedInteger> getList() {
           return listVal;
       }
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
    /*public class NestedIterator implements Iterator<Integer> {

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
    }*/

    /*public class NestedIterator implements Iterator<Integer> {

        Stack<List> stack;
        Stack<Integer> posStack;

        int curPos;
        List<NestedInteger> curList;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            posStack = new Stack<>();
            curList = nestedList;
            curPos = 0;
        }

        @Override
        public Integer next() {
            curPos++;
            if (hasNext()) {
                return curList.get(curPos).getInteger();
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if (curPos+1 < curList.size()) {
                if (curList.get(curPos+1).isInteger())
                    return true;
                else {
                    open(curList.get(curPos+1));
                    if (stack.isEmpty() && curPos+1 < curList.size())
                        return false;
                    else
                        return true;
                }
            }
            return false;
        }

        private void open(NestedInteger nestedList) {
            stack.push(curList);
            posStack.push(curPos);
            curList = nestedList.getList();
            curPos = 0;
            if (curList.size() == curPos)
                close();
            if (!curList.get(curPos).isInteger())
                open(curList.get(curPos));
        }

        private void close() {
            curList = stack.pop();
            curPos = posStack.pop();
            curPos++;
            if (curList.size()<=curPos)
                close();
        }
    }*/

    /*3ms
    Beats 65.30%of users with Java*/
    public class NestedIterator implements Iterator<Integer> {

        Deque<List> stack;
        Deque<Integer> posStack;

        int curPos;
        List<NestedInteger> curList;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            posStack = new LinkedList<>();
            curList = nestedList;
            curPos = -1;
        }

        @Override
        public Integer next() {
            return curList.get(curPos).getInteger();
        }

        @Override
        public boolean hasNext() {
            curPos++;
            if (curPos >= curList.size()) {
                if (!stack.isEmpty())
                    return getOut();
                else
                    return false;
            }
            if (curList.get(curPos).isInteger())
                return true;
            else
                return getIn();
        }

        boolean getIn() {
            stack.push(curList);
            posStack.push(curPos);
            curList = curList.get(curPos).getList();
            curPos = -1;
            return hasNext();
        }

        boolean getOut() {
            curList = stack.pop();
            curPos = posStack.pop();
            return hasNext();
        }
    }

    @Test
    public void test() {
//        [[1,1],2,[1,1]]
        List<NestedInteger> rootList = new LinkedList<>();
        List<NestedInteger> il1 = new LinkedList<>();
        il1.add(new NestedIntegerImpl(1));
        il1.add(new NestedIntegerImpl(1));
        NestedInteger nil1 = new NestedIntegerImpl(il1);
        rootList.add(nil1);
        rootList.add(new NestedIntegerImpl(2));
        List<NestedInteger> il2 = new LinkedList<>();
        il2.add(new NestedIntegerImpl(1));
        il2.add(new NestedIntegerImpl(1));
        NestedInteger nil2 = new NestedIntegerImpl(il1);
        rootList.add(nil2);
        NestedIterator iter = new NestedIterator(rootList);
        while (iter.hasNext())
            System.out.println(iter.next());
    }

}
