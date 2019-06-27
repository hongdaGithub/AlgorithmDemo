package com.whd.search_algorithm;

/**
 * @ClassName: BinarySearchDemo 
 * @Description: 二分查找(折半查找) 
 * @author HongDa
 * @date 2019年3月8日 下午4:30:49
 */
public class BinarySearchDemo {
	public static void main(String[] args){
		
		int[] array = {15, 22, 22, 33, 56, 65, 72, 81, 99, 100};
		
		int start = 0, end = array.length - 1, key = 21;
		
		int result = binarySearch(array, start, end, key);
		
		System.out.println("The key index is:" + result);
	}
	
	public static int binarySearch(int[] array, int start, int end, int key){
		
		if(array == null || array.length == 0)
			return -1;
		
		if(start > end || key < array[start] || key > array[end])
			return -1;
		
		int mid = (start + end) / 2;
		
		if(key == array[mid])
			return mid;
		else if(key < array[mid])
			return binarySearch(array, start, mid - 1, key);
		else
			return binarySearch(array, mid + 1, end, key);
		
	}
}
