package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: ShellSortDemo 
 * @Description: 希尔排序 
 * 算法步骤:
 * 1,选择一个增量序列t1,t2,...,tk,其中ti > tj,tk = 1
 * 2,按增量序列个数k,对序列进行k趟排序
 * 3,每趟排序,根据对应的增量ti,将带排序序列分割成若干长度为m的子序列,分别对个子序列进行直接插入排序.
 * @author HongDa
 * @date 2019年3月8日 下午3:35:40
 */
public class ShellSortDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		shellSort(array);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void shellSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int length = array.length;
		int step = length;
		
		while(step != 1){
			
			step = step / 2;
			
			for(int k = 0; k < step; k++){
				for(int i = k + step; i < length; i = i + step){
					int key = array[i];
					int j = i - step;
					for(; j >= 0 && array[j] > key; j = j - step)
						array[j + step] = array[j];
					array[j + step] = key;
				}
			}
		}
	}
}
