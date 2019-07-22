package com.oren.thread;/**
 * @Title: ThreadTest
 * @ProjectName Demo
 * @Description: TODO
 * @author huxuef
 * @date 2019/3/1217:33
 */

/**
 * @program: Demo
 * @Description: thread test
 * @Author: Dylan.Hu
 * @Date: 2019-03-12 17:33:20
 */
public class ThreadTest {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }

}


class MyThread extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(this.getName() + " sale ticket " + this.ticket--);
            }
        }

    }
}
