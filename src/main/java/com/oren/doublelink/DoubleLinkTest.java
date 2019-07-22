package com.oren.doublelink;

public class DoubleLinkTest {

	private static void int_test() {
		int [] iarr = {10,20,30,40};
		System.out.println("\n-----int_test-----------");
		//创建双向链表
		DoubleLink<Integer> dLink = new DoubleLink<Integer>();
		dLink.insert(0,20);
		dLink.appendLast(10);
		dLink.appendLast(30);
		dLink.insertFirst(3);



		System.out.printf("isEmpty()=%b\n", dLink.isEmpty());


		System.out.printf("size()=%d\n", dLink.size());
		for (int i = 0; i < dLink.size(); i++) {
			System.out.println("dLink("+i+")="+ dLink.get(i));
		}
		dLink.del(2);
		System.out.println("\n-----del-----------");
		for (int i = 0; i < dLink.size(); i++) {
			System.out.println("dLink("+i+")="+ dLink.get(i));
		}

	}

	public static void main(String[] args) {
		int_test();
	}
}

