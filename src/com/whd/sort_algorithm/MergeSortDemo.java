package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: MergeSortDemo 
 * @Description: 归并排序 
 * @author HongDa
 * @date 2019年3月8日 下午3:05:37
 */
public class MergeSortDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		mergeSort(array, 0, array.length - 1);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void mergeSort(int[] array, int low, int high){
		
		if(array == null || array.length == 0)
			return;
		
		int mid = (low + high) / 2;
		
		if(low < high){
			//对序列左半部分分组
			mergeSort(array, low, mid);
			//对序列右半部分分组
			mergeSort(array, mid + 1, high);
			//对序列左右部分归并
			meger(array, low, mid, high);
		}
	}
	
	public static void meger(int[] array, int low, int mid, int high){
		
		if(array == null || array.length == 0)
			return;
		
		int[] temp = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;
		
		while(i <= mid && j <= high){
			if(array[i] < array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		
		while(i <= mid)
			temp[k++] = array[i++];
		
		while(j <= high)
			temp[k++] = array[j++];
		
		for(int x = 0; x < temp.length; x++)
			array[low + x] = temp[x];
	}
}
