package com.oren.util.current.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author huxuef
 * @Title: AtomicReferenceTest
 * @ProjectName Demo
 * @Description: TODO
 * @date 2019/3/2010:00
 */

/**
 * 引用类型：AtomicRefernce/AtomicStampedRerence/AtomicMarkableReference
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "val");
        AtomicReference<Map<String, Object>> atomicReference = new AtomicReference<>(map);
        System.out.printf("%20s :%s\n", "get", atomicReference.get().get("key"));
    }
}
