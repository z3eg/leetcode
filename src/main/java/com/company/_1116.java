package com.company;

import java.util.function.IntConsumer;

public class _1116 {
    static class ZeroEvenOdd {
        private int n;
        boolean printOdd;
        boolean printZero;
        int counter;

        public ZeroEvenOdd(int n) {
            printOdd = true;
            printZero = true;
            this.n = n;
            this.counter = 1;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
            while (counter < n) {
                while (!printZero)
                    wait();
                printNumber.accept(0);
                printZero = false;
                notifyAll();
            }
        }

        public synchronized void even(IntConsumer printNumber) throws InterruptedException {
            while (counter < n) {
                while (printZero || printOdd)
                    wait();
                printNumber.accept(counter);
                counter++;
                printZero = true;
                printOdd = true;
                notifyAll();
            }
        }

        public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
            while (counter < n) {
                while (printZero)
                    wait();
                printNumber.accept(counter);
                counter++;
                printZero = true;
                printOdd = false;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread t0 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t0.start();
        t1.start();
        t2.start();

        try {
            t0.join();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
