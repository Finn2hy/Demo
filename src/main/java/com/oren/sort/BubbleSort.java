package com.oren.sort;

/**
 * 冒泡排序(Bubble Sort)，又被称为气泡排序或泡沫排序。
 *
 * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
 * 如果前者比后者大，则交换它们的位置。这样，一次遍历之后，最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，
 * 第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
 */
public class BubbleSort {


	public static void bubbleSort_1(int[] a, int n) {
		int i,j;
		for (i = n - 1; i > 0; i--) {
			for (j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

	public static void bubbleSort_2(int[] a, int n) {
		int i,j;
		int flg;
		for (i = n - 1; i > 0; i--) {
			flg = 0;
			for (j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flg = 1;
				}
			}
			if (flg == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {10, 34, 6, 2, 12, 50};
		System.out.printf("brefor sort: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
		
		//bubbleSort_1(a, a.length);
		bubbleSort_2(a, a.length);
		System.out.printf("after sort: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}
}
