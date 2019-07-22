package com.oren.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {
	
	private long start;
	private long end;
	// 临界值
	public static final long THRESHOLD = 10000L;

	public ForkJoinCalculate(Long start, Long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		if (length <= THRESHOLD) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middle = (start + end) / 2;

			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			// 拆分，并将子任务压入线程队列
			left.fork();

			ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
			right.fork();

			return left.join() + right.join();
		}
	}
}
