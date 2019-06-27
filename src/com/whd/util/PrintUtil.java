package com.whd.util;

import java.util.List;

/**
 * @ClassName: PrintUtil 
 * @Description: 屏幕输出工具类 
 * @author HongDa
 * @date 2019年3月9日 上午10:44:42
 */
public class PrintUtil {
	
	/**
	 * @Description 遍历并打印数组
	 * @author HongDa
	 * @date 2019年3月8日 下午1:44:09
	 * @param array
	 * @return
	 * @throws
	 */
	public static String printArray(int[] array){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for(int i = 0; i < array.length; i++){
			if(i != array.length - 1){
				sb.append(array[i]);
				sb.append("-");
			}else{
				sb.append(array[i]);
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	/**
	 * @Description 打印列表
	 * @author HongDa
	 * @version 1.1.9
	 * @date 2019年3月8日 下午7:47:59
	 * @param list
	 * @return
	 * @throws
	 */
	public static String printList(List<Integer> list){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for(int i = 0; i < list.size(); i++){
			if(i != list.size() - 1){
				sb.append(list.get(i));
				sb.append("-");
			}else{
				sb.append(list.get(i));
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
