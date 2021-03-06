package com.oren.aqs;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.start();
        }

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200L);
                        System.out.println();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {

        }
    }
}
