package com.oren.util.current.atomic;

/**
 * @author huxuef
 * @Title: AtomicLongTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/1919:49
 */

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * 基本类型：AtomicLong/AtomicInteger/AtomicBoolean
 */
public class AtomicLongTest {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.set(10);
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%d\n", "incrementAndGet()", atomicLong.incrementAndGet());
        System.out.printf("%20s :%d\n", "getAndDecrement()", atomicLong.getAndIncrement());
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%d\n", "decrementAndGet()", atomicLong.decrementAndGet());
        System.out.printf("%20s :%d\n", "getAndDecrement()", atomicLong.getAndDecrement());
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%d\n", "addAndGet()", atomicLong.addAndGet(1));
        System.out.printf("%20s :%d\n", "getAndSet()", atomicLong.getAndSet(1));
        System.out.printf("%20s :%d\n", "getAndAdd()", atomicLong.getAndAdd(1));
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        atomicLong.lazySet(10);
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%d\n", "accumulateAndGet", atomicLong.accumulateAndGet(5, new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                System.out.printf("%20s :%d\n", "left", left);
                System.out.printf("%20s :%d\n", "right", right);
                return left * right;
            }
        }));
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%d\n", "getAndAccumulate", atomicLong.getAndAccumulate(2, new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                System.out.printf("%20s :%d\n", "left", left);
                System.out.printf("%20s :%d\n", "right", right);
                return left * right;
            }
        }));
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%d\n", "updateAndGet()", atomicLong.updateAndGet(new LongUnaryOperator() {
            @Override
            public long applyAsLong(long operand) {
                return ++operand;
            }
        }));
        System.out.printf("%20s :%d\n", "updateAndGet()", atomicLong.getAndUpdate(new LongUnaryOperator() {
            @Override
            public long applyAsLong(long operand) {
                return ++operand;
            }
        }));
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%b\n", "weakCompareAndSet()",
                atomicLong.weakCompareAndSet(12, 2));
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        System.out.printf("%20s :%b\n", "compareAndSet()",
                atomicLong.compareAndSet(12, 12));
        System.out.printf("%20s :%d\n", "get()", atomicLong.get());
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.get();
        System.out.printf("%20s :%b\n", "get()", atomicBoolean.get());
        atomicBoolean.compareAndSet(true, true);
        System.out.printf("%20s :%b\n", "get()", atomicBoolean.get());


    }
}
