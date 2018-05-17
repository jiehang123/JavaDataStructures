package com.jiehang.tree.avl.impl;

public class AVLNodeTest {
	public static void main(String[] args) {
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		int[] arryaInt = new int[]{42,35,19,14,10,27,31};
		for(int i=0; i<arryaInt.length; i++) {
			avlTree.insert(arryaInt[i]);
		}
		
		display(avlTree.root);
	}
	
	public static void display(AVLNode<Integer> avlNode) {
		if (avlNode != null) {
			display(avlNode.left);
			display(avlNode.right);
			System.out.println(avlNode.data + ":" + avlNode.height);
//			System.out.println("left :" + ((avlNode.left != null) ? avlNode.left.data : "null"));
//			System.out.println("right :" + ((avlNode.right != null) ? avlNode.right.data : "null"));
		}
	}
	
}
