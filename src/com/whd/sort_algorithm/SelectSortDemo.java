package com.whd.sort_algorithm;

import com.whd.util.PrintUtil;

/**
 * @ClassName: SelectSortDemo 
 * @Description: 选择排序 
 * 算法步骤:
 * 1,从待排序的序列中找出最小(大)的元素放到队列起始位置
 * 2,再从剩下未排序的序列中继续找到最小(大)的元素放到已排序队列的末尾
 * 3,重复第二步,直到所以元素均排序完毕
 * 时间复杂度:
 * 		最好:O(n²) 最坏:O(n²) 平均:O(n²)
 * 算法稳定性:不稳定
 * @author HongDa
 * @date 2019年3月8日 下午2:04:27
 */
public class SelectSortDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		System.out.println("排序前:" + PrintUtil.printArray(array));
		selectSort(array);
		System.out.println("排序后:" + PrintUtil.printArray(array));
	}
	
	public static void selectSort(int[] array){
		
		if(array == null || array.length == 0)
			return;
		
		int length = array.length;
		
		for(int i = 0; i < length - 1; i++){
			int min = i;
			for(int j = i; j < length - 1; j++){
				if(array[j + 1] < array[min])
					min = j + 1;
			}
			
			if(min != i){
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}
}
