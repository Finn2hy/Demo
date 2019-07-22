package com.oren.interrupt;

/**
 * @author huxuef
 * @Title: Demo1
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1914:50
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            System.out.println(Thread.currentThread().getContextClassLoader());
            Thread t1 = new MyThread("t1");
            System.out.println(t1.getName() + " (" + t1.getState() + ") is new");
            t1.start();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is started");
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted");
            Thread.sleep(300);
            System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException");
        }
    }
}
