package com.jiehang.tree.avl.impl;

/**
 * 
 * @author a620824
 *
 * @param <T>
 */
public class AVLNode<T extends Comparable<T>> {
	public T data;
	public AVLNode<T> left;
	public AVLNode<T> right;
	public int height;
	
	public AVLNode(T data) {
		this(data, null, null);
	}

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
		this(data, null, null, 0);
	}

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int height) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = height;
	}
}
