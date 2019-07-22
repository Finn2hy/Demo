package com.oren.interrupt;

/**
 * @author huxuef
 * @Title: InterruptTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1914:37
 */

/**
 * interrupt()的作用是中断本线程。
 * 本线程中断自己是被允许的；其它线程调用本线程的interrupt()方法时，会通过checkAccess()检查权限。这有可能抛出SecurityException异常。
 * 如果本线程是处于阻塞状态：调用线程的wait(), wait(long)或wait(long, int)会让它进入等待(阻塞)状态，
 * 或者调用线程的join(), join(long), join(long, int), sleep(long), sleep(long, int)也会让它进入阻塞状态。
 * 若线程在阻塞状态时，调用了它的interrupt()方法，那么它的“中断状态”会被清除并且会收到一个InterruptedException异常。
 * 例如，线程通过wait()进入阻塞状态，此时通过interrupt()中断该线程；调用interrupt()会立即将线程的中断标记设为“true”，
 * 但是由于线程处于阻塞状态，所以该“中断标记”会立即被清除为“false”，同时，会产生一个InterruptedException的异常。
 * 如果线程被阻塞在一个Selector选择器中，那么通过interrupt()中断它时；线程的中断标记会被设置为true，并且它会立即从选择操作中返回。
 * 如果不属于前面所说的情况，那么通过interrupt()中断线程时，它的中断标记会被设置为“true”。
 * 中断一个“已终止的线程”不会产生任何操作。
 */
public class InterruptTest {
}

