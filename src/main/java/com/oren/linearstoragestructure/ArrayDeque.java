package com.oren.linearstoragestructure;

import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;

/**
 * 数组实现队列
 * 队列：
 * 1、FIFO(先进先出)
 * 2、队头删除，队尾插入
 *
 */
public class ArrayDeque {

	private int[] iArray;
	private int size;

	public ArrayDeque(int sz) {
		this.iArray = new int[sz];
		this.size = 0;
	}

	/**
	 * 将val插入在队列尾插入
	 * @param val
	 */
	public void rear(int val) {
		iArray[size++] = val;
	}

	/**
	 * 返回队列头元素
	 */
	public int front() {
		return iArray[0];
	}

	/**
	 * 从队列头弹出元素并发会弹出元素值
	 * @return
	 */
	public int pop() {
		int ret = iArray[0];
		size--;
		for (int i = 1; i <= size; i++) {
			iArray[i-1] = iArray[i];
		}
		return ret;
	}

	/**
	 * 返回队列大小
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	public static void main(String[] args) {
		int temp = 0;
		ArrayDeque queue = new ArrayDeque(12);
		//插入10 20 30
		queue.rear(10);
		queue.rear(20);
		queue.rear(30);
		System.out.println("\n-------queue.rear()-------");
		int pop = queue.pop();
		System.out.printf("pop()==%d\n",pop);
		int front = queue.front();
		System.out.printf("front()=%d\n",front);
		queue.rear(40);
		System.out.printf("size()=%d\n",queue.size());
		while (!queue.isEmpty()) {
			System.out.printf("size()=%d\n", queue.pop());
		}

	}



}
