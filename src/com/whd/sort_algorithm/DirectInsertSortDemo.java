package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: DirectInsertSort 
 * @Description: 直接插入排序
 * 算法步骤:
 * 1,将待排序序列中第一个元素看做一个有序序列,把第二个元素到最后一个元素当做未排序序列
 * 2,从头到尾依次扫描未排序序列,将扫描到的每个元素插入到有序序列的适当位置,若与已插入元素相等,则插入到相等元素后面
 * 时间复杂度:
 * 		最好:O(n) 最坏:O(n²) 平均:O(n²)
 * 算法稳定性:稳定排序
 * @author HongDa
 * @date 2019年3月8日 下午3:16:49
 */
public class DirectInsertSortDemo {
	public static void main(String[] args){
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		directInsertSort(array);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void directInsertSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int length = array.length;
		
		for(int i = 1; i < length; i++){
			int key = array[i];
			int j = i - 1;
			for(; j >= 0 && array[j] > key; j--)
				array[j + 1] = array[j];
			array[j + 1] = key;
		}
	}
}
