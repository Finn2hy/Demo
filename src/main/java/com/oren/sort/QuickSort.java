package com.oren.sort;

/**
 * 快速排序
 * (1) 从数列中挑出一个基准值。
 * (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
 * (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 */
public class QuickSort {

	/**
	 * 递归快速排序
	 * @param a 待排序的数组
	 * @param l 数组的左边界(例如，从起始位置开始排序，则l=0)
	 * @param r 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
	 */
	public static void quickSort(int[] a, int l, int r) {
		if (l < r) {
			int j,i,x;
			i = l;
			j = r;
			x = a[i];//基准值
			while (i < j) {
				while (i < j && a[j] > x) {
					//从右向左找第一个小于x的数
					j--;
				}
				if (i < j) {
					a[i++] = a[j];
				}
				while (i < j && a[i] < x) {
					//从左向右找第一个大于x的数
					i++;
				}
				if (i < j) {
					a[j--] = a[i];
				}
			}
			a[i] = x;
			//递归调用
			quickSort(a, l, i - 1);
			//递归调用
			quickSort(a, i + 1, r);
		}
	}


	public static void main(String[] args) {
		int[] a = {10, 34, 6, 2, 12, 50};
		System.out.printf("brefor sort: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");

		quickSort(a, 0, a.length - 1);
		System.out.printf("after sort: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\n");
	}
}
