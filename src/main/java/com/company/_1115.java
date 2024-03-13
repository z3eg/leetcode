package com.company;

public class _1115 {
    private int n;

    /*22
ms
Beats
96.34%
of users with Java*/
    final Object lock;
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
    }

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
