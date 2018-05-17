package com.jiehang.tree.avl.impl;

public class AVLTree<T extends Comparable<T>> {

	public AVLNode<T> root;

	public void insert(T data) {
		if (null == data) {
			throw new RuntimeException("Data cannot be null");
		}
		root = insert(data, root);
	}

	public AVLNode<T> insert(T data, AVLNode<T> temNode) {
		if (temNode == null) {
			temNode = new AVLNode<T>(data);
		} else if (data.compareTo(temNode.data) < 0) {
			temNode.left = insert(data, temNode.left);

			if (getHeight(temNode.left) - getHeight(temNode.right) >= 2) {
				// left left child
				if (data.compareTo(temNode.left.data) < 0) {
					temNode = singleRotateLeft(temNode);
				} else if (data.compareTo(temNode.left.data) > 0) {
					// left right child
					temNode = doubleRotateWithLeft(temNode);
				}
			}
		} else if (data.compareTo(temNode.data) > 0) {
			temNode.right = insert(data, temNode.right);

			if (getHeight(temNode.right) - getHeight(temNode.left) >= 2) {
				// right left child
				if (data.compareTo(temNode.left.data) < 0) {
					temNode = doubleRotateWithRight(temNode);
				} else if (data.compareTo(temNode.left.data) > 0) {
					// right right child
					temNode = singleRotateRight(temNode);
				}
			}
		} else if (data.compareTo(temNode.data) == 0) {
			throw new RuntimeException("Data cannot be duplicated");
		}

		temNode.height = Math.max(getHeight(temNode.left), getHeight(temNode.right)) + 1;

		return temNode;
	}

	private AVLNode<T> singleRotateLeft(AVLNode<T> temNode) {

		AVLNode<T> temRootNode = temNode.left;
		temNode.left = temRootNode.right;
		temRootNode.right = temNode;

		temNode.height = Math.max(getHeight(temNode.left), getHeight(temNode.right)) + 1;
		temRootNode.height = Math.max(getHeight(temRootNode.left), temNode.height) + 1;

		return temRootNode;
	}

	private AVLNode<T> singleRotateRight(AVLNode<T> temNode) {

		AVLNode<T> temRootNode = temNode.right;
		temNode.right = temRootNode.left;
		temRootNode.left = temNode;

		temNode.height = Math.max(getHeight(temNode.left), getHeight(temNode.right)) + 1;
		temRootNode.height = Math.max(temNode.height, getHeight(temRootNode.right)) + 1;

		return temRootNode;
	}

	private AVLNode<T> doubleRotateWithLeft(AVLNode<T> temNode) {

		temNode.left = singleRotateRight(temNode.left);
		return singleRotateLeft(temNode);
	}

	private AVLNode<T> doubleRotateWithRight(AVLNode<T> temNode) {

		temNode.right = singleRotateLeft(temNode.right);
		return singleRotateRight(temNode);
	}

	public int getHeight(AVLNode<T> p) {
		return p == null ? -1 : p.height;
	}
}
