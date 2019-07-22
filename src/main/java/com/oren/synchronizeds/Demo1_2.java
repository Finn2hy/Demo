package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: Demo1_2
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1415:55
 */
public class Demo1_2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (this) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            }
        } catch (InterruptedException e) {

        }
    }
}
