package com.company;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _1115 {

    //condition variable
    /*21
    ms
    Beats
    99.29%
    of users with Java*/
    class FooBar {
        private int n;
        Lock lock;
        Condition foo;
        Condition bar;
        boolean fooDone;
        public FooBar (int n) {
            lock = new ReentrantLock();
            foo = lock.newCondition();
            bar = lock.newCondition();
            fooDone = false;
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (fooDone) {
                        foo.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    fooDone = true;
                    bar.signal();
                }
                finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (!fooDone) {
                        bar.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    fooDone = false;
                    foo.signal();
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }

    //semaphore
    /*22
    ms
    Beats
    96.46%
    of users with Java*/
    /*class FooBar {
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
    }*/




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
