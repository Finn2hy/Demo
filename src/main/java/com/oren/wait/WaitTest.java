package com.oren.wait;


/**
 * @author huxuef
 * @Title: WaitTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1418:50
 */
public class WaitTest {

    public static void main(String[] args) {
        Thread t1 = new ThreadA("t1");
        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1.");
                t1.start();
                System.out.println(Thread.currentThread().getName() + " call wait().");
                t1.wait();
                System.out.println(Thread.currentThread().getName() + " continue.");
            } catch (InterruptedException e) {

            }
        }
    }

}

class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify().");
            notify();
        }
    }
}
