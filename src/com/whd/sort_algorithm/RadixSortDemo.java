package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: RadixSortDemo 
 * @Description: 基数排序 
 * @author HongDa
 * @date 2019年3月8日 下午3:51:45
 */
public class RadixSortDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		radixSort(array, 3);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void radixSort(int[] array, int max){
		
		if(array == null || array.length == 0)
			return;
		
		int length = array.length;
		int[][] temp = new int[10][length];
		int[] order = new int[10];
		int m = 1,n = 1,k = 0;
		
		while(m <= max){
			
			for(int i = 0; i < length; i++){
				int index = (array[i] / n) % 10;
				temp[index][order[index]] = array[i];
				order[index]++;
			}
			
			for(int i = 0; i < 10; i++){
				while(order[i] != 0){
					for(int j = 0; j < order[i]; j++){
						array[k] = temp[i][j];
						k++;
					}
					order[i] = 0;
				}
			}
			
			m += 1;
			n *= 10;
			k = 0;
		}
	}
}
