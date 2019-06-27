package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: QuickSortDemo 
 * @Description: 快速排序
 * 算法步骤:
 * 时间复杂度:
 * 算法稳定性:不稳定
 * @author HongDa
 * @date 2019年3月8日 下午2:48:16
 */
public class QuickSortDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void quickSort(int[] array, int start, int end){
		
		if(array == null || array.length == 0)
			return;
		
		int i = start,j = end,key = array[i];
		
		while(i < j){
			//从后向前搜索比key小的元素
			while(i < j && array[j] >= key)
				j--;
			if(i < j){
				array[i] = array[j];
				i++;
			}
			//从前向后搜索比key大的元素
			while(i < j && array[i] <= key)
				i++;
			if(i < j){
				array[j] = array[i];
				j++;
			}
		}
		
		array[i] = key;
		
		//对比key小的序列进行快速排序
		if(i > start)
			quickSort(array, start, i - 1);
		//对比key大的序列进行快速排序
		if(j + 1 < end)
			quickSort(array, j + 1, end);
	}
}
