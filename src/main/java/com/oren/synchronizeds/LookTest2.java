package com.oren.synchronizeds;

/**
 * @author huxuef
 * @Title: LookTest2
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1416:46
 */

/**
 * (02) x.isSyncA()与y.isSyncA()
 */
public class LookTest2 {

    Something x = new Something();
    Something y = new Something();

    private void test2() {
        Thread t11 = new Thread(new Runnable() {
            @Override
            public void run() {
                x.isSyncA();
            }
        }, "t21");
        Thread t12 = new Thread(new Runnable() {
            @Override
            public void run() {
                y.isSyncB();
            }
        }, "t22");
        t11.start();
        t12.start();
    }

    public static void main(String[] args) {
        LookTest2 demo = new LookTest2();
        demo.test2();
    }
}
