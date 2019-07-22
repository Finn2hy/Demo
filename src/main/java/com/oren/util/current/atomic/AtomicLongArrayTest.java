package com.oren.util.current.atomic;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author huxuef
 * @Title: AtomicLongArrayTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/2009:52
 */

/**
 * 数组类型：AtomicLongArray/AtomicIntegerArray/AtomicReferenceArray
 */
public class AtomicLongArrayTest {

    public static void main(String[] args) {
        AtomicLongArray atomicLongArray = new AtomicLongArray(2);
        System.out.printf("%20s :%d\n", "length()", atomicLongArray.length());
        System.out.printf("%20s :%d\n", "get()", atomicLongArray.get(0));
        atomicLongArray.set(0, 10);
        atomicLongArray.set(1, 30);
        System.out.printf("%20s :%d\n", "get()", atomicLongArray.get(0));
    }
}
