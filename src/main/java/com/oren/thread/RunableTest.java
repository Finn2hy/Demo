package com.oren.thread;/**
 * @Title: RunableTest
 * @ProjectName Demo
 * @Description: TODO
 * @author huxuef
 * @date 2019/3/1220:30
 */

/**
 * @program: Demo
 * @Description: runable test
 * @Author: Dylan.Hu
 * @Date: 2019-03-12 20:30:55
 */
public class RunableTest {
    public static void main(String[] args) {
        MyRunable mr = new MyRunable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyRunable implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " sale ticket: " + this.ticket--);
            }
        }
    }
}

