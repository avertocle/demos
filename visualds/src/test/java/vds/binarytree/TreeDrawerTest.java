package vds.binarytree;

import vds.interfaces.DrawableBinaryTree;

public class TreeDrawerTest {

	public static void main(String args[]) {
		TreeDrawerTest treeDrawerTest = new TreeDrawerTest();
		treeDrawerTest.test1();
		treeDrawerTest.test2();
	}

	public void test1() {
		Tree node = makeTree(1, 127);
		Visualizer.draw(node);
	}

	public void test2() {
		Tree node = makeTree(1, 127);
		node.left.left.left = null;
		node.left.left.right.right.left = null;
		node.left.left.right.right.right = null;
		Visualizer.draw(node);
	}

	private Tree makeTree(int s, int e) {
		if (s > e) {
			return null;
		}
		int m = s + (e - s) / 2;
		Tree node = new Tree(m);
		node.left = makeTree(s, m - 1);
		node.right = makeTree(m + 1, e);
		return node;
	}

	public class Tree implements DrawableBinaryTree {

		private int data;
		private Tree left;
		private Tree right;

		public Tree(int data) {
			super();
			this.data = data;
		}

		@Override
		public DrawableBinaryTree getLeftChild() {
			return left;
		}

		@Override
		public DrawableBinaryTree getRightChild() {
			return right;
		}

		@Override
		public String getData() {
			return String.valueOf(data);
		}
	}

}
