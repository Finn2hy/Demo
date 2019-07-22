package com.oren.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		System.out.printf("-----list.size()=%d\n",list.size());
		System.out.printf("-----Integer.MAX_VALUE=%d\n",Integer.MAX_VALUE);
		System.out.printf("-----Integer.MIN_VALUE=%d\n",Integer.MIN_VALUE);
	}

}
