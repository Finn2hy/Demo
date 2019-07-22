package com.oren.util.current.atomic;

/**
 * @author huxuef
 * @Title: AtomicReferenceFieldUpdaterTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/2010:05
 */

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 对象属性修改类型:AtomicReferenceFieldUpdater/AtomicLongFiedlUpdater/AtomicIntegerFieldUpdater
 */
public class AtomicReferenceFieldUpdaterTest {

    public static void main(String[] args) {

        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Person.class, String.class, "name");
        Person person = new Person();
        updater.compareAndSet(person, person.name, "jie");
        System.out.println(person.name);
    }
}

class Person {
    volatile String name;
}
