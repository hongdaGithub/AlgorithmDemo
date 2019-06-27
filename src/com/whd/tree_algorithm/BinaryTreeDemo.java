package com.whd.tree_algorithm;

import java.util.ArrayList;
import java.util.List;

import com.whd.util.PrintUtil;

/**
 * @ClassName: BinaryTreeDemo 
 * @Description: 二叉查找树/二叉排序树
 * @author HongDa
 * @date 2019年3月8日 下午5:14:34
 */
public class BinaryTreeDemo {
	public static void main(String[] args){
		
		int[] array = {72, 33, 56, 22, 81, 22, 65, 15, 100, 99};
		
		BinaryTree bTree = new BinaryTree();
		
		for(int a : array)
			bTree.add(a);
		
		List<Integer> NLRList = bTree.NLR(new ArrayList<Integer>(), bTree.getRoot());
		List<Integer> LNRList = bTree.LNR(new ArrayList<Integer>(), bTree.getRoot());
		List<Integer> LRNList = bTree.LRN(new ArrayList<Integer>(), bTree.getRoot());
		
		System.out.println("前序遍历:" + PrintUtil.printList(NLRList));
		System.out.println("中序遍历:" + PrintUtil.printList(LNRList));
		System.out.println("后序遍历:" + PrintUtil.printList(LRNList));
		
		bTree.printPath(new ArrayList<Integer>(), bTree.getRoot());
	}
}

/**
 * @ClassName: BinaryTree 
 * @Description: 定义二叉树 
 * @author HongDa
 * @date 2019年3月8日 下午5:21:42
 */
class BinaryTree{
	
	private Node root;
	
	public BinaryTree() {}
	
	public Node getRoot() {
		return root;
	}

	public void add(int value){
		
		if(root == null){
			root = new Node(value, null, null);
			return;
		}
		
		addNode(root, value);
	}
	
	private void addNode(Node node,int value){

		if(node == null)
			return;
		
		if(node.left == null && node.right == null){
			if(value < node.value){
				Node newNode = new Node(value);
				node.left = newNode;
			}else if(value > node.value){
				Node newNode = new Node(value);
				node.right = newNode;
			}
			return;
		}
		
		if(value < node.value && node.left== null){
			Node newNode = new Node(value);
			node.left = newNode;
			return;
		}
		
		if(value > node.value && node.right == null){
			Node newNode = new Node(value);
			node.right = newNode;
			return;
		}
		
		if(value < node.value)
			addNode(node.left, value);
		else if(value > node.value)
			addNode(node.right, value);
		
	}
	
	/**
	 * @Description 前序遍历
	 * @author HongDa
	 * @date 2019年3月8日 下午7:45:19
	 * @param list
	 * @param node
	 * @return
	 * @throws
	 */
	public List<Integer> NLR(List<Integer> list,Node node){
		if(node == null)
			return list;
		
		list.add(node.value);
		
		if(node.left != null)
			NLR(list,node.left);
		
		if(node.right != null)
			NLR(list,node.right);
		
		return list;
	}
	
	/**
	 * @Description 中序遍历
	 * @author HongDa
	 * @date 2019年3月8日 下午7:48:51
	 * @param list
	 * @param node
	 * @return
	 * @throws
	 */
	public List<Integer> LNR(List<Integer> list,Node node){
		
		if(node == null)
			return list;
		
		if(node.left != null)
			LNR(list,node.left);
		
		list.add(node.value);
		
		if(node.right != null)
			LNR(list,node.right);
		
		return list;
	}
	
	/**
	 * @Description 后序遍历
	 * @author HongDa
	 * @date 2019年3月8日 下午7:48:51
	 * @param list
	 * @param node
	 * @return
	 * @throws
	 */
	public List<Integer> LRN(List<Integer> list,Node node){
		
		if(node == null)
			return list;
		
		if(node.left != null)
			LRN(list,node.left);
		
		if(node.right != null)
			LRN(list,node.right);
		
		list.add(node.value);
		
		return list;
	}
	
	/**
	 * @Description 打印根节点到叶节点的所有路径
	 * @author HongDa
	 * @version 1.1.9
	 * @date 2019年3月8日 下午9:30:34
	 * @param list
	 * @param node
	 * @throws
	 */
	public void printPath(List<Integer> list,Node node){
		
		if(node == null)
			return;
		
		list.add(node.value);
		
		if(node.left == null && node.right == null){
			System.out.print("[");
			for(int i = 0; i < list.size(); i++){
				if(i == list.size() - 1){
					System.out.println(list.get(i) + "]");
				}else{
					System.out.print(list.get(i) + "-");
				}
			}
		}
		
		if(node.left != null)
			printPath(list, node.left);
		
		if(node.right != null)
			printPath(list, node.right);
		
		list.remove(list.size() - 1);
	}
	
	/**
	 * @ClassName: Node 
	 * @Description: 定义二叉树节点
	 * @author HongDa
	 * @date 2019年3月8日 下午5:15:15
	 */
	static class Node{
		
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value){
			this.value = value;
		}
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
	}
}
