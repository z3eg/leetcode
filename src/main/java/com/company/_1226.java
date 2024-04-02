package com.company;

public class _1226 {

    /*13
    ms
    Beats
    74.20%
    of users with Java*/
    class DiningPhilosophers {

        boolean[] isEating; //volatile?

        public DiningPhilosophers() {
            isEating = new boolean[5];
        }

        // call the run() method of any runnable to execute its code
        public synchronized void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = philosopher-1;
            if (left == -1)
                left = 4;
            int right = philosopher+1;
            if (right == 5)
                right = 0;
            while (isEating[left] || isEating[right])
                wait();
            isEating[philosopher] = true;
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            isEating[philosopher] = false;
            notifyAll();
        }

    }

}
