package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: LookTest1
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:29
 */

import javax.sound.midi.Soundbank;

/**
 * 实例锁 -- 锁在某一个实例对象上。如果该类是单例，那么该锁也具有全局锁的概念。
 * 实例锁对应的就是synchronized关键字。
 * 全局锁 -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。
 * 全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。
 * 假设，Something有两个实例x和y。分析下面4组表达式获取的锁的情况:
 * (01) x.isSyncA()与x.isSyncB()
 * (02) x.isSyncA()与y.isSyncA()
 * (03) x.cSyncA()与y.cSyncB()
 * (04) x.isSyncA()与Something.cSyncA()
 */
public class LookTest1 {
    Something x = new Something();

    private void test1() {
        Thread t11 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.isSyncA();
            }
        }, "t11");
        Thread t12 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.isSyncB();
            }
        }, "t12");
        t11.start();
        t12.start();
    }

    public static void main(String[] args) {
//        LookTest1 demo = new LookTest1();
//        demo.test1();
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("----------");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("----");
        System.out.println(System.getProperty("java.class.path"));
    }
}

class Something {

    public synchronized void isSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : isSyncA");
            }
        } catch (InterruptedException e) {

        }
    }

    public synchronized void isSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : isSyncB");
            }
        } catch (InterruptedException e) {

        }
    }

    public static synchronized void cSynA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : cSyncA");
            }
        } catch (InterruptedException e) {

        }
    }

    public static synchronized void cSynB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : cSyncB");
            }
        } catch (InterruptedException e) {

        }
    }

}

