package com.oren.wait;

/**
 * @author huxuef
 * @Title: WaitTimeoutTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1419:05
 */
public class WaitTimeoutTest {
    public static void main(String[] args) {
        ThreadB t1 = new ThreadB("t1");
        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                System.out.println(Thread.currentThread().getName() + " call wait()");
                t1.wait(3000);
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {

            }
        }
    }
}

class ThreadB extends Thread {

    public ThreadB(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
        while (true) {
            ;
        }
    }
}
