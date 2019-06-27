package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: BubbleSortDemo 
 * @Description: 冒泡排序 
 * 算法步骤:
 * 时间复杂度:
 * 		最好:O(n) 最坏:O(n²) 平均:O(n²)
 * 算法稳定性:稳定
 * @author HongDa
 * @date 2019年3月8日 下午1:44:50
 */
public class BubbleSortDemo {
	
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		bubbleSort(array);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void bubbleSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int length = array.length;
		
		for(int i = 0; i < length - 1; i++){
			for(int j = 0; j < length - 1 - i; j++){
				if(array[j] > array[j + 1]){
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
