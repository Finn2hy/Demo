package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: Demo4
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:16
 */
public class Demo4 {

    public synchronized void synMethod() {
        for (int i = 0; i < 10000000; i++)
            ;
    }

    public void synBlock() {
        synchronized (this) {
            for (int i = 0; i < 10000000; i++)
                ;
        }
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        long start, diff;
        start = System.currentTimeMillis();
        demo4.synMethod();
        diff = System.currentTimeMillis() - start;
        System.out.println("synchronized method :" + diff);

        start = System.currentTimeMillis();
        demo4.synBlock();
        diff = System.currentTimeMillis() - start;
        System.out.println("synchronized block :" + diff);
    }
}


