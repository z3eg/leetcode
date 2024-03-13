package com.company;

public class _1115 {
    private int n;
    public _1115 (int n) {
        this.n = n;
    }

    /*22
    ms
    Beats
    96.34%
    of users with Java*/

    boolean foo = true;

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
    }
}
