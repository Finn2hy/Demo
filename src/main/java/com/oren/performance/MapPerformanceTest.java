package com.oren.performance;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapPerformanceTest {


	@Test
	public void mapForEachTest() {
		Map<Integer, Object> map = new HashMap<>();
		for (int i = 0; i <= 1000000; i++) {
			map.put(i, i);
		}
		long start = System.currentTimeMillis();
		map.forEach((key, vlaue) ->{
			
		});
		long end = System.currentTimeMillis();

		System.out.println("forEach耗时："+(end - start));
	}
	
	@Test
	public void mapFor() {
		Map<Integer, Object> map = new HashMap<>();
		for (int i = 0; i <= 1000000; i++) {
			map.put(i, i);
		}
		long start = System.currentTimeMillis();
		for (Integer i : map.keySet()) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("forEach耗时："+(end - start));
	}
}
