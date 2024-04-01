package com.company;

import org.junit.Test;

import java.util.function.IntConsumer;

public class _1195 {

    /*6
    ms
    Beats
    96.51%
    of users with Java*/

    class FizzBuzz {
        private int n;
        private volatile int counter;

        public FizzBuzz(int n) {
            this.n = n+1;
            this.counter = 1;
        }

        // printFizz.run() outputs "fizz".
        synchronized public void fizz(Runnable printFizz) throws InterruptedException {
            while (counter<n) {
                if (counter %3==0 && counter %5!=0) {
                    printFizz.run();
                    counter++;
                    notifyAll();
                }
                else {
                    wait();
                }
            }

        }

        // printBuzz.run() outputs "buzz".
        synchronized public void buzz(Runnable printBuzz) throws InterruptedException {
            while (counter<n) {
                if (counter % 3 != 0 && counter % 5 == 0) {
                    printBuzz.run();
                    counter++;
                    this.notifyAll();
                } else {
                    wait();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        synchronized public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (counter<n) {
                if (counter % 3 == 0 && counter % 5 == 0) {
                    printFizzBuzz.run();
                    counter++;
                    this.notifyAll();
                } else {
                    wait();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        synchronized public void number(IntConsumer printNumber) throws InterruptedException {
            while (counter<n) {
                if (counter % 3 != 0 && counter % 5 != 0) {
                    printNumber.accept(counter);
                    counter++;
                    this.notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        FizzBuzz data = new FizzBuzz(15);
        Thread thread1 = new Thread(() -> {
            try {
                data.fizz(() -> System.out.print("fizz"));
            } catch (Exception e) {
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                data.buzz(() -> System.out.print("buzz"));
            } catch (Exception e) {
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                data.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (Exception e) {
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                data.number(i -> System.out.print(i));
            } catch (Exception e) {
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
