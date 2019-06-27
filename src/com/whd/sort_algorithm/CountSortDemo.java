package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: CountSortDemo 
 * @Description: 计数排序 
 * @author HongDa
 * @date 2019年3月8日 下午3:43:31
 */
public class CountSortDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		array = countSort(array);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static int[] countSort(int[] array){
		
		if(array == null || array.length == 0)
			return null;
		
		int length = array.length;
		int[] b = new int[length];
		int min = array[0],max = array[0];
		for(int a : array){
			if(a < min)
				min = a;
			if(a > max)
				max = a;
		}
		int[] c = new int[max - min + 1];
		
		for(int i = 0; i < length; i++)
			c[array[i] - min]++;
		
		for(int i = 1; i < c.length; i++)
			c[i] = c[i] + c[i - 1];
		
		for(int i = 0; i < length; i++)
			b[--c[array[i] - min]] = array[i];
		
		return b;
	}
}
