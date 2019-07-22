package com.oren.forkjoin;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

	@Test
	public void beforTest() {
		long start = System.currentTimeMillis();

		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);

		long sum = pool.invoke(task);
		System.out.println(">>>>sum= "+sum);
		
		long end = System.currentTimeMillis();

		System.out.println("耗费的时间为: " + (end - start));
	}
	
	@Test
	public void ordinaryTest() {
		long start = System.currentTimeMillis();

		long sum = 0L;
		for (long i = 0L; i <= 10000000000L; i++) {
			sum += i;
		}
		System.out.println(">>>>sum= "+sum);

		long end = System.currentTimeMillis();
		System.out.println("耗费的时间为: " + (end - start));
	}
	
	@Test
	public void afterTest() {
		long start = System.currentTimeMillis();

		Long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().sum();
		System.out.println(">>>>sum= "+sum);

		long end = System.currentTimeMillis();
		System.out.println("耗费的时间为: " + (end - start));
	}

}
