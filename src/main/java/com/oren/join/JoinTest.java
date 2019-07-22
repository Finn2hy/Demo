package com.oren.join;

/**
 * @author huxuef
 * @Title: JoinTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1909:50
 */

/**
 * join() 定义在Thread.java中。
 * join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。
 * 这句话可能有点晦涩，我们还是通过例子去理解：
 */
public class JoinTest {

    public static void main(String[] args) {
        try {
            ThreadA t1 = new ThreadA("t1");
            t1.start();
            t1.join();
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("%s start\n", this.getName());
        for (int i = 0; i < 100000; i++) {
            ;
        }
        System.out.printf("%s finish\n", this.getName());
    }
}
