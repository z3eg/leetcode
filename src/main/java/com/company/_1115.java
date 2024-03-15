package com.company;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _1115 {

    //semaphore
    /*22
    ms
    Beats
    96.46%
    of users with Java*/
    class FooBar {
        private int n;
        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);
        public FooBar (int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.release();
            }
        }
    }




//    object lock

    /*22
ms
Beats
96.34%
of users with Java*/
    /*final Object lock;
    boolean foo = true;

    public _1115 (int n) {
        this.n = n;
        lock = new Object();
    }


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!foo) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                foo = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (foo) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo = true;
                lock.notifyAll();
            }
        }
    }*/

    /*22
    ms
    Beats
    96.34%
    of users with Java*/

    /*boolean foo = true;

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!foo) {
                wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            foo = false;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (foo) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo = true;
            notifyAll();
        }
    }*/
}
