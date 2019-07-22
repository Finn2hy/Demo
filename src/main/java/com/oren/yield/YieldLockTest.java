package com.oren.yield;

/**
 * @author huxuef
 * @Title: YieldLockTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1509:48
 */
public class YieldLockTest {

    private static Object obj = new Object();

    public static void main(String[] args) {
        com.oren.yield.ThreadA t1 = new com.oren.yield.ThreadA("t1");
        com.oren.yield.ThreadA t2 = new com.oren.yield.ThreadA("t2");
        t1.start();
        t2.start();
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    if (i % 4 == 0) {
                        Thread.yield();
                    }
                }
            }
        }
    }

}
