package com.oren.synchronizeds;

import javax.naming.InsufficientResourcesException;

/**
 * @author huxuef
 * @Title: Demo2
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:01
 */
public class Demo2 {
    public static void main(String[] args) {
        final Count count = new Count();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.synMethod();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.nonSynMethod();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}

class Count {

    public void synMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public void nonSynMethod() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
            }
        } catch (InterruptedException e) {

        }
    }
}

