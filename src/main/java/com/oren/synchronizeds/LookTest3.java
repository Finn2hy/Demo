package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: LookTest3
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:49
 */

/**
 * (03) x.cSyncA()与y.cSyncB()
 */
public class LookTest3 {

    Something x = new Something();
    Something y = new Something();

    private void test3() {
        Thread t31 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.cSynA();
            }
        }, "t31");

        Thread t32 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.cSynA();
            }
        }, "t32");
        t31.start();
        t32.start();
    }

    public static void main(String[] args) {
        LookTest3 demo = new LookTest3();
        demo.test3();
    }

}
