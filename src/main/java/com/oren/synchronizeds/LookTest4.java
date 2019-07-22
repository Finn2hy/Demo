package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: LookTest4
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:56
 */

/**
 * (4) x.isSyncA()与Something.cSyncA()
 */
public class LookTest4 {

    Something x = new Something();

    private void test4() {
        Thread t41 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.isSyncA();
            }
        }, "t41");

        Thread t42 = new Thread(new Runnable() {
            @Override
            public void run() {
                Something.cSynA();
            }
        }, "t42");

        t41.start();
        t42.start();
    }

    public static void main(String[] args) {
        LookTest4 demo = new LookTest4();
        demo.test4();
    }

}
