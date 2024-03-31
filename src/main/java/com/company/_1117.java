package com.company;

public class _1117 {

    /*17
    ms
    Beats
    99.03%
    of users with Java*/
    class H2O {
        int hs;

        public H2O() {
            hs = 0;
        }

        synchronized public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            while (hs==2)
                wait();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hs++;
            if (hs > 2)
                hs = 0;
            this.notifyAll();


        }

        synchronized public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            while (hs < 2)
                wait();
            releaseOxygen.run();
            hs = 0;
            this.notifyAll();
        }
    }
}
