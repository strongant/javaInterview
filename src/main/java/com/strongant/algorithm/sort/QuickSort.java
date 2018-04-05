package com.strongant.algorithm.sort;

/**
 * 快速排序实现
 * 算法思想： 根据一定长度的数组首先选举一个中心点（一般选择数组的最右边的一个值作为 pivot），
 * 然后有两个指针，从左边一个元素开始的指针从左往右指，直到遇到一个比中心点值大的值则停止，右边从
 * 除过中心点的元素开始从右往左指，直到找到一个比它小的值，在没有交叉的情况下，将指到的值进行交换
 * 依次继续，直到交叉，交叉后，将中心点的值和左边指向的值进行交换，此时形成了以 pivot 值为中心的两个数组
 * 左边的数组里面的元素逗比 pivot 小，右边的数组中的元素都比 pivot 大，依次递推，直到被分割的数组存在一个元素
 * 时不需要进行指向，最后便会将元素以从小到大的方式进行排序。
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class QuickSort {
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		// 防御式编程,检查传入的数组是否是一个空元素
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = numbers.length;
		quickSort(0, number - 1);
	}

	private void quickSort(int low, int high) {
		int i = low, j = high;
		// 从数组的中间得到 pivot 元素
		int pivot = numbers[low + (high - low) / 2];

		// 拆分为两个数组
		while (i <= j) {

			// 如果左边数组元素的当前值小于 pivot , 继续往前指
			while (numbers[i] < pivot) {
				i++;
			}

			// 如果右边数组的当前值大于 pivot ， 继续往后指
			while (numbers[j] > pivot) {
				j--;
			}

			// 如果我们发现左边的元素大于 pivot 并且右边的元素小于 pivot 时，便把左边指向的元素和右边
			// 指向的元素进行交换,对 i+1 对 j - 1
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		// 递归
		if (low < i) {
			quickSort(low, j);
		}

		if (i < high) {
			quickSort(i, high);
		}
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
