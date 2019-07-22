package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: Demo3
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:08
 */
public class Demo3 {

    public static void main(String[] args) {
        final DSynMethod dSynMethod = new DSynMethod();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dSynMethod.synBlock1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                dSynMethod.synBlock2();
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                dSynMethod.synMethod();
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }


}

class DSynMethod {

    public void synBlock1() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "synchronized block1 loop " + i);
                }
            }
        } catch (InterruptedException e) {

        }
    }

    public void synBlock2() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "synchronized block2 loop " + i);
                }
            }
        } catch (InterruptedException e) {

        }
    }

    public synchronized void synMethod() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " synchronized method loop " + i);
            }
        } catch (InterruptedException e) {

        }
    }
}


