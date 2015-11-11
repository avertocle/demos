package vds.binarytree;

import vds.interfaces.DrawableBinaryTree;

public class TreeDrawerTest {

	public static void main(String args[]) {
		TreeDrawerTest treeDrawerTest = new TreeDrawerTest();
		treeDrawerTest.test1();
	}

	public void test1() {
		Tree n00 = new Tree(1);
		Tree n10 = new Tree(2);
		Tree n11 = new Tree(3);
		Tree n20 = new Tree(4);
		Tree n21 = new Tree(5);
		Tree n22 = new Tree(6);
		Tree n23 = new Tree(7);

		n00.left = n10;
		n00.right = n11;

		n10.left = n20;
		n10.right = n21;

		n11.left = n22;
		n11.right = n23;

		Visualizer.draw(n00);

	}

	public void test2() {
		Tree n00 = new Tree(1);
		Tree n10 = new Tree(2);
		Tree n11 = new Tree(3);
		Tree n20 = new Tree(4);
		Tree n21 = new Tree(5);
		Tree n22 = new Tree(6);
		Tree n23 = new Tree(7);

		n00.left = n10;
		n00.right = n11;

		n10.left = n20;
		n10.right = n21;

		n11.left = n22;
		n11.right = n23;

		Visualizer.draw(n00);

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
